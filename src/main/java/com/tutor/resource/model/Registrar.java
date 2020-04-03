package com.tutor.resource.model;

public class Registrar {

    private String user;
    private boolean isPrivileged;
    private String deviceId;
    private String sessionExpires;

    public Registrar(String user, boolean isPrivileged, String deviceId, String sessionExpires) {
        this.user = user;
        this.isPrivileged = isPrivileged;
        this.deviceId = deviceId;
        this.sessionExpires = sessionExpires;
    }

    public Registrar(String user, boolean isPrivileged, String deviceId) {
        this.user = user;
        this.isPrivileged = isPrivileged;
        this.deviceId = deviceId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isPrivileged() {
        return isPrivileged;
    }

    public void setPrivileged(boolean privileged) {
        isPrivileged = privileged;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSessionExpires() {
        return sessionExpires;
    }

    public void setSessionExpires(String sessionExpires) {
        this.sessionExpires = sessionExpires;
    }
}