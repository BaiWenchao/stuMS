package ejb.service;

import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;

import javax.naming.NamingException;
import java.util.Locale;

public class CurdStudent {
    public static void main(String[] args) throws NamingException {
        StudentDao studentDao = (StudentDao) EJBFactory.getStudentDaoBean();
        // 增
        // System.out.println(studentDao.createStudent("Bai Wenchao", true, "31415926535", "19991216"));
        // 删
        // System.out.println(studentDao.deleteStudentById(5));
        // 改
        // System.out.println(studentDao.updateStudentById(1, "NAME", "Jetlipse"));
        // System.out.println(studentDao.updateStudentById(1, "SEX", false));
        // 查
        // System.out.println(studentDao.retrieveStudentNameById(1));
        System.out.println(studentDao.retrieveStudentById(3));
        // test(2);
    }

    private static void test(int id) {
        String sql = "DELETE FROM STUDENTS WHERE ID = " + id;
        System.out.println(sql);
    }

    private static String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
