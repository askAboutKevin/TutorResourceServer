package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.ResourceMapper;
import com.tutor.resource.model.Resource;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.List;


public interface ResourceDAO {

    @SqlQuery("SELECT id, title, locator, owner FROM Resource")
    @RegisterRowMapper(ResourceMapper.class)
    List<Resource> selectAllResources();

    @SqlQuery("SELECT id, title, locator, owner FROM Resource WHERE id = ?")
    @RegisterRowMapper(ResourceMapper.class)
    Resource selectResourceById(int id);

    @SqlUpdate("INSERT INTO Resource (title, locator, owner) VALUES (?, ?, ?)")
    int insertResource(String title, String locator, int owner);

    @SqlUpdate("UPDATE Resource SET title = ?, locator = ?, owner = ? WHERE id = ?")
    int updateResource(String title, String locator, int owner, int id);

    @SqlUpdate("DELETE FROM Resource WHERE id = ?")
    int deleteResource(int id);

}
