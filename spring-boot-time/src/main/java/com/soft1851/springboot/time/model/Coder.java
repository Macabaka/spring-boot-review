package com.soft1851.springboot.time.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Johnny
 * @Date: 2020/5/18 09:02
 * @Description:
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false,length = 30)
    private String name;

    @Column(name = "avatar",nullable = false,length = 300)
    private String avatar;

    @Column(name = "url",nullable = false,length = 150)
    private String url;
}
