package cn.cqswxy.sport.controller;

import cn.cqswxy.sport.entity.QueryInfo;
import cn.cqswxy.sport.entity.User;
import cn.cqswxy.sport.mapper.UserMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    //得到用户信息，条数并分页
    //更改用户权限
    @Autowired
    UserMapper userMapper;

    @CrossOrigin
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        System.out.println(queryInfo);
        int numbers = userMapper.getUserCounts("%" + queryInfo.getQuery() + "%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = userMapper.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);
        System.out.println("总条数：" + numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer id,
                                  @RequestParam("state") Boolean state) {
        System.out.println("用户编号:" + id);
        System.out.println("用户状态:" + state);
        int i = userMapper.updateState(id, state);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userMapper.addUser(user);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id) {
        System.out.println("编号:" + id);
        User updateUser = userMapper.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user) {
        System.out.println(user);
        int i = userMapper.editUser(user);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        System.out.println(id);
        int i = userMapper.deleteUser(id);
        String str = i > 0 ? "success" : "error";
        return str;
    }
}
