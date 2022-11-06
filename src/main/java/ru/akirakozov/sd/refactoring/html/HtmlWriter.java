package ru.akirakozov.sd.refactoring.html;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HtmlWriter {

    public static String writeBody(ResultSet resultSet) throws SQLException {
        StringBuilder sb = new StringBuilder();
        while (resultSet.next()) {
            sb.append(resultSet.getString("name"));
            sb.append("\t");
            sb.append(resultSet.getInt("price"));
            sb.append("</br>\n");
        }
        return sb.toString();
    }

    public static String writeNumber(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return resultSet.getInt(1) + "\n";
        }
        return "";
    }

    public static void writeHtml(String head, String body, PrintWriter printWriter) {
        printWriter.println("<html><body>");
        if (head != null)
            printWriter.println(head);
        printWriter.print(body);
        printWriter.println("</body></html>");
    }

    public static String toHeader(String s) {
        return "<h1>" + s + "</h1>";
    }
}