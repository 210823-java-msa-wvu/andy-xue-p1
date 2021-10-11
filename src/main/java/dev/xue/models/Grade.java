package dev.xue.models;

public class Grade {

    private int gradeID;
    private int employeeID;
    private int requestID;
    private Float passingScore;
    private Float score;

    public Grade() {
    }

    public Grade(int employeeID, int requestID, Float passingScore, Float score) {
        this.employeeID = employeeID;
        this.requestID = requestID;
        this.passingScore = passingScore;
        this.score = score;
    }


    public Grade(int gradeID, int employeeID, int requestID, Float passingScore, Float score) {
        this.gradeID = gradeID;
        this.employeeID = employeeID;
        this.requestID = requestID;
        this.passingScore = passingScore;
        this.score = score;
    }


    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public Float getPassingScore() {
        return passingScore;
    }

    public void setPassingScore(Float passingScore) {
        this.passingScore = passingScore;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "gradeID=" + gradeID +
                ", employeeID=" + employeeID +
                ", requestID=" + requestID +
                ", passingScore=" + passingScore +
                ", score=" + score +
                '}';
    }
}
