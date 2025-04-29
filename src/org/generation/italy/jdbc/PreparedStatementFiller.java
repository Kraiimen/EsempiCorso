package org.generation.italy.jdbc;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface PreparedStatementFiller {
    void fillStatement(PreparedStatement ps) throws DataException;
}
