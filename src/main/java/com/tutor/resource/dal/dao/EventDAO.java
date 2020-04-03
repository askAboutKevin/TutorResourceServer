package com.tutor.resource.dal.dao;


import com.tutor.resource.dal.mapper.EventMapper;
import com.tutor.resource.model.Event;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.Date;
import java.util.List;

public interface EventDAO {

    @SqlQuery("SELECT id, title, start, end, location, contact, details, reoccurring FROM Event")
    @RegisterRowMapper(EventMapper.class)
    List<Event> selectAllEvents();

    @SqlQuery("SELECT id, title, start, end, location, contact, details, reoccurring FROM Event WHERE id = ?")
    @RegisterRowMapper(EventMapper.class)
    Event selectEventById(int id);

    @SqlUpdate("INSERT INTO Event (title, start, end, location, contact, details, reoccurring) VALUES (?, ?, ?, ?, ?, ?, ?)")
    int insertEvent(String title, Date start, Date end, String location, String contact, String details, String reoccurring);

    @SqlUpdate("UPDATE Event SET title = ?, start = ?, end = ?, location = ?, contact = ?, details = ?, reoccurring = ? WHERE id = ?")
    int updateEvent(String title, Date start, Date end, String location, String contact, String details, String reoccurring, int id);

    @SqlUpdate("DELETE FROM Event WHERE id = ?")
    int deleteEvent(int id);
}