package zju.ccnt.mdsp.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Cc on 2016/12/14.
 */

public class MySqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getInstance() {
        if(sqlSessionFactory == null) {
            synchronized (MySqlSessionFactory.class) {
                if(sqlSessionFactory == null) {
                    String resource = "mybatis-config.xml";
                    InputStream inputStream = null;
                    try {
                        inputStream = Resources.getResourceAsStream(resource);
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
}