package com.xxxx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
public interface IDepartmentService extends IService<Department> {


    /**
     * get all departments
     * @return
     */
    List<Department> getAllDepartments();
}
