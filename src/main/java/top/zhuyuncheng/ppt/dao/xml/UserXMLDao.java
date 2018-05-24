package top.zhuyuncheng.ppt.dao.xml;

import top.zhuyuncheng.ppt.model.User;

import java.util.List;

public interface UserXMLDao {

    int insert(User user);

    List<User> selectUsers();
}
