package dev.xue.repositories.jdbc;

import dev.xue.models.Employee;
import dev.xue.models.User;
import dev.xue.repositories.EmployeeRepo;
import dev.xue.repositories.UserRepo;
import dev.xue.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC implements EmployeeRepo {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Employee add(Employee employee) {
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from employees where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),//id
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"), //firstname
                        rs.getString("employee_password"),//lastname
                        rs.getString("department"),
                        rs.getBoolean("is_dpt_head"),
                        rs.getBoolean("is_supervisor"),
                        rs.getBoolean("is_ben_co"),
                        rs.getInt("department_head_id"),
                        rs.getInt("supervisor_id"),
                        rs.getInt("ben_co_id"),
                        rs.getFloat("tuition_left")

                );
                return e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return null;
    }

    public Employee getByUsername(String username) {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from employees where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),//id
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"), //firstname
                        rs.getString("employee_password"),//lastname
                        rs.getString("department"),
                        rs.getBoolean("is_dpt_head"),
                        rs.getBoolean("is_supervisor"),
                        rs.getBoolean("is_ben_co"),
                        rs.getInt("department_head_id"),
                        rs.getInt("supervisor_id"),
                        rs.getInt("ben_co_id"),
                        rs.getFloat("tuition_left")

                );
                return e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // try-with-resources - automatically closes resources after execution
//        finally {
//            conn.close();
//        }

        return null;
    }

    @Override
    public List<Employee> getAll() {

        List<Employee> users = new ArrayList<Employee>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from users";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee u = new Employee(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                users.add(u);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void updateTuition(float curTuition, int id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update employees set tuition_left = ? where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setFloat(1, curTuition);
            ps.setInt(2, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
