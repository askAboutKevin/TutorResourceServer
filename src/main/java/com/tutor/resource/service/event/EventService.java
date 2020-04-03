package com.tutor.resource.service.event;

import com.tutor.resource.dal.dao.EventDAO;
import com.tutor.resource.model.Event;

import java.util.Date;
import java.util.List;

public class EventService {

    private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public List<Event> selectAllEvents() {
        List<Event> events = this.eventDAO.selectAllEvents();
        return events;
    }

    public Event selectEventById(int id) {
        Event event = this.eventDAO.selectEventById(id);
        return event;
    }

    public int insertEvent(String title, Date start, Date end, String location, String contact, String details, String reoccurring) {
        int addedEvent = this.eventDAO.insertEvent(title, start, end, location, contact, details, reoccurring);
        return addedEvent;
    }

    public int updateEvent(String title, Date start, Date end, String location, String contact, String details, String reoccurring, int id) {
        int updatedEvent = this.eventDAO.updateEvent(title, start, end, location, contact, details, reoccurring, id);
        return updatedEvent;
    }

    public int deleteEvent(int id) {
        int deletedEvents = this.eventDAO.deleteEvent(id);
        return deletedEvents;
    }

}
