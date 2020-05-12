package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MessageRepositoryTest {

    @Resource
    private  MessageRepository messageRepository;

    @Test
    void insertMessage() {
        messageRepository.insertMessage("1","1");
    }

    @Test
    void findByMsgSummary() {
        System.out.println(messageRepository.findByMsgSummary("1"));
    }

    @Test
    void findByMsgTextOrMsgSummary() {
        System.out.println(messageRepository.findByMsgTextOrMsgSummary("1", "1"));
    }

    @Test
    void findByMsgTextLike() {
        System.out.println(messageRepository.findByMsgTextLike("1"));
    }

    @Test
    void findDistinctByMsgIdLessThan() {
        System.out.println(messageRepository.findDistinctByMsgIdLessThan(3));
    }

    @Test
    void findById() {
//        Object obejct = messageRepository.findByMsgId(1);
        System.out.println(messageRepository.findByMsgId(1).getMsgSummary());
    }

    @Test
    void updateName() {
        System.out.println(messageRepository.updateName("123", 2));
    }

    @Test
    void findByName() {
        Page<Message> listPage =messageRepository.findByName("1", Pageable.unpaged());
        //获取page内的数据量
//        System.out.println(listPage.getTotalElements());
        Iterator it = listPage.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    void existsByMsgId() {
        System.out.println(messageRepository.existsByMsgId(1));
    }

    @Test
    void countByMsgSummary() {
        System.out.println(messageRepository.countByMsgSummary("1"));
    }

    @Test
    void deleteByMsgId() {
       messageRepository.deleteByMsgId(1);
    }
}