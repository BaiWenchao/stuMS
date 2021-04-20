package ejb.dao.impl;

import com.alibaba.fastjson.JSON;
import ejb.dao.AdminDao;
import ejb.pojo.Admin;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Stateless(name = "AdminDaoBean")
@Remote(AdminDao.class)
public class AdminDaoBean implements AdminDao {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public String retrievePwdByUsername(String username) {
        String sql = "SELECT PASSWORD FROM ADMINS WHERE USERNAME = " + wrapField(username);
        Query query = em.createNativeQuery(sql);
        List result = query.getResultList();
        Iterator iterator = result.iterator();
        return iterator.next().toString();
    }

    private String wrapField(String field) {
        return "\'" + field + "\'";
    }
}
