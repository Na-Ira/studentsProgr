package controllers.students;

import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 1 on 10.08.2015.
 */
public class DeleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
//        if (req.getParameter("id") != null && req.getParameter("id") != ""){
        int id = Integer.parseInt(req.getParameter("id"));
        if (service.deleteStudent(id) != null) {
            req.setAttribute("students", id);
            resp.sendRedirect("studentList.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
