package org.generation.italy.jdbc;

import java.sql.PreparedStatement;

public interface PreparedStatementFiller {
    void fillStatement(PreparedStatement ps);
}
