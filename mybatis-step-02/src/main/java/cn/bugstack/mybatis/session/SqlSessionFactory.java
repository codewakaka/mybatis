package cn.bugstack.mybatis.session;

/**
 * @description 工厂模式接口，构建SqlSession的工厂
 * @date 2022/4/12
 */
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();


}
