package ejb.dao;

import java.util.List;

public interface StudentDao {

    public int createStudent(Integer id, String stuNum, String name, boolean sex, String birthday);

    public int deleteStudentById(int id);

    public int updateStudentById(int id, String field, Object val);

    public int updateStudentById(Integer id, String stuNum, String name, boolean sex, String birthday);

    public String retrieveStudentNameById(int id);

    public String retrieveStudentById(int id);

    public String retrieveAllStudents();
}
