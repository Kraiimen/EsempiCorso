package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementFiller {
    void fillStatement(PreparedStatement ps) throws DataException;
}
