package cn.cqswxy.sport.mapper;

import cn.cqswxy.sport.entity.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    public List<MainMenu> getMainMenus();

}
