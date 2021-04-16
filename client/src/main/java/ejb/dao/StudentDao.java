package ejb.dao;

public interface StudentDao {

    public int createStudent(String name, boolean sex, String tel, String birthday);

    public int deleteStudentById(int id);

    public int updateStudentById(int id, String field, Object val);

    public String retrieveStudentNameById(int id);

    public String retrieveStudentById(int id);
}
