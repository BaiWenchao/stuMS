package ejb.service;

import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;

import javax.naming.NamingException;
import java.util.List;
import java.util.Locale;

public class CurdStudent {
    public static void main(String[] args) throws NamingException {
        StudentDao studentDao = (StudentDao) EJBFactory.getStudentDaoBean();
        // 增
        // System.out.println(studentDao.createStudent("20185085T","Wenchao Bai", true,  "19991216"));
        // 删
        // System.out.println(studentDao.deleteStudentById(6));
        // 改
        // System.out.println(studentDao.updateStudentById(1, "NAME", "Jetlipse"));
        // System.out.println(studentDao.updateStudentById(6, "SEX", false));

        // 查
        // System.out.println(studentDao.retrieveStudentNameById(1));
        // System.out.println(studentDao.retrieveStudentById(1));
        // System.out.println(studentDao.retrieveAllStudents());
        try {
            System.out.println(studentDao.retrieveStudentIdByStuNum("20183333"));
        } catch (Exception e) {
            System.out.println("get it");
        }
    }

    private static void test(Integer id, String stuNum, String name, boolean sex, String birthday) {
        String sql = "UPDATE STUDENTS SET STUNUM = " + wrapField(stuNum)
                + ", NAME = " + wrapField(name)
                + ", SEX = " + sex
                + ", BIRTHDAY = " + birthday + " WHERE ID = " + id;
        System.out.println(sql);
    }

    private static String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
