package ejb.dao;

public interface StudentDao {

    public int createStudent(String stuNum, String name, boolean sex, String birthday);

    public int deleteStudentById(int id);

    public int updateStudentById(int id, String field, Object val);

    public String retrieveStudentNameById(int id);

    public String retrieveStudentById(int id);
}
