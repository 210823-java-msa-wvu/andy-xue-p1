package dev.xue.models;



import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String department;

    private boolean isDptHead;
    private boolean isSupervisor;
    private boolean isBenCo;

    private int dptHeadId;
    private int supervisorId;
    private int benCoId;

    private float tuitionLeft = 1000;

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Employee(Integer id, String firstName, String lastName, String username, String password, String department, boolean isDptHead, boolean isSuperviosr, boolean isBenCo, int dptHeadId, int supervisorId, int benCoId, float tuitionLeft) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.department = department;
        this.isDptHead = isDptHead;
        this.isSupervisor = isSuperviosr;
        this.isBenCo = isBenCo;
        this.dptHeadId = dptHeadId;
        this.supervisorId = supervisorId;
        this.benCoId = benCoId;
        this.tuitionLeft = tuitionLeft;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getLastName(){ return lastName; }
    public void setLastName(String name){
        this.lastName = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public boolean isDptHead() {
        return isDptHead;
    }

    public void setDptHead(boolean dptHead) {
        isDptHead = dptHead;
    }

    public boolean isBenCo() {
        return isBenCo;
    }

    public void setBenCo(boolean benCo) {
        isBenCo = benCo;
    }

    public int getDptHeadId() {
        return dptHeadId;
    }

    public void setDptHeadId(int dptHeadId) {
        this.dptHeadId = dptHeadId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public int getBenCoId() {
        return benCoId;
    }

    public void setBenCoId(int benCoId) {
        this.benCoId = benCoId;
    }

    public boolean isSupervisor() {
        return isSupervisor;
    }

    public void setSupervisor(boolean supervisor) {
        isSupervisor = supervisor;
    }

    public float getTuitionLeft() {
        return tuitionLeft;
    }

    public void setTuitionLeft(float tuitionLeft) {
        this.tuitionLeft = tuitionLeft;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
