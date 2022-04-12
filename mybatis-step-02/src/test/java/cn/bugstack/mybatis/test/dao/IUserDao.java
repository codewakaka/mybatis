package cn.bugstack.mybatis.test.dao;

/**
 * @description
 * @date 2022/3/29
 */
public interface IUserDao{

    String queryUserName(String uId);

    Integer queryUseAge(String uId);
}
