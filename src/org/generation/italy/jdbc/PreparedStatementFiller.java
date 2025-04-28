package org.generation.italy.jdbc;

import org.generation.italy.bankProject.accounting.DataException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface PreparedStatementFiller {
    void fillStatement(PreparedStatement ps) throws SQLException;
}
