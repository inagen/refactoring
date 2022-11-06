package ru.akirakozov.sd.refactoring.executor;


import ru.akirakozov.sd.refactoring.database.Database;
import ru.akirakozov.sd.refactoring.html.HtmlWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class AbstractExecutor {

    private final Database db;

    public AbstractExecutor(Database db) {
        this.db = db;
    }

    public void execute(HttpServletResponse response) throws SQLException, IOException {
        ResultSet rs = db.executeWithResult(query());
        HtmlWriter.writeHtml(title(), htmlOption(rs), response.getWriter());
        rs.close();

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    protected abstract String htmlOption(ResultSet rs) throws SQLException;

    public abstract String query();

    public abstract String title();

}