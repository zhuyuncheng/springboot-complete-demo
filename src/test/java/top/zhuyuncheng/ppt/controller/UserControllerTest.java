package top.zhuyuncheng.ppt.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import top.zhuyuncheng.ppt.PptCpmApplication;
import top.zhuyuncheng.ppt.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PptCpmApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableAutoConfiguration
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
        User user = restTemplate.getForObject("/users/1000", User.class);
        Assert.assertEquals(user.getUserId(), Integer.valueOf(1000));
    }

    @Test
    public void addUser() throws Exception {
        /*User user = new User();
        user.setUserName("zhangsan123");
        user.setPassword("zyc1234");
        user.setPhone("1008611");*/

        JSONObject user = new JSONObject();
        user.put("userName", "zhangsan123");
        user.put("password", "zyc123556");
        user.put("phone", "132123123");

        Integer id = restTemplate.postForObject("/users", user, Integer.class);
        System.out.println(id);

    }

    @Test
    public void deleteUser() throws Exception {
        restTemplate.delete("/users/1006");
    }

    @Test
    public void updateUser() throws Exception {
//        User user = new User();
//        user.setUserId(1001);
//        user.setUserName("zhangsan1231000");
//        user.setPassword("zyc12341000");
//        user.setPhone("10086111000");


//        JSONObject user = new JSONObject();
        MultiValueMap user = new LinkedMultiValueMap();
        user.add("userId", 1001);
        user.add("userName", "zhangsan123");
        user.add("password", "zyc123556");
        user.add("phone", "132123123");

        restTemplate.put("/users", user);
    }

    /**
     * Failure to execute
     * @throws Exception
     */
    @Test
    public void patchUser() throws Exception {
        User user = new User();
        MultiValueMap multiValueMap = new LinkedMultiValueMap();
        multiValueMap.add("userName","zhangsan12310001");
        multiValueMap.add("password","zyc123410001");
        multiValueMap.add("phone","100861110001");

        Integer id = restTemplate.patchForObject("/users/1000", user, Integer.class);
        System.out.println(id);
    }
}
