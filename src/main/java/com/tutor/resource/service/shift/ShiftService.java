package com.tutor.resource.service.shift;

import com.tutor.resource.dal.dao.ShiftDAO;
import com.tutor.resource.model.Shift;

import java.util.List;

public class ShiftService {

    private ShiftDAO shiftDAO;

    public ShiftService(ShiftDAO shiftDAO) {
        this.shiftDAO = shiftDAO;
    }

    public List<Shift> getAllShiftsForUser(String user) {
        List<Shift> shifts = this.shiftDAO.selectAllShiftsForUser(user);
        return shifts;
    }

    public List<Shift> getAllShiftsInPayPeriod(String periodStart, String periodEnd, String user) {

        List<Shift> shifts = this.shiftDAO.selectAllShiftsInPayPeriod(periodStart, periodEnd, user);
        return shifts;
    }

    public int addShift(String user, String timeIn, String timeOut, String lunchOut, String lunchIn) {

        float totalTime = 0;

        int addedShifts = this.shiftDAO.insertShift(user, timeIn, timeOut, lunchOut, lunchIn, totalTime);

        return addedShifts;
    }

    public int updateShift(List<Integer> ids) {
        int updatedShifts = this.shiftDAO.updateShift(ids);
        return updatedShifts;
    }

}
