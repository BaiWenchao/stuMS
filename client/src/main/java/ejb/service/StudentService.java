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
        return studentDao.createStudent(student.getId(), student.getStuNum(), student.getName(), student.isSex(), student.getBirthday());
    }

    public int updateStudent(String stuInfo) {
        Student student = JsonService.parseStudent(stuInfo);
        return studentDao.updateStudentById(student.getId(), student.getStuNum(), student.getName(), student.isSex(), student.getBirthday());
    }

    public String retrieveAllStudents() {
        return studentDao.retrieveAllStudents();
    }

    public int deleteStudent(String stuInfo) {
        Student student = JsonService.parseStudent(stuInfo);
        return studentDao.deleteStudentById(student.getId());
    }
}
