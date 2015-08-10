package controllers.students;

import database.DataService;
import entity.Student;

import javax.management.openmbean.CompositeData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Created by 1 on 31.07.2015.
 */
public class ViewStudentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();
        List<Student> students = service.listStudents();
        req.setAttribute("listStudents", students);
        req.getRequestDispatcher("/WEB-INF/JSP/studentList.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/JSP/studentList.jsp").forward(req, resp);
    }

}



