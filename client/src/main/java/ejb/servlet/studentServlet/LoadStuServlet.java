package ejb.servlet.studentServlet;

import ejb.service.StudentService;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoadStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = null;
        try {
            studentService = new StudentService();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String stuInfo = studentService.retrieveAllStudents();
        writer.write(stuInfo);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
