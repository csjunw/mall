package com.xxxx.server.controller;


import com.xxxx.server.pojo.Position;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.cldr.es.CalendarData_es_PY;

import javax.crypto.interfaces.PBEKey;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
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
@RequestMapping("/system/basic/position")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPosition(){
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/add")
    public RespBean addPositon(Position position){
        position.setCreateDate(LocalDate.now());
        if(positionService.save(position)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");

    }

    @ApiOperation(value = "添加职位信息")
    @PutMapping("/update")
    public  RespBean updatePosition(Position position){
        if(positionService.updateById(position)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(Integer id){
        if(positionService.removeById(id)){
           return  RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/{ids}")
    public RespBean deleteBatchPosition(String ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除成功");
        }
        return RespBean.error("批量删除失败");

    }

}
