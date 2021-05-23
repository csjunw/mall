package com.xxxx.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.MenuRole;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;
import com.xxxx.server.service.IMenuRoleService;
import com.xxxx.server.service.IMenuService;
import com.xxxx.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

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
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation(value = "get all roles")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("add role")
    @PostMapping("/role")
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
    @ApiOperation(value = "query all menus")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "query menu id by role id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(Integer rid){
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "updae role menus")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }

}
