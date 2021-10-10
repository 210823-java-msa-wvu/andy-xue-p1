package dev.xue.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="reimbursements")
public class Reimbursement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reimbursementID;

    @Column(name="employee_id")
    private int employeeID;

    @Column(name="description")
    private String description;

    @Column(name="event_type")
    private String eventType;

    @Column(name="justification")
    private String justification;

    @Column(name="reimbursement_date")
    private Date reimbursementDate;

    @Column(name="reimbursement_time")
    private Time reimbursementTime;

    @Column(name="employee_location")
    private String employeeLocation;

    @Column(name="grading_format")
    private String gradingFormat;

    @Column(name="reimbursement_cost")
    private float reimbursementCost;

    @Column(name="passing_grade")
    private float passingGrade;

    @Column(name="event_start")
    private Date eventStart;

    @Column(name="reimbursement_name")
    private String reimbursementName;

    public Reimbursement() {

    }

    public Reimbursement(int employeeID, String description, String eventType, String justification, Date reimbursementDate, Time reimbursementTime, String employeeLocation, String gradingFormat, float reimbursementCost, float passingGrade, Date eventStart, String reimbursementName) {
        this.employeeID = employeeID;
        this.description = description;
        this.eventType = eventType;
        this.justification = justification;
        this.reimbursementDate = reimbursementDate;
        this.reimbursementTime = reimbursementTime;
        this.employeeLocation = employeeLocation;
        this.gradingFormat = gradingFormat;
        this.reimbursementCost = reimbursementCost;
        this.passingGrade = passingGrade;
        this.eventStart = eventStart;
        this.reimbursementName = reimbursementName;
    }



    public Reimbursement(int reimbursementID, int employeeID, String description, String eventType, String justification, Date reimbursementDate, Time reimbursementTime, String employeeLocation, String gradingFormat, float reimbursementCost, float passingGrade, Date eventStart, String ReimbursementName) {
        this.reimbursementID = reimbursementID;
        this.employeeID = employeeID;
        this.description = description;
        this.eventType = eventType;
        this.justification = justification;
        this.reimbursementDate = reimbursementDate;
        this.reimbursementTime = reimbursementTime;
        this.employeeLocation = employeeLocation;
        this.gradingFormat = gradingFormat;
        this.reimbursementCost = reimbursementCost;
        this.passingGrade = passingGrade;
        this.eventStart = eventStart;
        this.reimbursementName = reimbursementName;

    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Date getReimbursementDate() {
        return reimbursementDate;
    }

    public void setReimbursementDate(Date reimbursementDate) {
        this.reimbursementDate = reimbursementDate;
    }

    public String getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }

    public String getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(String gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public float getReimbursementCost() {
        return reimbursementCost;
    }

    public void setReimbursementCost(float reimbursementCost) {
        this.reimbursementCost = reimbursementCost;
    }

    public float getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(float passingGrade) {
        this.passingGrade = passingGrade;
    }

    public Time getReimbursementTime() {
        return reimbursementTime;
    }
    public void setReimbursementTime(Time reimbursementTime) {
        this.reimbursementTime = reimbursementTime;
    }

    public Date getEventStart() {
        return eventStart;
    }

    public void setEventStart(Date eventStart) {
        this.eventStart = eventStart;
    }


    public String getReimbursementName() {
        return reimbursementName;
    }
    public void setReimbursementName(String reimbursementName) {
        this.reimbursementName = reimbursementName;
    }

    @Override
    public String toString() {
        return "Reimbursement{}";
    }
}
