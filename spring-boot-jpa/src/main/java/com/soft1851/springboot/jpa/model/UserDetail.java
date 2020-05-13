package com.soft1851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Johnny
 * @Date: 2020/5/13 21:37
 * @Description:
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    @Id
    @GeneratedValue
    private  Long id;

    @Column(nullable = false,unique = true)
    private Long userId;

    private Integer age;

    private String realName;

    private String status;

    private String hobby;

    private String introduction;

    private  String lastLoginIp;
}
