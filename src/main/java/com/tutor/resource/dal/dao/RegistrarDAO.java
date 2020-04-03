package com.tutor.resource.dal.dao;


import com.tutor.resource.dal.mapper.RegistrarMapper;
import com.tutor.resource.model.Registrar;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import java.util.List;

public interface RegistrarDAO {

    @SqlQuery("SELECT id, user, type, device_id, session_expires FROM Registrar WHERE device_id = ?")
    @RegisterRowMapper(RegistrarMapper.class)
    Registrar selectRegistrarByDeviceId(String deviceId);

    @SqlUpdate("INSERT INTO Registrar (user, isPriviliged, device_id, session_expires) VALUES (?, ?, ?, DATE_ADD('?', INTERVAL 12 HOUR))")
    int insertRegistry(String user, String type, String deviceId, String sessionExpiration);

    @SqlUpdate("UPDATE Registrar SET session_expires = DATE_ADD('?', INTERVAL 12 HOUR) WHERE device_id = ?")
    int updateRegistry(String sessionExpiration, String deviceId);
}
