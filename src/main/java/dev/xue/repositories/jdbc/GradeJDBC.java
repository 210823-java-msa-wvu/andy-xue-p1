package dev.xue.repositories.jdbc;

import dev.xue.models.Grade;
import dev.xue.repositories.GradeRepo;
import dev.xue.repositories.ReimbursementRepo;
import dev.xue.utils.ConnectionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GradeJDBC implements GradeRepo {

    private static final Logger logger = LogManager.getLogger(ReimbursementRepo.class);
    private ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Grade add(Grade g) {
        try (Connection conn = cu.getConnection()) {

            String sql = "insert into grades values (default, ?, ?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, g.getEmployeeID());
            ps.setInt(2, g.getRequestID());
            ps.setFloat(3, g.getPassingScore());
            ps.setFloat(4, g.getScore());


            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return g;
    }

    @Override
    public Grade getById(Integer id) {
        return null;
    }

    @Override
    public List<Grade> getAll() {
        return null;
    }

    @Override
    public void update(Grade t) {

    }

    @Override
    public void delete(Integer id) {

    }
}
