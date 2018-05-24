package top.zhuyuncheng.ppt.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestMock {

    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private WebApplicationContext webApplicationContext;

//    @Before
//    public void before() {
//        //获取mockmvc对象实例
//        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }

    @Test
    public void add() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users")
                .param("userName", "zyc_132")
                .param("password", "zyc_1223")
                .param("phone", "1008611");

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void userList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.put("/users")
                .param("userId", "1001")
                .param("userName", "updateUserName")
                .param("password", "updatePassword")
                .param("phone", "10086123");

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void patch() throws Exception {
        mvc.perform(MockMvcRequestBuilders.patch("/users/1001")
                .param("userName", "patchUserName"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}