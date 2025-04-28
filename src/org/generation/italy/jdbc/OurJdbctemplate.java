package org.generation.italy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OurJdbctemplate {
    //   /-----/-STATE-/-----/
    private Connection con;

    //   /-----/-CONSTRUCTORS-/-----/
    public OurJdbctemplate (Connection con) {
        this.con = con;
    }

    //   /-----/-METHODS-/-----/
// Voglio creare un metodo che mi permetta di fare query con qualsiasi oggetto
    public <T> List<T> query(String sql, RowMapper<T> mapper, Object... params) throws DataException{
        List<T> results = new ArrayList<>();
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            setParameters(ps, params);
            try(ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    T entity = mapper.mapRow(rs);
                    results.add(entity);
                }
                return results;
            }
        } catch (SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    private void setParameters(PreparedStatement ps, Object... params) throws SQLException{
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]); //i+1 perché il params nell'array creato dal var in posizione 0, ad esempio, andrà a settare il parametro 1, e così via
        }
    }

}
