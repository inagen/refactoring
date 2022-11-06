package ru.akirakozov.sd.refactoring.executor;

import ru.akirakozov.sd.refactoring.database.Database;
import ru.akirakozov.sd.refactoring.html.HtmlWriter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MinQueryExecutor extends AbstractExecutor {

    public MinQueryExecutor(Database db) {
        super(db);
    }

    @Override
    protected String htmlOption(ResultSet rs) throws SQLException {
        return HtmlWriter.writeBody(rs);
    }

    @Override
    public String query() {
        return "SELECT * FROM PRODUCT ORDER BY PRICE LIMIT 1";
    }

    @Override
    public String title() {
        return HtmlWriter.toHeader("Product with max price: ");
    }
}