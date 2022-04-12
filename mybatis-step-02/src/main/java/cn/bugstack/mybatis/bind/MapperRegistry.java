package cn.bugstack.mybatis.bind;

import cn.bugstack.mybatis.session.SqlSession;
import cn.hutool.core.lang.ClassScanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description
 * @date 2022/4/11
 */
public class MapperRegistry {

    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T>T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if(mapperProxyFactory == null){
            throw new RuntimeException("Type "+ type +"is not known to mapperRegistry");
        }

        try {
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("error getting mapper instance. Cause"+e,e);
        }
    }

    public <T> void  addMapper(Class<T> type){
        //mapper必须是接口
        if(type.isInterface()){
            if(hasMapper(type)){
                //重复添加报错
                throw new RuntimeException("type "+ type + "is already known to the MapperRegistry");
            }
            knownMappers.put(type,new MapperProxyFactory<>(type));
        }

    }

    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

    private <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }
}
