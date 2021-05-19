package com.xxxx.server.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.AdminLoginParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Api(tags ="LoginController")
public class LoginController {
    @Autowired
    private IAdminService adminService;



    //登录，如果登录成功，则返回token。前端保存token，之后每次请求都携带token。
    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }

    //将userDetails放在了Security的全局中,所以可以通过Principal得到登录者姓名
    @ApiOperation(value = "获取登录者的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(null ==principal){
            return null;
        }

        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }


    //前端去负责退出登录的功能，我们返回状态码200，前端拿到这个状态码，直接将请求头删除。
    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功");
    }


}
