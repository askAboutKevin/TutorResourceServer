package com.tutor.resource.service.shift;

import com.tutor.resource.dal.dao.ShiftDAO;
import com.tutor.resource.model.Shift;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class ShiftService {

    private ShiftDAO shiftDAO;

    public ShiftService(ShiftDAO shiftDAO) {
        this.shiftDAO = shiftDAO;
    }

    public List<Shift> getAllShiftsForUser(String user) {

        if(user.length() < 8) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        return this.shiftDAO.selectAllShiftsForUser(user);
    }

//    public List<Shift> getAllShiftsInPayPeriod(String periodStart, String periodEnd, String user) {
//
//        List<Shift> shifts = this.shiftDAO.selectAllShiftsInPayPeriod(periodStart, periodEnd, user);
//        return shifts;
//    }

    public int addShift(String user, String timeIn, String timeOut, String lunchOut, String lunchIn) {

        if(user.length() < 8) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        // Add code to calculate the total time
        float totalTime = 0;

        return this.shiftDAO.insertShift(user, timeIn, timeOut, lunchOut, lunchIn, totalTime);
    }

//    public int updateShift(List<Integer> ids) {
//        int updatedShifts = this.shiftDAO.updateShift(ids);
//        return updatedShifts;
//    }

}
