package ejb.dao.impl;

import ejb.dao.StudentDao;
import ejb.pojo.Student;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Locale;

@Stateless(name = "StudentDaoBean")
@Remote(StudentDao.class)
public class StudentDaoBean implements StudentDao {

    @PersistenceContext
    protected EntityManager em;


    @Override
    public int createStudent(String name, boolean sex, String tel, String birthday) {
        String sql = "INSERT INTO STUDENTS VALUE (" + null + ", " + wrapField(name) + ", " + sex + ", " + wrapField(tel)
                + ", " + wrapField(birthday)  + ")";
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
        if (field.equals("NAME") || field.equals("BIRTHDAY") || field.equals("TEL")) {
            // STRING CASE
            sql = "UPDATE STUDENTS SET " + field + " = " + wrapField((String)val) + " WHERE ID = " + id;
        } else {
            sql = "UPDATE STUDENTS SET " + field + " = " + val + " WHERE ID = " + id;
        }
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
        return student.getId()+
                ","+student.getName()+
                ","+student.isSex()+
                ","+student.getTel()+
                ","+student.getBirthday();
    }

    private String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
