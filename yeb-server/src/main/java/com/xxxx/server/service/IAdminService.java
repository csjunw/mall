package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

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
}
