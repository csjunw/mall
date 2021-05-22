package com.xxxx.server.controller;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.sun.org.apache.regexp.internal.RE;
import com.xxxx.server.pojo.Joblevel;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.interfaces.PBEKey;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
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
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/add")
    public RespBean addJobLevel(Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.save(joblevel)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新职位")
    @PostMapping("/update")
    public RespBean updateJobLevel(Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.updateById(joblevel)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "delete positon")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(Integer id){
        if(joblevelService.removeById(id)){
            return RespBean.success("delete success");
        }
        return RespBean.error("delete error");
    }

    @ApiOperation(value = "batch delete position")
    @DeleteMapping("/{ids}")
    public RespBean deleteBatchJobLevl(String ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("delete batch success");
        }
        return RespBean.error("delete batch error");
    }




}
