package ru.akirakozov.sd.refactoring.executor;

import ru.akirakozov.sd.refactoring.database.Database;
import ru.akirakozov.sd.refactoring.html.HtmlWriter;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CountQueryExecutor extends AbstractExecutor {
    public CountQueryExecutor(Database db) {
        super(db);
    }

    @Override
    protected String htmlOption(ResultSet rs) throws SQLException {
        return HtmlWriter.writeNumber(rs);
    }

    @Override
    public String query() {
        return "SELECT COUNT(*) FROM PRODUCT";
    }

    @Override
    public String title() {
        return "Number of products: ";
    }
}