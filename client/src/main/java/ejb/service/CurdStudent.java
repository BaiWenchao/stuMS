package ejb.service;

import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;

import javax.naming.NamingException;
import java.util.Locale;

public class CurdStudent {
    public static void main(String[] args) throws NamingException {
        StudentDao studentDao = (StudentDao) EJBFactory.getStudentDaoBean();
        // 增
        // System.out.println(studentDao.createStudent("20185085","Bai Wenchao", true,  "19991216"));
        // 删
        // System.out.println(studentDao.deleteStudentById(6));
        // 改
        // System.out.println(studentDao.updateStudentById(1, "NAME", "Jetlipse"));
        // System.out.println(studentDao.updateStudentById(6, "SEX", false));
        // 查
        // System.out.println(studentDao.retrieveStudentNameById(1));
        // System.out.println(studentDao.retrieveStudentById(1));
        // test(2);
        // test("20185085","Bai Wenchao", true,  "19991216");
    }

    private static void test(String stuNum, String name, boolean sex, String birthday) {
        String sql = "INSERT INTO STUDENTS VALUE (" + null  + ", " + wrapField(stuNum) + ", " + wrapField(name) + ", " + sex + ", " + wrapField(birthday)  + ")";
        System.out.println(sql);
    }

    private static String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
