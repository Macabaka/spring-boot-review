package com.soft1851.springboot.time.repository;

import com.soft1851.springboot.time.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johnny
 * @Date: 2020/5/18 09:03
 * @Description:
 */
public interface CodeRepository extends JpaRepository<Coder,Integer> {
    /**
     *
     * @param id
     * @return
     */
    Coder findCoderById(int id);
}
