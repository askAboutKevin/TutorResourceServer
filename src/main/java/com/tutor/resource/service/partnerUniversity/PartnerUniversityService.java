package com.tutor.resource.service.partnerUniversity;

import com.tutor.resource.dal.dao.PartnerUniversityDAO;
import com.tutor.resource.model.PartnerUniversity;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class PartnerUniversityService {

    private PartnerUniversityDAO partnerUniversityDAO;

    public PartnerUniversityService(PartnerUniversityDAO partnerUniversityDAO) {
        this.partnerUniversityDAO = partnerUniversityDAO;
    }

    public List<PartnerUniversity> selectAllPartnerUniversities() {
        List<PartnerUniversity> partnerUniversities = this.partnerUniversityDAO.selectAllPartnerUniversities();
        return partnerUniversities;
    }

    public PartnerUniversity selectPartnerUniversityById(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        PartnerUniversity partnerUniversity = this.partnerUniversityDAO.selectPartnerUniversityById(id);
        return partnerUniversity;
    }

    public int insertPartnerUniversity(String name, String streetAddress, String city, String state, String zipCode) {
        int addedPartnerUniversity = this.partnerUniversityDAO.insertPartnerUniversity(
                name, streetAddress, city, state, zipCode
        );
        return addedPartnerUniversity;
    }

    public int updatePartnerUniversity(String name, String streetAddress, String city, String state, String zipCode, int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        int updatedPartnerUniversity = this.partnerUniversityDAO.updatePartnerUniversity(name, streetAddress, city, state, zipCode, id);
        return updatedPartnerUniversity;
    }

    public int deletePartnerUniversity(int id) {
        if(id < 1) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        int deletedPartnerUniversity = this.partnerUniversityDAO.deletePartnerUniversity(id);
        return deletedPartnerUniversity;
    }

}
