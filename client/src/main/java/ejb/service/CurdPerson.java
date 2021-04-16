package ejb.service;

import ejb.dao.PersonDao;
import ejb.factory.EJBFactory;

import javax.naming.NamingException;

public class CurdPerson {
    public static void main(String[] args) throws NamingException {
        PersonDao personDao = (PersonDao) EJBFactory.getPersonDaoBean();
        /*========================增========================*/
         /*
         * 增加一条信息：
         * */
        // System.out.println(personDao.createPerson("Wenchao Bai", true, 21, "19991216"));

        /*========================删========================*/
        /*
        * 根据personID删除一条信息：
        * */
        // System.out.println(personDao.deletePersonById(1));

        /*========================改========================*/
        /*
        * 根据personID以及修改字段及新值修改更新person记录：
        * */
        // System.out.println(personDao.updatePersonById(14, "sex", true));

        /*========================查========================*/
        /*
        * 根据personID查找person姓名
        * */
        System.out.println(personDao.retrievePersonNameById(14));
    }
}
