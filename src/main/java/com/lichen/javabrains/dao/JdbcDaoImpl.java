package com.lichen.javabrains.dao;

import com.lichen.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcDaoImpl {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String getCircleName(int circleId){
        String sql = "SELECT NAME FROM circle WHERE id = ?";
        return  jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
    }

    public Circle getCircle(int circleId) {
        String sql = "SELECT * FROM circle WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle> {

        public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(resultSet.getInt("ID"));
            circle.setName(resultSet.getString("NAME"));
            return  circle;
        }
    }

    public List<Circle> getALlCircle() {
        String sql = "SELECT * FROM circle";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

//    public void insertCircle(Circle circle) {
//        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)";
//        jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
//    }

    public void insertCircle(Circle circle) {
        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
                .addValue("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }


    public void createTriangleTable() {
        String sql = "CREATE TABLE TRIANGLE(ID INTEGER, NAME VARCHAR(30))";
        jdbcTemplate.execute(sql);
    }

}
