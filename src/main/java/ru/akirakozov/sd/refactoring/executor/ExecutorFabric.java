package ru.akirakozov.sd.refactoring.executor;

import ru.akirakozov.sd.refactoring.database.Database;

import javax.servlet.http.HttpServletRequest;


public class ExecutorFabric {

    public AbstractExecutor getExecutor (HttpServletRequest request, Database db) {
        String command = request.getParameter("command");

        switch(command) {
            case "max":
                return new MaxQueryExecutor(db);
            case "min":
                return new MinQueryExecutor(db);
            case "sum":
                return new SumQueryExecutor(db);
            case "count":
                return new CountQueryExecutor(db);
            default:
                return new UnknownQueryExecutor(db, command);
        }
    }
}