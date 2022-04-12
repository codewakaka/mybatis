package cn.bugstack.mybatis.bind;

import cn.bugstack.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description
 * @date 2022/4/11
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private SqlSession sqlSession;


    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
