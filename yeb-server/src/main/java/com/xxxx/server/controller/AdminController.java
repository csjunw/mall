package com.xxxx.server.controller;


import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.service.IRoleService;
import com.xxxx.server.service.impl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.PushBuilder;
import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.ResourceBundle;

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
    @Autowired
    private IRoleService roleService;
    @ApiOperation(value = "get all operator")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }
    @ApiOperation(value = "update a operator info")
    @PutMapping("/")
    public RespBean updateAdmin(Admin admin){
        if(adminService.updateById(admin)){
            return RespBean.success("update success");
        }
        return RespBean.error("update erorr");
    }

    @ApiOperation(value = "delete a operator")
    @DeleteMapping("/")
    public RespBean deleteAdmin(Integer id){
        if(adminService.removeById(id)){
            return RespBean.success("delete success");
        }
        return RespBean.error("delete error");
    }
    @ApiOperation(value = "get all roles")
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }
    @ApiOperation(value = "update operator has roles")
    @PutMapping("/role")
    public RespBean updateAdminRole(Integer adminId,Integer[] rids){

        return adminService.updateAdminRole(adminId,rids);
    }



}
