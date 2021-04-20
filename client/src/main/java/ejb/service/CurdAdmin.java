package ejb.service;

import ejb.dao.AdminDao;
import ejb.factory.EJBFactory;

import javax.naming.NamingException;

public class CurdAdmin {
    public static void main(String[] args) throws NamingException {
        AdminDao adminDao = (AdminDao) EJBFactory.getAdminDaoBean();
        System.out.println(adminDao.retrievePwdByUsername("admin"));
    }
}
