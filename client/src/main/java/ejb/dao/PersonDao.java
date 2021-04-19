package ejb.dao;

import java.util.List;

public interface PersonDao {
    /*========================增========================*/
    /*
    * 插入一条person数据。
    * 返回：改变条目的数量（用以检验数据是否插入成功）
    * */
    public int createPerson(String name, boolean sex, int age, String birthday);

    /*========================删========================*/
    /*
    * 根据personID删除一条person数据
    * 返回改变条目的数量（用以检验数据是否删除成功）
    * */
    public int deletePersonById(int id);

    /*========================改========================*/
    /*
    * 根据personID修改用户名
    * 输入用户ID、改变字段、更新值
    * 返回改变条目的数量（用以检验数据是否更新成功）
    * */
    public int updatePersonById(int id, String field, Object val);

    /*========================查========================*/
    /*
    * 按照personID查找用户姓名
    * */
    public String retrievePersonNameById(int id);

    public List<String> retrieveAllPeople();
}
