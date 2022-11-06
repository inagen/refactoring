package ru.akirakozov.sd.refactoring.servlet;

import ru.akirakozov.sd.refactoring.database.Database;
import ru.akirakozov.sd.refactoring.executor.AbstractExecutor;
import ru.akirakozov.sd.refactoring.executor.ExecutorFabric;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static ru.akirakozov.sd.refactoring.Main.DB_NAME;

/**
 * @author akirakozov
 */
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AbstractExecutor executor = new ExecutorFabric().getExecutor(request, new Database(DB_NAME));
        try {
            executor.execute(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
