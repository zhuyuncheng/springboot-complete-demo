package top.zhuyuncheng.ppt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhuyuncheng.ppt.dao.groovy.UserDao;
import top.zhuyuncheng.ppt.dao.xml.UserXMLDao;
import top.zhuyuncheng.ppt.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserXMLDao userXMLDao;

    public int add(User user) {
        return userDao.insert(user);
        // return userXMLDao.insert(user);
    }

    public List<User> list() {
        return userDao.selectUsers();
        // return userXMLDao.selectUsers();
    }

    public User get(Integer userId) {
        return userDao.get(userId);
    }

    public Object deleteUserById(Integer userId) {
        return userDao.deleteUserById(userId);
    }

    public Object updateUser(User user) {
        return  userDao.updateUser(user);
    }

    public Object putUser(User user) {
        return  userDao.putUser(user);
    }

}
