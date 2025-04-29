package org.generation.italy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OurJdbcTemplate {
    private Connection con;

    public OurJdbcTemplate(Connection con) {
        this.con = con;
    }

    public <T> List<T> query(String sql, RowMapper<T> mapper, Object... params) throws DataException {
        List<T> results = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            setParameters(ps, params);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    T entity = mapper.mapRow(rs);
                    results.add(entity);
                }
                return results;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    public int update(String sql, Object... params) throws DataException {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            setParameters(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }


    public <T> Optional<T> queryForObject(String sql, RowMapper<T> mapper, Object... params) throws DataException {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            setParameters(ps, params);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapper.mapRow(rs));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }


    private void setParameters(PreparedStatement ps, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }
}
