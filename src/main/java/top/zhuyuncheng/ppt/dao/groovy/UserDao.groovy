package top.zhuyuncheng.ppt.dao.groovy

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import top.zhuyuncheng.ppt.model.User

interface UserDao {

    @Insert('''INSERT INTO t_user (userName, password, phone) VALUES (#{userName}, #{password}, #{phone})''')
    int insert(User user)

    @Select('''SELECT * FROM t_user''')
    List<User> selectUsers()

    @Select('''SELECT * FROM t_user WHERE userId = #{userId}''')
    User get(Integer userId)

    @Delete('''DELETE FROM t_user WHERE userId = #{userId}''')
    Object deleteUserById(@Param("userId")Integer userId)

    @Update('''UPDATE t_user SET userName = #{userName}, password = #{password}, phone = #{phone} WHERE userId = #{userId}''')
    Object updateUser(User user)

    @Update('''
        UPDATE t_user SET
        <if test="userName != null"> userName = #{userName}, </if>
        <if test="password != null"> password = #{password}, </if>
        <if test="phone != null"> phone = #{phone}, </if>
        userId = #{userId}
        WHERE userId = #{userId}
    ''')
    Object putUser(User user)
}