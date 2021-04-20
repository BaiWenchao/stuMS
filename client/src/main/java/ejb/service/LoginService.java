package ejb.service;

import ejb.dao.AdminDao;
import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;
import ejb.pojo.Admin;

import javax.naming.NamingException;

public class LoginService {
    private AdminDao adminDao;

    public LoginService() throws NamingException {
        adminDao = (AdminDao) EJBFactory.getAdminDaoBean();
    }

    public boolean validation(String adminInfo) {
        Admin admin = JsonService.parseAdmin(adminInfo);
        return adminDao.retrievePwdByUsername(admin.getUsername()).equals(admin.getPassword());
    }
}
