package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * get all departments
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * add department
     * @param dep
     */
    void addDep(Department dep);
}
