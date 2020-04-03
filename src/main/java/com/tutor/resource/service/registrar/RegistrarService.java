package com.tutor.resource.service.registrar;

import com.tutor.resource.dal.dao.RegistrarDAO;
import com.tutor.resource.model.Registrar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrarService {

    private RegistrarDAO registrarDAO;

    public RegistrarService(RegistrarDAO registrarDAO) {
        this.registrarDAO = registrarDAO;
    }

    public Registrar selectRegistrarByDeviceId(String deviceId) {
        Registrar registrar = this.registrarDAO.selectRegistrarByDeviceId(deviceId);
        return registrar;
    }

    public int insertRegistry(String user, String type, String deviceId, String sessionExpiration) {

        int insertedRegistrar = this.registrarDAO.insertRegistry(user, type, deviceId, sessionExpiration);
        return insertedRegistrar;

    }

    public int updateRegistry(String sessionExpiration, String deviceId) {

        String now = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        int updatedRegistrar = this.registrarDAO.updateRegistry(now, deviceId);

        return updatedRegistrar;
    }

}
