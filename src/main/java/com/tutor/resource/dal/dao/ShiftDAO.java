package com.tutor.resource.dal.dao;

import java.util.List;

import com.tutor.resource.dal.mapper.ShiftMapper;
import com.tutor.resource.model.Shift;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;


public interface ShiftDAO {

    @SqlQuery("SELECT id, user, date, time_in, time_out, lunch_out, lunch_in, logged, total_time FROM Shift WHERE user = ?")
    @RegisterRowMapper(ShiftMapper.class)
    List<Shift> selectAllShiftsForUser(String user);

//    @SqlQuery("SELECT id, user, date, time_in, time_out, lunch_out, lunch_in, logged, total_time FROM Shift WHERE date >= ? AND date <= ? WHERE user = ?")
//    @RegisterRowMapper(ShiftMapper.class)
//    List<Shift> selectAllShiftsInPayPeriod(String periodStart, String periodEnd, String user);

    @SqlUpdate("INSERT INTO Shift (user, date, time_in, time_out, lunch_out, lunch_in, total_time) VALUES (?, CURDATE(), ?, ?, ?, ?, ?)")
    int insertShift(String user, String timeIn, String timeOut, String lunchOut, String lunchIn, float totalTime);

//    @SqlUpdate("UPDATE Shift SET logged = true WHERE id = ?")
//    int updateShift(List<Integer> ids);

}