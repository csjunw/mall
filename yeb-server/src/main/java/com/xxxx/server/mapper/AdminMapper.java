package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */

public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * get all operator but current oprerator
     * @param id
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(Integer id, String keywords);
}
