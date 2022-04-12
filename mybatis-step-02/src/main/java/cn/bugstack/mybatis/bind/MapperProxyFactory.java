package cn.bugstack.mybatis.bind;

import cn.bugstack.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description
 * @date 2022/4/11
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }


    public T newInstance(SqlSession sqlSession){
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
