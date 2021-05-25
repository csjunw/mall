package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.AdminRole;
import com.xxxx.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * update operator has role
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId")Integer adminId,@Param("rids") Integer[] rids);
}
