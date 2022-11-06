package ru.akirakozov.sd.refactoring.executor;

import ru.akirakozov.sd.refactoring.database.Database;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;


public class UnknownQueryExecutor extends AbstractExecutor {

    String command;

    public UnknownQueryExecutor(Database db, String command) {
        super(db);
        this.command = command;
    }

    @Override
    public void execute(HttpServletResponse response) throws IOException {
        response.getWriter().println("Unknown command: " + command);
    }

    @Override
    protected String htmlOption(ResultSet rs) {
        return "";
    }

    @Override
    public String query() {
        return null;
    }

    @Override
    public String title() {
        return command;
    }
}