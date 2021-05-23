package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.MenuRole;
import com.xxxx.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * update role menu
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
