package com.soft1851.springboot.jpa.service.impl;

import com.soft1851.springboot.jpa.model.UserDetail;
import com.soft1851.springboot.jpa.repository.UserDetailRepository;
import com.soft1851.springboot.jpa.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @Date: 2020/5/13 21:55
 * @Description:
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailService {

    @Resource
    private UserDetailRepository userDetailRepository;

    @Override
    public Page<UserDetail> findByCondition(String detailParam, Pageable pageable) {
        return userDetailRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            //equal 示例
//            if (!"".equals(detailParam)&& detailParam!=null){
//                log.info("进入if语句");
//                predicates.add(cb.equal(root.get("age"),detailParam));
//            }
            //like示例
//            if (!"".equals(detailParam) && detailParam != null) {
//                predicates.add(cb.like(root.get("hobby"),"%"+detailParam));
//            }
            //between示例
//            if (!"".equals(detailParam) && detailParam != null) {
//                predicates.add(cb.between(root.get("age"), 1, 4));
//            }
            //大于示例
//            if (!"".equals(detailParam) && detailParam != null) {
//                predicates.add(cb.greaterThan(root.get("age"), 1));
//            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }, pageable);
    }

}
