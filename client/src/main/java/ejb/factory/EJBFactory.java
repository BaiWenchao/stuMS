package ejb.factory;

import ejb.dao.AdminDao;
import ejb.dao.PersonDao;
import ejb.dao.StudentDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class EJBFactory {
    public static Object getPersonDaoBean() throws NamingException {
        // 路径配置
        String appName = "";
        String moduleName = "server-1.0-SNAPSHOT";
        String distinctName = "";
        String beanName = "PersonDaoBean";
        String viewClassName = PersonDao.class.getName();
        return getRemoteBean(appName, moduleName, distinctName, beanName, viewClassName);
    }

    public static Object getStudentDaoBean() throws NamingException {
        // 路径配置
        String appName = "";
        String moduleName = "server-1.0-SNAPSHOT";
        String distinctName = "";
        String beanName = "StudentDaoBean";
        String viewClassName = StudentDao.class.getName();
        return getRemoteBean(appName, moduleName, distinctName, beanName, viewClassName);
    }

    public static Object getAdminDaoBean() throws NamingException {
        // 路径配置
        String appName = "";
        String moduleName = "server-1.0-SNAPSHOT";
        String distinctName = "";
        String beanName = "AdminDaoBean";
        String viewClassName = AdminDao.class.getName();
        return getRemoteBean(appName, moduleName, distinctName, beanName, viewClassName);
    }

    private static Object getRemoteBean(String appName, String moduleName, String distinctName, String beanName, String viewClassName) throws NamingException {
        String jndiPath = "ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+beanName+"!"+viewClassName;

        Properties jndiProps = new Properties();
        jndiProps.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
        jndiProps.put("jboss.naming.client.ejb.context", true);

        final Context context = new InitialContext(jndiProps);

        return context.lookup(jndiPath);
    }
}
