package com.tutor.resource.service.resource;

import com.tutor.resource.dal.dao.ResourceDAO;
import com.tutor.resource.model.Resource;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class ResourceService {

    private ResourceDAO resourceDAO;

    public ResourceService(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    public List<Resource> selectAllResources() {
        List<Resource> resources = this.resourceDAO.selectAllResources();
        return resources;
    }

    public Resource selectResourceById(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        Resource resource = this.resourceDAO.selectResourceById(id);
        return resource;
    }

    public int insertResource(String title, String locator, int owner) {
        int addedResource = this.resourceDAO.insertResource(title, locator, owner);
        return addedResource;
    }

    public int updateResource(String title, String locator, int owner, int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        int updatedResource = this.resourceDAO.updateResource(title, locator, owner, id);
        return updatedResource;
    }

    public int deleteResource(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        int deletedResources = this.resourceDAO.deleteResource(id);
        return deletedResources;
    }

}
