package com.xxxx.server.controller;


import com.xxxx.server.pojo.Admin;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.service.impl.AdminServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.PushBuilder;
import javax.swing.plaf.PanelUI;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @ApiOperation(value = "get all operator")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }

}
