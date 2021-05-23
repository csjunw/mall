package com.xxxx.server.controller;

import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限组
 *
 * @author junw on 2021/5/24
 */
@RestController
@RequestMapping("/system/basic/permission")
public class PermissionController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "get all roles")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("add role")
    @PostMapping("/")
    public RespBean addRole(Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("add role success");
        }
        return RespBean.error("add role error");
    }

    @ApiOperation(value = "delete role")
    @DeleteMapping("/role/{id}")
    public RespBean deleteRole(Integer rid){
        if(roleService.removeById(rid)){
            return RespBean.success("delete success");
        }
        return RespBean.error("delete success");
    }
}
