package ejb.servlet.studentServlet;

import com.alibaba.fastjson.JSON;
import ejb.pojo.Student;
import ejb.service.StudentService;
import ejb.service.Util;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        StudentService studentService = null;
        try {
            studentService = new StudentService();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        char[] buf = new char[1024];
        int len;
        while ((len = reader.read(buf)) != -1){
            stringBuilder.append(buf,0,len);
        }
        String stuInfo = stringBuilder.toString();
        System.out.println(stuInfo);
        if (studentService.createStudent(stuInfo) == -1) {
            writer.write("true");
        } else {
            writer.write("false");
        }
    }
}
