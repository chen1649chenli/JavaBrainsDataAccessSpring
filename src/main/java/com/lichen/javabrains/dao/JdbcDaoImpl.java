package com.lichen.javabrains.dao;

import com.lichen.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getCircleCount() {
        String sql = "SELECT COUNT(*) FROM circle";
        return jdbcTemplate.queryForInt(sql);
    }

    public Circle getCircle(int circleId) {
        Connection conn = null;

        try{

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
            ps.setInt(1, circleId);

            Circle circle = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();

            return circle;
        }catch(Exception e){
            throw new RuntimeException();
        }finally {
            try{
                conn.close();
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }
    }
}
