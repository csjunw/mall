package com.xxxx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.server.mapper.DepartmentMapper;
import com.xxxx.server.pojo.Department;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.awt.image.RescaleOp;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junw
 * @since 2021-05-18
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAllDepartments() {

        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * add department
     * @param dep
     */
    @Override
    public RespBean addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
        if(1==dep.getResult()){
            return RespBean.success("add success",dep);
        }

        return RespBean.error("add err");
    }

    /**
     * delete a department
     * @param id
     * @return
     */
    @Override
    public RespBean deleteDep(Integer id) {
        Department dep  = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if(-2 == dep.getResult()){
            return RespBean.error("delete error,this department has son ");
        }
        if(-1 == dep.getResult()){
            return RespBean.error("delete error,this department has employements");
        }
        if(1 == dep.getResult()){
            return RespBean.success("delete success");
        }

        return RespBean.error("delete error");
    }
}
