package com.tutor.resource.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class DailyLog {

    private int id;
    private String tutorId;
    private String tutorName;
    private String dateOfTutoring;
    private float timeInSchool;
    private int numOfIndividualStudentsTutored;
    private int numOfStudentGroupsTutored;
    private String tuteeFirstName;
    private String tuteeLastName;
    private String tuteeId;
    private float timeSpentOneOnOne;
    private float timeSpentSmallGroup;
    private String sessionMaterial;

    public DailyLog(int id, String tutorId, String tutorName, String dateOfTutoring, float timeInSchool, int numOfIndividualStudentsTutored, int numOfStudentGroupsTutored, String tuteeFirstName, String tuteeLastName, String tuteeId, float timeSpentOneOnOne, float timeSpentSmallGroup, String sessionMaterial) {
        this.id = id;
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.dateOfTutoring = dateOfTutoring;
        this.timeInSchool = timeInSchool;
        this.numOfIndividualStudentsTutored = numOfIndividualStudentsTutored;
        this.numOfStudentGroupsTutored = numOfStudentGroupsTutored;
        this.tuteeFirstName = tuteeFirstName;
        this.tuteeLastName = tuteeLastName;
        this.tuteeId = tuteeId;
        this.timeSpentOneOnOne = timeSpentOneOnOne;
        this.timeSpentSmallGroup = timeSpentSmallGroup;
        this.sessionMaterial = sessionMaterial;
    }

    // Constructor for incoming requests
    @JsonCreator
    public DailyLog(@JsonProperty("tutorId") String tutorId,
                    @JsonProperty("tutorName") String tutorName,
                    @JsonProperty("dateOfTutoring") String dateOfTutoring,
                    @JsonProperty("timeInSchool") float timeInSchool,
                    @JsonProperty("numOfIndividualStudentsTutored") int numOfIndividualStudentsTutored,
                    @JsonProperty("numOfStudentGroupsTutored") int numOfStudentGroupsTutored,
                    @JsonProperty("tuteeFirstName") String tuteeFirstName,
                    @JsonProperty("tuteeLastName") String tuteeLastName,
                    @JsonProperty("tuteeId") String tuteeId,
                    @JsonProperty("timeSpentOneOnOne") float timeSpentOneOnOne,
                    @JsonProperty("timeSpentSmallGroup") float timeSpentSmallGroup,
                    @JsonProperty("sessionMaterial") String sessionMaterial) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.dateOfTutoring = dateOfTutoring;
        this.timeInSchool = timeInSchool;
        this.numOfIndividualStudentsTutored = numOfIndividualStudentsTutored;
        this.numOfStudentGroupsTutored = numOfStudentGroupsTutored;
        this.tuteeFirstName = tuteeFirstName;
        this.tuteeLastName = tuteeLastName;
        this.tuteeId = tuteeId;
        this.timeSpentOneOnOne = timeSpentOneOnOne;
        this.timeSpentSmallGroup = timeSpentSmallGroup;
        this.sessionMaterial = sessionMaterial;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnName("tutor_id")
    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    @ColumnName("tutor_name")
    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    @ColumnName("date_of_tutoring")
    public String getDateOfTutoring() {
        return dateOfTutoring;
    }

    public void setDateOfTutoring(String dateOfTutoring) {
        this.dateOfTutoring = dateOfTutoring;
    }

    @ColumnName("time_in_school")
    public float getTimeInSchool() {
        return timeInSchool;
    }

    public void setTimeInSchool(float timeInSchool) {
        this.timeInSchool = timeInSchool;
    }

    @ColumnName("num_of_individual_students_tutored")
    public int getNumOfIndividualStudentsTutored() {
        return numOfIndividualStudentsTutored;
    }

    public void setNumOfIndividualStudentsTutored(int numOfIndividualStudentsTutored) {
        this.numOfIndividualStudentsTutored = numOfIndividualStudentsTutored;
    }

    @ColumnName("num_of_student_groups_tutored")
    public int getNumOfStudentGroupsTutored() {
        return numOfStudentGroupsTutored;
    }

    public void setNumOfStudentGroupsTutored(int numOfStudentGroupsTutored) {
        this.numOfStudentGroupsTutored = numOfStudentGroupsTutored;
    }

    @ColumnName("tutee_first_name")
    public String getTuteeFirstName() {
        return tuteeFirstName;
    }

    public void setTuteeFirstName(String tuteeFirstName) {
        this.tuteeFirstName = tuteeFirstName;
    }

    @ColumnName("tutee_last_name")
    public String getTuteeLastName() {
        return tuteeLastName;
    }

    public void setTuteeLastName(String tuteeLastName) {
        this.tuteeLastName = tuteeLastName;
    }

    @ColumnName("tutee_id")
    public String getTuteeId() {
        return tuteeId;
    }

    public void setTuteeId(String tuteeId) {
        this.tuteeId = tuteeId;
    }

    @ColumnName("time_spent_one_on_one")
    public float getTimeSpentOneOnOne() {
        return timeSpentOneOnOne;
    }

    public void setTimeSpentOneOnOne(float timeSpentOneOnOne) {
        this.timeSpentOneOnOne = timeSpentOneOnOne;
    }

    @ColumnName("time_spent_small_group")
    public float getTimeSpentSmallGroup() {
        return timeSpentSmallGroup;
    }

    public void setTimeSpentSmallGroup(float timeSpentSmallGroup) {
        this.timeSpentSmallGroup = timeSpentSmallGroup;
    }

    @ColumnName("session_material")
    public String getSessionMaterial() {
        return sessionMaterial;
    }

    public void setSessionMaterial(String sessionMaterial) {
        this.sessionMaterial = sessionMaterial;
    }
}