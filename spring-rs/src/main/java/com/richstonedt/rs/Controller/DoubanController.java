package com.richstonedt.rs.Controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.richstonedt.common.util.EntityUtils;
import com.richstonedt.cs.mapper.DoubanMapper;
import com.richstonedt.cs.service.DoubanService;
import com.richstonedt.model.common.ResponseResult;
import com.richstonedt.model.po.Douban;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cheng
 * @since 2020-03-16
 */

@RestController
@RequestMapping("/douban")
@Api(tags = "DoubanController")
public class DoubanController {

    @Autowired
    private final DoubanService doubanService;

    public DoubanController(DoubanService doubanService) {
        this.doubanService = doubanService;
    }


    @GetMapping("/list")
    @ApiOperation("获取全部豆瓣数据")
    public ResponseResult<List<Douban>> listDouban(){
        return ResponseResult.success(doubanService.list());
    }

    @PostMapping
    @ApiOperation("新增豆瓣数据")
    public ResponseResult<String> addDouban(Douban douban){
        return doubanService.save(douban)?
                ResponseResult.success("新增成功"):
                ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR,"新增失败","");
    }

    @PostMapping("/batch")
    @ApiOperation("批量插入数据")
    public ResponseResult<String> batchDouban(@RequestBody List<Douban> doubanList){
        return doubanService.saveBatch(EntityUtils.insertBatchEntityWrapper(doubanList))?
                ResponseResult.success("批量新增成功"):
                ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR,"批量新增失败","");
    }



    @DeleteMapping
    @ApiOperation("删除豆瓣信息")
    public ResponseResult<String> deleteDouban(String ranking){
        Douban douban = new Douban();
        douban.setRanking(ranking);
        return doubanService.removeById(douban)?
                ResponseResult.success("删除成功"):
                ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR,"删除失败","");
    }

    @PutMapping
    @ApiOperation("更新豆瓣数据")
    public ResponseResult<String> updateDouban(Douban douban){
        return doubanService.updateById(douban)?
                ResponseResult.success("更新成功"):
                ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR,"更新失败","");
    }

}

