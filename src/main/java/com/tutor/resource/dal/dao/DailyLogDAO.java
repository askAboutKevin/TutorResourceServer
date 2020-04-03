package com.tutor.resource.dal.dao;

import com.tutor.resource.dal.mapper.DailyLogMapper;
import com.tutor.resource.model.DailyLog;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.Date;
import java.util.List;

public interface DailyLogDAO {

    @SqlQuery("SELECT id, tutor_id, tutor_name, date_of_tutoring, time_in_school, num_of_individual_students_tutored, num_of_student_groups_tutored, tutee_first_name, tutee_last_name, tutee_id, time_spent_one_on_one, time_spent_small_group, session_material")
    @RegisterRowMapper(DailyLogMapper.class)
    List<DailyLog> selectAllDailyLogs();

    @SqlQuery("SELECT id, tutor_id, tutor_name, date_of_tutoring, time_in_school, num_of_individual_students_tutored, num_of_student_groups_tutored, tutee_first_name, tutee_last_name, tutee_id, time_spent_one_on_one, time_spent_small_group, session_material WHERE tutor_id = ?")
    @RegisterRowMapper(DailyLogMapper.class)
    List<DailyLog> selectAllDailyLogsByTutor(String id);

    @SqlUpdate("INSERT INTO Daily_Log (tutor_id, tutor_name, date_of_tutoring, time_in_school, num_of_individual_students_tutored," +
            "num_of_student_groups_tutored, tutee_first_name, tutee_last_name," +
            "tutee_id, time_spent_one_on_one, time_spent_small_group, session_material)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
    @GetGeneratedKeys("id")
    int insertDailyLog(String tutorId, String tutorName, String dateOfTutoring, float timeInSchool, int numOfIndividualStudentsTutored,
                       int numOfStudentGroupsTutored, String tuteeFirstName, String tuteeLastName, String tuteeId, float timeSpentOneOnOne, float timeSpentSmallGroup,
                       String sessionMaterial);

    @SqlUpdate("UPDATE Daily_Log SET date_of_tutoring = ?, time_in_school = ?, num_of_individual_students_tutored = ?, num_of_student_groups_tutored = ?, tutee_first_name = ?, tutee_last_name = ?, tutee_id = ?, time_spent_one_on_one = ?, time_spent_small_group = ?, session_material = ? WHERE id = ?")
    int updateDailyLog(Date dateOfTutoring, float timeInSchool, int numOfIndividualStudentsTutored,
                       int numOfStudentGroupsTutored, String tuteeFirstName, String tuteeLastName, String tuteeId, float timeSpentOneOnOne, float timeSpentSmallGroup,
                       String sessionMaterial, int id);

    @SqlUpdate("DELETE FROM Daily_Log WHERE id = ?")
    int deleteDailyLog(int id);
}