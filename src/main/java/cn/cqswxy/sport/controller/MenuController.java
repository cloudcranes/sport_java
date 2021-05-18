package cn.cqswxy.sport.controller;

import cn.cqswxy.sport.entity.MainMenu;
import cn.cqswxy.sport.mapper.MenuMapper;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuMapper menuMapper;

    @CrossOrigin
    @RequestMapping("/menus")
    public String getAllMenus() {
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> mainMenus = menuMapper.getMainMenus();
        data.put("data", mainMenus);
        data.put("status", 200);
        String data_json = JSON.toJSONString(data);
        System.out.println("成功访问！！！");
        return data_json;
    }
}
