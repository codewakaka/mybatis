package cn.bugstack.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @description
 * @date 2022/3/29
 */
public class MapperProxyFactory <T>{

    private final Class<T> mapperInteface;


    public MapperProxyFactory(Class<T> mapperInteface) {
        this.mapperInteface = mapperInteface;
    }


    public T newInstance(Map<String,String> sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInteface);
        return (T)Proxy.newProxyInstance(mapperInteface.getClassLoader(),new Class[]{mapperInteface},mapperProxy);
    }
}
