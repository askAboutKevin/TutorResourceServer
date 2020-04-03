package com.tutor.resource.service.dailyLog;

import com.tutor.resource.dal.dao.DailyLogDAO;
import com.tutor.resource.model.DailyLog;

import java.util.Date;
import java.util.List;

public class DailyLogService {

    private DailyLogDAO dailyLogDAO;

    public DailyLogService(DailyLogDAO dailyLogDAO) {
        this.dailyLogDAO = dailyLogDAO;
    }

    public List<DailyLog> getDailyLogs() {

        List<DailyLog> dailyLogs = this.dailyLogDAO.selectAllDailyLogs();

        return dailyLogs;
    }

    public List<DailyLog> getDailyLogsByTutor(String id) {

        List<DailyLog> dailyLogs = this.dailyLogDAO.selectAllDailyLogsByTutor(id);

        return dailyLogs;
    }

    public int createDailyLog(String tutorId, String tutorName, String dateOfTutoring, float timeInSchool, int numOfIndividualStudentsTutored,
                              int numOfStudentGroupsTutored, String tuteeFirstName, String tuteeLastName, String tuteeId, float timeSpentOneOnOne, float timeSpentSmallGroup,
                              String sessionMaterial) {
        int createdDailyLogs = this.dailyLogDAO.insertDailyLog(tutorId, tutorName, dateOfTutoring, timeInSchool, numOfIndividualStudentsTutored, numOfStudentGroupsTutored, tuteeFirstName, tuteeLastName, tuteeId, timeSpentOneOnOne, timeSpentSmallGroup, sessionMaterial);
        return  createdDailyLogs;
    }

    public int changeDailyLog(Date dateOfTutoring, float timeInSchool, int numOfIndividualStudentsTutored,
                               int numOfStudentGroupsTutored, String tuteeFirstName, String tuteeLastName, String tuteeId, float timeSpentOneOnOne, float timeSpentSmallGroup,
                               String sessionMaterial, int id) {
        int updatedDailyLogs = this.dailyLogDAO.updateDailyLog(
                dateOfTutoring, timeInSchool, numOfIndividualStudentsTutored, numOfStudentGroupsTutored, tuteeFirstName, tuteeLastName, tuteeId, timeSpentOneOnOne, timeSpentSmallGroup, sessionMaterial, id
        );

        return updatedDailyLogs;
    }

    public int deleteDailyLog(int id) {
        int deletedDailyLogs = this.dailyLogDAO.deleteDailyLog(id);

        return deletedDailyLogs;
    }


}
