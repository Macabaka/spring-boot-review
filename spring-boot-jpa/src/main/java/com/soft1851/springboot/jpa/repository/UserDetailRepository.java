package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.service.UserInfo;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/13 21:40
 * @Description:
 */
public interface UserDetailRepository  extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail,Long> {

    @Query("select user.userName as userName,user.email as email, " +
            "ud.introduction as introduction ,ud.hobby as hobby from" +
            " User user, UserDetail  ud where ud.id=ud.userId and ud.hobby = ?1")
    List<UserInfo> findUserInfo(String hobby);
}
