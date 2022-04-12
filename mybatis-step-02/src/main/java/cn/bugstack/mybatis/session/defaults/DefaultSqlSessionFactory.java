package cn.bugstack.mybatis.session.defaults;

import cn.bugstack.mybatis.bind.MapperRegistry;
import cn.bugstack.mybatis.session.SqlSession;
import cn.bugstack.mybatis.session.SqlSessionFactory;

/**
 * @description
 * @date 2022/4/12
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
