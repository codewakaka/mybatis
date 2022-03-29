package cn.bugstack.mybatis;

import cn.bugstack.mybatis.binding.MapperProxyFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @date 2022/3/29
 */
public class MapperProxyTest {

    @Test
    public void  test_MapperProxyFactory(){
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory(IUserDao.class);

        Map<String,String> sqlSession = new HashMap<>();
        sqlSession.put("cn.bugstack.mybatis.IUserDao.queryUserName","查询用户姓名");
        sqlSession.put("cn.bugstack.mybatis.IUserDao.queryUseAge","查询用户年龄");
        IUserDao userDao =factory.newInstance(sqlSession);
        String s = userDao.queryUserName("1001");
        System.out.println(s);
    }
}
