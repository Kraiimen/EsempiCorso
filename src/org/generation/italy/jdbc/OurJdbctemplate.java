package org.generation.italy.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OurJdbctemplate {
    //   /-----/-STATE-/-----/
    private Connection con;

    //   /-----/-CONSTRUCTORS-/-----/
    public OurJdbctemplate (Connection con) {
        this.con = con;
    }

    //   /-----/-METHODS-/-----/
// Voglio creare un metodo che mi permetta di fare query con qualsiasi oggetto
    //Spiegazione firma del metodo:
    //Questo è un metodo che lavorerà su oggetti generici di tipi T e ritornerà una lista di T
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

    //Voglio un metodo del template che posso usare quando faccio le FindById, che mi ritorna o niente o un singolo oggetto
    public <T> Optional<T> queryForObject(String sql, RowMapper<T> mapper, Object... params) throws DataException {
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            setParameters(ps, params);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    return Optional.of(mapper.mapRow(rs));
                }
                    return Optional.empty();
            }
        } catch(SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }



    //Voglio fare un metodo per mandare degli UPDATE di qualsiasi tipo(UPDATE, DELETE, ecc.)
    public int update(String sql, Object... params) throws DataException{
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            setParameters(ps, params);
            return ps.executeUpdate(); // Torna il numero di righe toccato dallo Statement
        } catch(SQLException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    private void setParameters(PreparedStatement ps, Object... params) throws SQLException{
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]); //i+1 perché il params nell'array creato dal var in posizione 0, ad esempio, andrà a settare il parametro 1, e così via
        }
    }
}
