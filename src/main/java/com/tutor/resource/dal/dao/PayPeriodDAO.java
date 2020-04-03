package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.PartnerUniversityMapper;
import com.tutor.resource.dal.mapper.PayPeriodMapper;
import com.tutor.resource.model.PayPeriod;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;


import java.util.List;

public interface PayPeriodDAO {

    @SqlQuery("SELECT id, school, start, end, pay_serve_no, comments FROM Pay_Period WHERE end = ?")
    @RegisterRowMapper(PayPeriodMapper.class)
    List<PayPeriod> selectPayPeriodForToday(String today);

    @SqlUpdate("INSERT INTO Pay_Period (school, start, end, pay_serve_no, comments) VALUES (?, ?, ?, ?, ?)")
    int insertPayPeriod(int school, String start, String end, String payServeNo, String comments);

}
