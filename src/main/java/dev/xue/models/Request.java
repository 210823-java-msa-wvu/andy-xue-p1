package dev.xue.models;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int requestID;
    private int employeeID;
    private int reimbursementID;
    private String status;
    private boolean supervisorApproval;
    private boolean dptApproval;
    private boolean benCoApproval;
    private boolean urgent;
    private String deniedReason;

    public Request(){

    }
    public Request(int employeeID, int reimbursementID, String status, boolean supervisorApproval, boolean dptApproval, boolean benCoApproval, boolean urgent, String deniedReason) {
        this.employeeID = employeeID;
        this.reimbursementID = reimbursementID;
        this.status = status;
        this.supervisorApproval = supervisorApproval;
        this.dptApproval = dptApproval;
        this.benCoApproval = benCoApproval;
        this.urgent = urgent;
        this.deniedReason = deniedReason;
    }
    public Request(int requestID, int employeeID, int reimbursementID, String status, boolean supervisorApproval, boolean dptApproval, boolean benCoApproval, boolean urgent, String deniedReason) {
        this.requestID = requestID;
        this.employeeID = employeeID;
        this.reimbursementID = reimbursementID;
        this.status = status;
        this.supervisorApproval = supervisorApproval;
        this.dptApproval = dptApproval;
        this.benCoApproval = benCoApproval;
        this.urgent = urgent;
        this.deniedReason = deniedReason;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSupervisorApproval() {
        return supervisorApproval;
    }

    public void setSupervisorApproval(boolean supervisorApproval) {
        this.supervisorApproval = supervisorApproval;
    }

    public boolean isDptApproval() {
        return dptApproval;
    }

    public void setDptApproval(boolean dptApproval) {
        this.dptApproval = dptApproval;
    }

    public boolean isBenCoApproval() {
        return benCoApproval;
    }

    public void setBenCoApproval(boolean benCoApproval) {
        this.benCoApproval = benCoApproval;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getDeniedReason() {
        return deniedReason;
    }

    public void setDeniedReason(String deniedReason) {
        this.deniedReason = deniedReason;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestID=" + requestID +
                ", employeeID=" + employeeID +
                ", reimbursementID=" + reimbursementID +
                ", status='" + status + '\'' +
                ", supervisorApproval=" + supervisorApproval +
                ", dptApproval=" + dptApproval +
                ", benCoApproval=" + benCoApproval +
                ", urgent=" + urgent +
                '}';
    }
}
