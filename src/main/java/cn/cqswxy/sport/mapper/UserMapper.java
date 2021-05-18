package cn.cqswxy.sport.mapper;

import cn.cqswxy.sport.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //通过账号密码获取信息从而登陆
    int getUserByMassage(@Param("username") String username, @Param("password") String password);

    //查询所有用户并分成多少页
    List<User> getAllUser(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //查询所有页数
    int getUserCounts(@Param("username") String username);

    //更改权限
    int updateState(Integer id, Boolean state);

    //增加用户
    int addUser(User user);

    //通过ID更改用户
    User getUpdateUser(int id);

    //编辑用户信息
    int editUser(User user);

    //删除用户
    int deleteUser(int id);
}