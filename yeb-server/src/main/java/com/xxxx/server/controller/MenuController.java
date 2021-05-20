package com.xxxx.server.controller;


import com.xxxx.server.pojo.Menu;
import com.xxxx.server.service.IAdminService;
import com.xxxx.server.service.IMenuService;
import com.xxxx.server.service.impl.AdminServiceImpl;
import com.xxxx.server.service.impl.MenuServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/system/cfg")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    //不从前端传信息，而是通过后端直接获取，防止别人拦截篡改。通过Spring Security获得全局对象
    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/Menu")
    public List<Menu> getMenusByAdminId(){
        return menuService.getMenusByAdminId();
    }
}
