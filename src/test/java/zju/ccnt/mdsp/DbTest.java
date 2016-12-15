package zju.ccnt.mdsp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import zju.ccnt.mdsp.user.IUserMapper;
import zju.ccnt.mdsp.user.User;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Cc on 2016/12/14.
 */

public class DbTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setup() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void testGetOneUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User user = null;
        try {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            user = userMapper.getUser("xxxx-xxxx-xxxx-xxxx");
        } finally {
            session.close();
        }

        assertNotNull(user);
        assertEquals("xxxx-xxxx-xxxx-xxxx", user.getSign());
    }

    @Test
    public void testSelectOne2() {
        SqlSession session = sqlSessionFactory.openSession();
        User user = null;
        try {
            // 注意命名空间 zju.ccnt.mdsp.user.IUserMapper
            user = session.selectOne("zju.ccnt.mdsp.user.IUserMapper.getUser", "xxxx-xxxx-xxxx-xxxx");
        } finally {
            session.close();
        }

        assertNotNull(user);
        assertEquals("xxxx-xxxx-xxxx-xxxx", user.getSign());
    }
}