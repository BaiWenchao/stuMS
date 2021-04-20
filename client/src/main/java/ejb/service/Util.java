package ejb.service;

import com.alibaba.fastjson.JSON;
import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;
import ejb.pojo.Student;

import javax.ejb.Remote;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Remote
public class Util {
    public static String getInfo() throws NamingException {
//        PersonDao personDao = (PersonDao) EJBFactory.getPersonDaoBean();
//        return personDao.retrievePersonNameById(14);
        StudentDao studentDao = (StudentDao) EJBFactory.getStudentDaoBean();
        return studentDao.retrieveStudentById(1);
    }
}
