package com.xxxx.server.service.impl;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.MenuRoleMapper;
import com.xxxx.server.pojo.Menu;
import com.xxxx.server.pojo.MenuRole;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;
    /**
     * update role menu
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {

        //删除角色下所有的菜单
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if(null==mids || 0==mids.length){
            return RespBean.success("update success");
        }
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        if(result == mids.length){
            return RespBean.success("update success");
        }
        return RespBean.error("update error");
    }
}
