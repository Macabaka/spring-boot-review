package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Johnny
 * @Date: 2020/5/13 17:35
 * @Description:
 */

//标注实体
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "User.findByEmail",query = "select user from User user where user.email=?1"),
        @NamedQuery(name = "User.findByPassword",query = "select user from User user where user.password=?1")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false,unique = true)
    private  String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private  String email;

    @Column(length = 32)
    private String nickName;

    @Column
    private  Integer age;

}
