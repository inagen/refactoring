package ru.akirakozov.sd.refactoring.executor;

import ru.akirakozov.sd.refactoring.database.Database;
import ru.akirakozov.sd.refactoring.html.HtmlWriter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetQueryExecutor extends AbstractExecutor {

    public GetQueryExecutor(Database db) {
        super(db);
    }

    @Override
    protected String htmlOption(ResultSet rs) throws SQLException {
        return HtmlWriter.writeBody(rs);
    }

    @Override
    public String query() {
        return "SELECT * FROM PRODUCT";
    }

    @Override
    public String title() {
        return null;
    }
}