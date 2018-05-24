package top.zhuyuncheng.ppt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhuyuncheng.ppt.model.User;
import top.zhuyuncheng.ppt.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public int add(@ModelAttribute User user) {
        return userService.add(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> userList() {
        List<User> list = userService.list();
        return list;
    }

    @RequestMapping(value = "/{userId}")
    public User get(@PathVariable("userId") Integer userId) {
        return userService.get(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("userId") Integer userId) {
        return userService.deleteUserById(userId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@ModelAttribute User user) {
        return userService.updateUser(user);
    }

    /*
    * @RequestParam("userName") String userName,
    * @RequestParam("password") String password,
    * @RequestParam("phone") String phone
    *
    * */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PATCH)
    public Object patch(@PathVariable("userId") Integer userId, @ModelAttribute User user) {
        return user;
    }


}
