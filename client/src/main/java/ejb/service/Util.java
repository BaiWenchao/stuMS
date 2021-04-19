package ejb.service;

import ejb.dao.StudentDao;
import ejb.factory.EJBFactory;

import javax.ejb.Remote;
import javax.naming.NamingException;

@Remote
public class Util {
    public static String getInfo() throws NamingException {
//        PersonDao personDao = (PersonDao) EJBFactory.getPersonDaoBean();
//        return personDao.retrievePersonNameById(14);
        StudentDao studentDao = (StudentDao) EJBFactory.getStudentDaoBean();
        return studentDao.retrieveStudentById(1);
    }
}
