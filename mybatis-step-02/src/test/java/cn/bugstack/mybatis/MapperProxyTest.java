package cn.bugstack.mybatis;


import cn.bugstack.mybatis.bind.MapperRegistry;
import cn.bugstack.mybatis.session.SqlSession;
import cn.bugstack.mybatis.session.SqlSessionFactory;
import cn.bugstack.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.bugstack.mybatis.test.dao.IUserDao;
import org.junit.Test;

/**
 * @description
 * @date 2022/3/29
 */
public class MapperProxyTest {

    @Test
    public void  test_MapperProxyFactory(){
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.bugstack.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        System.out.println(res);

    }
}
