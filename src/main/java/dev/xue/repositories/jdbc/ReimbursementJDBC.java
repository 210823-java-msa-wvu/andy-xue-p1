package dev.xue.repositories.jdbc;

import dev.xue.models.Reimbursement;
import dev.xue.repositories.ReimbursementRepo;
import dev.xue.utils.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReimbursementJDBC implements ReimbursementRepo {

    private static final Logger logger = LogManager.getLogger(ReimbursementRepo.class);
    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    public Reimbursement getById(Integer id) {

        // try-with-resources -> a way to initialize a resource that will then be closed after we're done with it
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from reimbursements where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks

            ps.setInt(1, id); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            logger.info("Getting a reimbursement from the database with ID = " + id);

            if (rs.next()) {
                Reimbursement r = new Reimbursement();

                r.setReimbursementID(rs.getInt("reimbursement_id"));
                r.setEmployeeID(rs.getInt("employee_id"));
                r.setDescription(rs.getString("description"));
                r.setEventType(rs.getString("event_type"));
                r.setJustification(rs.getString("justification"));
                r.setReimbursementDate(rs.getDate("reimbursement_date"));
                r.setReimbursementTime(rs.getTime("reimbursement_time"));
                r.setEmployeeLocation(rs.getString("employee_location"));
                r.setGradingFormat(rs.getString("grading_format"));
                r.setReimbursementCost(rs.getFloat("reimbursement_cost"));
                r.setPassingGrade(rs.getFloat("passing_grade"));
                r.setEventStart(rs.getDate("event_start"));

            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            //e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Reimbursement> getAll() {

        return null;
    }

    @Override
    public void update(Reimbursement t) {

    }

    @Override
    public void delete(Integer id) {

    }

    public Reimbursement add(Reimbursement r) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into reimbursements values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, r.getEmployeeID());
            ps.setString(2, r.getDescription());
            ps.setString(3, r.getEventType());
            ps.setString(4, r.getJustification());
            ps.setDate(5, r.getReimbursementDate());
            ps.setTime(6, r.getReimbursementTime());
            ps.setString(7, r.getEmployeeLocation());
            ps.setString(8, r.getGradingFormat());
            ps.setFloat(9, r.getReimbursementCost());
            ps.setFloat(10, r.getPassingGrade());
            ps.setDate(11, r.getEventStart());
            ps.setString(12, r.getReimbursementName());

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    public Reimbursement getByName(String name) {

        // try-with-resources -> a way to initialize a resource that will then be closed after we're done with it

        System.out.println("HELLO" + name);

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from reimbursements where reimbursement_name = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks

            ps.setString(1, name); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            logger.info("Getting a reimbursement from the database with ID = " + name);



            if (rs.next()) {
                Reimbursement r = new Reimbursement();

                r.setReimbursementID(rs.getInt("reimbursement_id"));
                r.setEmployeeID(rs.getInt("employee_id"));
                r.setDescription(rs.getString("description"));
                r.setEventType(rs.getString("event_type"));
                r.setJustification(rs.getString("justification"));
                r.setReimbursementDate(rs.getDate("request_date"));
                r.setReimbursementTime(rs.getTime("request_time"));
                r.setEmployeeLocation(rs.getString("employee_location"));
                r.setGradingFormat(rs.getString("grading_format"));
                r.setReimbursementCost(rs.getFloat("reimbursement_cost"));
                r.setPassingGrade(rs.getFloat("passing_grade"));
                r.setEventStart(rs.getDate("event_start"));
                r.setReimbursementName(rs.getString("reimbursement_name"));
                System.out.println("IF STATEMENT");

                return r;
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            //e.printStackTrace();
        }

        return null;
    }



}
