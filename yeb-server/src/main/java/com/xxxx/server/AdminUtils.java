package com.xxxx.server;

import com.xxxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Tools
 *
 * @author junw on 2021/5/26
 */
public class AdminUtils {
    /**
     * get current operator
     * @return
     */
    public  static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
