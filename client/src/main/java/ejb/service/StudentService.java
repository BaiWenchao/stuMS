package ejb.service;

import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;
import ejb.pojo.Student;

import javax.naming.NamingException;

public class StudentService {
    private StudentDao studentDao;

    public StudentService() throws NamingException {
        studentDao = (StudentDao) EJBFactory.getStudentDaoBean();
    }

    public int createStudent(String stuInfo) {
        Student student = JsonService.parseStudent(stuInfo);

        try {
            studentDao.retrieveStudentIdByStuNum(student.getStuNum());
            return 1;
        } catch (Exception e) {
            studentDao.createStudent(student.getId(), student.getStuNum(), student.getName(), student.isSex(), student.getBirthday());
            return -1;
        }
    }

    public int updateStudent(String stuInfo) {
        Student student = JsonService.parseStudent(stuInfo);

        try {
            int id = studentDao.retrieveStudentIdByStuNum(student.getStuNum());
            if (id == student.getId()) {
                studentDao.updateStudentById(student.getId(), student.getStuNum(), student.getName(), student.isSex(), student.getBirthday());
                return -1;
            }
            return 1;
        } catch (Exception e) {
            studentDao.updateStudentById(student.getId(), student.getStuNum(), student.getName(), student.isSex(), student.getBirthday());
            return -1;
        }
    }

    public String retrieveAllStudents() {
        return studentDao.retrieveAllStudents();
    }

    public int deleteStudent(String stuInfo) {
        Student student = JsonService.parseStudent(stuInfo);
        return studentDao.deleteStudentById(student.getId());
    }
}
