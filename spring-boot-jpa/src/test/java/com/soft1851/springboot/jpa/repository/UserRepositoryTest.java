package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {

    @Resource
    private  UserRepository userRepository;

    @Test
    void findByUserName() {
        System.out.println(userRepository.findByUserName("1"));
    }

    @Test
    void findByUserNameOrEmail() {
        System.out.println(userRepository.findByUserNameOrEmail("1", "2"));
    }

    @Test
    void countByUserName() {
        System.out.println(userRepository.countByUserName("1"));
    }

    @Test
    void findByEmailLike() {
        System.out.println(userRepository.findByEmailLike("1"));
    }

    @Test
    void findByUserNameIgnoreCase() {
        System.out.println(userRepository.findByUserNameIgnoreCase("1"));
    }

    @Test
    void findByUserNameOrderByEmailDesc() {
        System.out.println(userRepository.findByUserNameOrderByEmailDesc("1"));
    }

    @Test
    void findById(){
        System.out.println(userRepository.findById(1));
    }

    @Test
    void updateNickName(){
        System.out.println(userRepository.updateNickName("新数据", 1));
    }

    @Test
    void insertUser(){
        System.out.println(userRepository.insertUser("2", "2", "2"));
    }

    @Test
    void all(){
        //save新增
//        System.out.println(userRepository.save(User.builder().email("3").password("3").userName("3").build()));
        //批量新增
//        System.out.println(userRepository.saveAll(new ArrayList<>() {{
//            this.add(User.builder().email("3").password("3").userName("3").build());
//            this.add(User.builder().email("4").password("4").userName("4").build());
//        }}));
    }

    @Test
    void findAll(){
        Page<User> users = userRepository.findAll(Pageable.unpaged());
        Iterator<User> it = users.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    void findByNickName(){
        System.out.println(userRepository.findByNickName("1", Pageable.unpaged()));
    }

    @Test
    void findByAge(){
//        System.out.println(userRepository.findByAge("1", Pageable.unpaged()));
        Pageable pageable = PageRequest.of(0,2,Sort.by(Sort.Direction.DESC,"id"));
        Page<User> users = userRepository.findByAge("1", pageable);
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(iterator.next());
        }
    }

    @Test
    void findByEmail(){
        System.out.println(userRepository.findByEmail("1"));
    }

    @Test
    void findByPassword(){
        System.out.println(userRepository.findByPassword("1"));
    }

    @Test
    void findFirstByOrderByAgeDesc(){
        System.out.println(userRepository.findFirstByOrderByAgeDesc());
    }
}