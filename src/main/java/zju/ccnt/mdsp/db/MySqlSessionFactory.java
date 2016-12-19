package zju.ccnt.mdsp.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Cc on 2016/12/14.
 */

public class MySqlSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getInstance() {
        if(sessionFactory == null) {
            synchronized (MySqlSessionFactory.class) {
                if(sessionFactory == null) {
                    // 默认读取hibernate.cfg.xml文件
                    Configuration cfg = new Configuration().configure();
                    // 建立SessionFactory
                    sessionFactory = cfg.buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }
}