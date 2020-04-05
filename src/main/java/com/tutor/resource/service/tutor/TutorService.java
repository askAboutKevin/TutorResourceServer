package com.tutor.resource.service.tutor;

import com.tutor.resource.dal.dao.TutorDAO;
import com.tutor.resource.model.Tutor;
import com.tutor.resource.util.PasswordHashSHA512;
import com.tutor.resource.util.SecureSalt;
import com.tutor.resource.util.UniqueIdGenerator;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class TutorService {

    private TutorDAO tutorDAO;

    public TutorService(TutorDAO tutorDAO) {
        this.tutorDAO = tutorDAO;
    }

    public List<Tutor> selectAllTutors() {

        return this.tutorDAO.selectAllTutors();
    }

    public Tutor selectTutorById(String id) {

        if(id.length() < 8) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return this.tutorDAO.selectTutorById(id);
    }

    public Tutor selectTutorByEmail(String email) {

        if(email.length() < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return this.tutorDAO.selectTutorByEmail(email);
    }

    public int insertTutor(String topic, String firstName, String lastName, int school, int university, String supervisor, int department, String password, String email, String number) {

        String id = UniqueIdGenerator.generate("user");
        String salt = SecureSalt.generateSalt();
        String hash = PasswordHashSHA512.get_SHA_1_SecurePassword(password, salt);

        return this.tutorDAO.insertTutor(id, topic, firstName, lastName, school, university, supervisor, department, salt, hash, email, number);
    }

    public int updateTutorUsernamePassword(String password, String email, String number, String id) {

        if(id.length() < 8) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        // Future Add A Function to select whether we're changing the password, email or number

        String salt = SecureSalt.generateSalt();
        String hash = PasswordHashSHA512.get_SHA_1_SecurePassword(password, salt);

        return this.tutorDAO.updateTutorUsernamePassword(salt, hash, email, number, id);
    }

    public int deleteTutor(String id) {

        if(id.length() < 8) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.tutorDAO.deleteTutor(id);
    }

}
