package dev.xue.repositories.jdbc;

import dev.xue.models.Request;
import dev.xue.repositories.ReimbursementRepo;
import dev.xue.repositories.RequestRepo;
import dev.xue.utils.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestJDBC implements RequestRepo {


    private static final Logger logger = LogManager.getLogger(ReimbursementRepo.class);
    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Request add(Request r) {
        try (Connection conn = cu.getConnection()) {

            String sql = "insert into requests values (default, ?, ?, ?, ?, ?, ?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, r.getEmployeeID());
            ps.setInt(2, r.getReimbursementID());
            ps.setString(3, r.getStatus());
            ps.setBoolean(4, r.isSupervisorApproval());
            ps.setBoolean(5, r.isDptApproval());
            ps.setBoolean(6, r.isBenCoApproval());
            ps.setBoolean(7, r.isUrgent());
            ps.setString(8, r.getDeniedReason());


            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public Request getById(Integer id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from requests where request_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("reimbursement_id"),
                        rs.getString("status"),
                        rs.getBoolean("supervisor_approval"),
                        rs.getBoolean("dept_approval"),
                        rs.getBoolean("ben_co_approval"),
                        rs.getBoolean("urgent"),
                        rs.getString("denied_reason")
                );
                System.out.println(r);
                return r;

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }





        return null;
    }

    @Override
    public List<Request> getAll() {


        List<Request> requests = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from requests";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("reimbursement_id"),
                        rs.getString("status"),
                        rs.getBoolean("supervisor_approval"),
                        rs.getBoolean("dept_approval"),
                        rs.getBoolean("ben_co_approval"),
                        rs.getBoolean("urgent"),
                        rs.getString("denied_reason")
                );
                System.out.println(r);
                requests.add(r);
            }
            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Request request) {
        List<Request> requests = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "UPDATE requests SET ben_co_approval = 'true' where request_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, request.getRequestID());

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Request> getRequestsForEmployee(Integer id) {


        List<Request> requests = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from requests where employee_id = ? order by request_id";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("reimbursement_id"),
                        rs.getString("status"),
                        rs.getBoolean("supervisor_approval"),
                        rs.getBoolean("dept_approval"),
                        rs.getBoolean("ben_co_approval"),
                        rs.getBoolean("urgent"),
                        rs.getString("denied_reason")
                );

                System.out.println(r);

                requests.add(r);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public List<Request> getPendingRequests() {


        List<Request> requests = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from requests where status = 'pending' order by request_id ";

            PreparedStatement ps = conn.prepareStatement(sql);



            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("reimbursement_id"),
                        rs.getString("status"),
                        rs.getBoolean("supervisor_approval"),
                        rs.getBoolean("dept_approval"),
                        rs.getBoolean("ben_co_approval"),
                        rs.getBoolean("urgent"),
                        rs.getString("denied_reason")
                );

                System.out.println(r);

                requests.add(r);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Request> getDptRequests(Integer id) {
        List<Request> requests = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select request_id, employee_id, reimbursement_id, status, supervisor_approval, dept_approval, ben_co_approval, urgent, denied_reason from requests\n" +
                    "inner join employees on requests.employee_id = employees.id\n" +
                    "where employees.department_head_id  = ? and status = 'pending' order by request_id; ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("reimbursement_id"),
                        rs.getString("status"),
                        rs.getBoolean("supervisor_approval"),
                        rs.getBoolean("dept_approval"),
                        rs.getBoolean("ben_co_approval"),
                        rs.getBoolean("urgent"),
                        rs.getString("denied_reason")
                );

                System.out.println(r);

                requests.add(r);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Request> getSupervisorRequests(Integer id) {
        List<Request> requests = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select request_id, employee_id, reimbursement_id, status, supervisor_approval, dept_approval, ben_co_approval, urgent, denied_reason from requests\n" +
                    "inner join employees on requests.employee_id = employees.id\n" +
                    "where employees.supervisor_id  = ? and status = 'pending' order by request_id; ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Request r = new Request(
                        rs.getInt("request_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("reimbursement_id"),
                        rs.getString("status"),
                        rs.getBoolean("supervisor_approval"),
                        rs.getBoolean("dept_approval"),
                        rs.getBoolean("ben_co_approval"),
                        rs.getBoolean("urgent"),
                        rs.getString("denied_reason")
                );

                System.out.println(r);

                requests.add(r);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void updateBenco(Boolean approval, Integer id, String rStatus) {


        try (Connection conn = cu.getConnection()) {

            String sql = "UPDATE requests SET ben_co_approval = ?, status = ? where request_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, approval);
            ps.setString(2, rStatus);
            ps.setInt(3, id);

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDptHead(boolean dptApproval, int requestID, String status) {

        try (Connection conn = cu.getConnection()) {

            String sql = "UPDATE requests SET dept_approval = ?, status = ? where request_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, dptApproval);
            ps.setString(2, status);
            ps.setInt(3, requestID);

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateSupervisor(boolean supervisorApproval, int requestID, String status, String reason) {
        try (Connection conn = cu.getConnection()) {

            String sql = "UPDATE requests SET dept_approval = ?, status = ?, denied_reason = ? where request_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setBoolean(1, supervisorApproval);
            ps.setString(2, status);
            ps.setString(3, reason);
            ps.setInt(4, requestID);

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
