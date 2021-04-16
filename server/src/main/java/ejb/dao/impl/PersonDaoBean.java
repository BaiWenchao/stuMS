package ejb.dao.impl;

import ejb.dao.PersonDao;
import ejb.pojo.Person;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Locale;

@Stateless(name = "PersonDaoBean")
@Remote(PersonDao.class)
public class PersonDaoBean implements PersonDao {
    @PersistenceContext
    protected EntityManager em;

    @Override
    public int createPerson(String name, boolean sex, int age, String birthday) {
        // 构造SQL语句
        // id自增，故直接赋null
        String sql = "INSERT INTO PERSON VALUE (" + null + ", " + age + ", " +
                wrapField(birthday) + "," + wrapField(name) + "," + sex + ")";
        // 构造query
        Query query = em.createNativeQuery(sql);
        // 返回数据表中改变的条目数
        return query.executeUpdate();
    }

    @Override
    public int deletePersonById(int id) {
        String sql = "DELETE FROM PERSON WHERE PERSONID = " + id;
        Query query = em.createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public int updatePersonById(int id, String field, Object val) {
        String sql;
        field = field.toUpperCase(Locale.ROOT);
        if (field.equals("NAME") || field.equals("BIRTHDAY")) {
            // STRING CASE
            sql = "UPDATE PERSON SET " + field + " = " + wrapField((String)val) + " WHERE PERSONID = " + id;
        } else {
            sql = "UPDATE PERSON SET " + field + " = " + val + " WHERE PERSONID = " + id;
        }
        Query query = em.createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public String retrievePersonNameById(int id) {
        Person person = em.find(Person.class, id);
        return person.getName();
    }

    private String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
