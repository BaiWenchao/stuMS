package ejb.dao.impl;

import com.alibaba.fastjson.JSON;
import ejb.dao.StudentDao;
import ejb.pojo.Student;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Stateless(name = "StudentDaoBean")
@Remote(StudentDao.class)
public class StudentDaoBean implements StudentDao {

    @PersistenceContext
    protected EntityManager em;


    @Override
    public int createStudent(Integer id, String stuNum, String name, boolean sex, String birthday) {
        String sql = "INSERT INTO STUDENTS VALUE (" + id  + ", " + wrapField(stuNum) + ", " + wrapField(name) + ", " + sex + ", " + wrapField(birthday)  + ")";
        Query query = em.createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public int deleteStudentById(int id) {
        String sql = "DELETE FROM STUDENTS WHERE ID = " + id;
        Query query = em.createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public int updateStudentById(int id, String field, Object val) {
        String sql;
        field = field.toUpperCase(Locale.ROOT);
        if (field.equals("NAME") || field.equals("BIRTHDAY") || field.equals("StuNum")) {
            // STRING CASE
            sql = "UPDATE STUDENTS SET " + field + " = " + wrapField((String)val) + " WHERE ID = " + id;
        } else {
            sql = "UPDATE STUDENTS SET " + field + " = " + val + " WHERE ID = " + id;
        }
        Query query = em.createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public int updateStudentById(Integer id, String stuNum, String name, boolean sex, String birthday) {
        String sql = "UPDATE STUDENTS SET STUNUM = " + wrapField(stuNum)
                + ", NAME = " + wrapField(name)
                + ", SEX = " + sex
                + ", BIRTHDAY = " + wrapField(birthday) + " WHERE ID = " + id;
        Query query = em.createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public String retrieveStudentNameById(int id) {
        Student student = em.find(Student.class, id);
        return student.getName();
    }

    @Override
    public String retrieveStudentById(int id) {
        Student student = em.find(Student.class, id);
        return JSON.toJSONString(student);
    }

    @Override
    public String retrieveAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM STUDENTS";
        Query query = em.createNativeQuery(sql);
        List result = query.getResultList();
        Iterator iterator = result.iterator();
        Student student;
        while(iterator.hasNext()) {
            student = new Student();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Object[] obj = (Object[]) iterator.next();
            student.setId(Integer.parseInt(obj[0].toString()));
            student.setStuNum(obj[1].toString());
            student.setName(obj[2].toString());
            student.setSex(Boolean.parseBoolean(obj[3].toString()));
            try {
                student.setBirthday(format.parse(obj[4].toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            studentList.add(student);
        }
        return JSON.toJSONString(studentList);
    }


    private String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
