package ejb.servlet.utilServlet;

import ejb.service.LoginService;
import ejb.service.Util;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = null;
        try {
            loginService = new LoginService();
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
        String adminInfo = stringBuilder.toString();
        System.out.println(adminInfo);
        System.out.println(loginService.validation(adminInfo));
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write(loginService.validation(adminInfo) ? "true" : "false");
    }
}
