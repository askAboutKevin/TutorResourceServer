package com.tutor.resource.dal.dao;

import java.util.Date;
import java.util.List;
import com.tutor.resource.dal.mapper.PrivilegedUserMapper;
import com.tutor.resource.model.PrivilegedUser;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

public interface PrivilegedUserDAO {

    @SqlQuery("SELECT id, first_name, last_name, salt, password, email, number, title, role, last_logged_in, picture FROM Privileged_User")
    @RegisterRowMapper(PrivilegedUserMapper.class)
    List<PrivilegedUser> selectAllPrivilegedUsers();

    @SqlQuery("SELECT id, first_name, last_name, salt, password, email, contact, last_logged_in, title, role, picture FROM Privileged_User WHERE id = ?")
    @RegisterRowMapper(PrivilegedUserMapper.class)
    PrivilegedUser selectPrivilegedUserById(String id);

    @SqlUpdate("INSERT INTO Privileged_User (id, first_name, last_name, salt, password_hash, email, contact_number, title, role, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")
    int insertPrivilegedUser(String id, String firstName, String lastName, String salt, String passwordHash, String email, String contactNumber, String title, String role, String portfolioImage);

    @SqlUpdate("Privileged_User SET first_name = ?, last_name = ?, salt = ?, password = ?, email = ?, contact, title = ?, role = ?, picture = ? WHERE id = ?")
    int updatePrivilegedUser( String firstName, String lastName, String salt, String passwordHash, String email, String contactNumber, String title, String role, String portfolioImage, String id);

    @SqlUpdate("DELETE FROM Privileged_User WHERE id = ?")
    int deletePrivilegedUser(String id);
}
