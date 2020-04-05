package com.tutor.resource.service.privilegedUser;

import com.tutor.resource.dal.dao.PrivilegedUserDAO;
import com.tutor.resource.model.PrivilegedUser;
import com.tutor.resource.util.PasswordHashSHA512;
import com.tutor.resource.util.SecureSalt;
import com.tutor.resource.util.UniqueIdGenerator;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class PrivilegedUserService {

    private PrivilegedUserDAO privilegedUserDAO;

    public PrivilegedUserService(PrivilegedUserDAO privilegedUserDAO) {
        this.privilegedUserDAO = privilegedUserDAO;
    }

    public List<PrivilegedUser> selectAllPrivilegedUsers() {

        List<PrivilegedUser> privilegedUsers = this.privilegedUserDAO.selectAllPrivilegedUsers();
        return privilegedUsers;
    }

    public PrivilegedUser selectPrivilegedUserById(String id) {

        if(id.length() < 8) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        PrivilegedUser privilegedUser = this.privilegedUserDAO.selectPrivilegedUserById(id);
        return privilegedUser;
    }

//    public int insertPrivilegedUser(String firstName, String lastName, String password, String email, String contactNumber, String title, String role, String portfolioImage) {
//
//        String id = UniqueIdGenerator.generate("user");
//        String salt = SecureSalt.generateSalt();
//        String hash = PasswordHashSHA512.get_SHA_1_SecurePassword(password, salt);
//
//        int addedPrivilegedUser = this.privilegedUserDAO.insertPrivilegedUser(
//                id, firstName, lastName, salt, hash, email, contactNumber, title, role, portfolioImage
//        );
//
//        return addedPrivilegedUser;
//    }
//
//    public int updatePrivilegedUser( String firstName, String lastName, String password, String email, String contactNumber, String title, String role, String portfolioImage, String id) {
//
//        if(id.length() < 8) {
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
//        }
//
//        String salt = SecureSalt.generateSalt();
//        String hash = PasswordHashSHA512.get_SHA_1_SecurePassword(password, salt);
//
//        int updatedPrivilegedUser = this.privilegedUserDAO.updatePrivilegedUser(firstName, lastName, salt, hash, email, contactNumber, title, role, portfolioImage, id);
//
//        return updatedPrivilegedUser;
//    }
//
//    public int deletePrivilegedUser(String id) {
//        if(id.length() < 8) {
//            throw new WebApplicationException(Response.Status.BAD_REQUEST);
//        }
//        int deletedPrivilegedUser = this.privilegedUserDAO.deletePrivilegedUser(id);
//        return deletedPrivilegedUser;
//    }
}
