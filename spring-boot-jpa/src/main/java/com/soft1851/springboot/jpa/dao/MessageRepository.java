package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/12 22:12
 * @Description:
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {

    /**
     * 根据id删除
     * @param msgId
     * @return
     */
    void deleteByMsgId(int msgId);

    /**
     * 根据msgSummary计数
     * @param msgSummary
     * @return
     */
    long countByMsgSummary(String msgSummary);

    /**
     * 根据id查询数据库中是否有这条数据
     * @param id
     * @return
     */
    Boolean existsByMsgId(int id);

    /**
     * 根据msgSummary进行模糊查询
     * @param msgSummary
     * @return
     */
    List<Message> findByMsgSummary(String msgSummary);

    /**
     * 根据msgText或者msgSummary进行模糊查询
     * @param msgText
     * @param msgSummary
     * @return
     */
    List<Message> findByMsgTextOrMsgSummary(String msgText, String msgSummary);

    /**
     * 根据内容进行模糊查询
     * @param text
     * @return
     */
    List<Message> findByMsgTextLike(String text);

    /**
     * 查询比maxId小的数据，并返回集合
     * @param maxId
     * @return
     */
    List<Message> findDistinctByMsgIdLessThan(int maxId);

    /**
     * 根据id查询
     * @param msgId
     * @return
     */
    @Query(value = "SELECT  msg_id,msg_text,msg_summary FROM message WHERE  msg_id = ?1",nativeQuery = true)
    Message findByMsgId(int msgId);

    /**
     * 修改
     * @param msgText
     * @param msgId
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = " UPDATE  message SET msg_text =?1 WHERE msg_id < ?2 ", nativeQuery = true)
    int updateName(String msgText, int msgId);


    /**
     * 分页查询
     * @param msgSummary
     * @param pageable
     * @return
     */
    @Query("SELECT m FROM Message  m WHERE m.msgSummary=?1")
    Page<Message> findByName(String msgSummary, Pageable pageable);


    /**
     * 插入数据
     * @param msgTest
     * @param msgSummary
     * @return
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = " INSERT INTO message(msg_text,msg_summary) VALUES (:msgTest,:msgSummary) ", nativeQuery = true)
    Integer insertMessage(@Param("msgTest") String msgTest, @Param("msgSummary") String msgSummary);
}
