package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录之后返回token。
     * @param username
     * @param password
     * @param captcha
     * @param request
     * @return
     */
    RespBean login(String username, String password, String captcha, HttpServletRequest request);

    /**
     * 通过用户名去获取Admin对象
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**
     * get all operator
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * update operator roles
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);
}
