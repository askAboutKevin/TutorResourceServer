package com.tutor.resource.service.payPeriod;

import com.tutor.resource.dal.dao.PayPeriodDAO;
import com.tutor.resource.model.PayPeriod;

import java.util.List;

public class PayPeriodService {

    private PayPeriodDAO payPeriodDAO;

    public PayPeriodService(PayPeriodDAO payPeriodDAO) {
        this.payPeriodDAO = payPeriodDAO;
    }

    public List<PayPeriod> selectPayPeriodForToday(String today) {
        List<PayPeriod> payPeriods = this.payPeriodDAO.selectPayPeriodForToday(today);
        return payPeriods;
    }

    public int addPayPeriod(int school, String start, String end, String payServeNo, String comments) {
        int insertPayPeriod = this.payPeriodDAO.insertPayPeriod(school, start, end, payServeNo, comments);
        return insertPayPeriod;
    }
}
