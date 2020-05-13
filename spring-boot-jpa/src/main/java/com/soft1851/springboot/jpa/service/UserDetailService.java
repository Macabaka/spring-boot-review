package com.soft1851.springboot.jpa.service;

import com.soft1851.springboot.jpa.model.UserDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Johnny
 * @Date: 2020/5/13 21:44
 * @Description:
 */
public interface UserDetailService {
    Page<UserDetail> findByCondition(String  detailParam, Pageable pageable);

}
