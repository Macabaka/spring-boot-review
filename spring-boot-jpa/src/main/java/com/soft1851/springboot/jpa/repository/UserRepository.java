package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/13 17:53
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据用户名进行查询
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 根据username和email查询
     * @param username
     * @param email
     * @return
     */
    User findByUserNameOrEmail(String username, String email);

    /**
     * 根据username查询数量
     * @param username
     * @return
     */
    Long countByUserName(String username);

    /**
     * 根据email进行模糊查询
     * @param email
     * @return
     */
    List<User> findByEmailLike(String email);

    /**
     *根据username忽略大小写查找
     * @param userName
     * @return
     */
    User findByUserNameIgnoreCase(String userName);

    /**
     * 根据username查找并按email进行降序查找
     * @param email
     * @return
     */
    List<User> findByUserNameOrderByEmailDesc(String email);

    /**
     *自定义方法——根据id查找
     * @param id
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Query("select  user from User user where user.id = ?1")
    User findById(long id);


    /**
     * 自定义方法——根据id修改昵称
     * @param nickname
     * @param id
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value ="update  user set nick_name= ?1 where id = ?2",nativeQuery = true)
    int updateNickName(String nickname, long id);

    /**
     *根据username/password/email插入信息
     * @param userName
     * @param password
     * @param email
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = " insert into user(user_name,password,email) values (:userName,:password,:email) ",nativeQuery = true)
    int insertUser (@Param("userName")String userName,@Param("password")String password,@Param("email")String email);
}
