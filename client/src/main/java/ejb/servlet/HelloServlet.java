package ejb.servlet;

import ejb.service.Util;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        try {
            String name = Util.getInfo();
            System.out.println(name);
            writer.write(name);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    //    对post的请求进行响应，将前端传过来的数据进行处理
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("text/html;charset=UTF-8");//设置响应内容类型
//        String name = req.getParameter("name");
//        System.out.println(name);
//      获取前端axios传过来的参数
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();
        char[] buf = new char[1024];
        int len;
        while ((len = reader.read(buf)) != -1){
            stringBuilder.append(buf,0,len);
        }

        String str = stringBuilder.toString();
        System.out.println(str);
        String[] strArr = str.split(",");

//        请求的类型
        String type = strArr[0].substring(9,strArr[0].length()-1);
        System.out.println(type);

//        姓名
        String name = strArr[1].substring(8,strArr[1].length()-1);
        System.out.println(name);
//        性别
        String gender = strArr[2].substring(10,strArr[2].length()-1);
        System.out.println(gender);

//        电话
        String phoneNum = strArr[3].substring(12,strArr[3].length()-1);
        System.out.println(phoneNum);
//        性别
        String birthday = strArr[4].substring(12,strArr[4].length()-2);
        System.out.println(birthday);

    }
}