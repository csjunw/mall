package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

}
