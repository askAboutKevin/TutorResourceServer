package com.tutor.resource.auth;

import static com.tutor.resource.util.PasswordHashSHA512.get_SHA_1_SecurePassword;
import com.tutor.resource.dal.dao.PrivilegedUserDAO;
import com.tutor.resource.dal.dao.TutorDAO;
import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.model.Tutor;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;


import java.util.Optional;

public class CustomAuthenticator implements Authenticator<BasicCredentials, TutorResourceUser> {

    private TutorDAO tutorDAO;
    private PrivilegedUserDAO privilegedUserDAO;

    public CustomAuthenticator(TutorDAO tutorDAO, PrivilegedUserDAO privilegedUserDAO) {
        this.tutorDAO = tutorDAO;
        this.privilegedUserDAO = privilegedUserDAO;
    }

    @Override
    public Optional authenticate(BasicCredentials credentials) throws AuthenticationException {
        PrivilegedUser privilegedUser = this.privilegedUserDAO.selectPrivilegedUserById(credentials.getUsername());
        Tutor tutor = this.tutorDAO.selectTutorByEmail(credentials.getUsername());
        if(privilegedUser != null && correctCredentials(credentials.getPassword(), privilegedUser.getSalt(), privilegedUser.getPassword_hash())) {
            return Optional.of(new TutorResourceUser(privilegedUser));
        }
        else if(tutor != null && correctCredentials(credentials.getPassword(), tutor.getSalt(), tutor.getPassword_hash())) {
            return Optional.of(new TutorResourceUser(tutor));
        }
        return Optional.empty();
    }

    private static boolean correctCredentials(String password, String salt, String hash) {
         // Check to see if the given password plus the salt equals the hash of the given user
        if( get_SHA_1_SecurePassword(password,salt).equals(hash) ) {
            return true;
        }
        return false;
    }
}
