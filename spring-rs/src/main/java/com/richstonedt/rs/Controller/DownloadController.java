package com.richstonedt.rs.Controller;


import com.richstonedt.common.util.DownloadFileUtils;
import com.richstonedt.common.util.ExcelUtils;
import com.richstonedt.cs.service.DoubanService;
import com.richstonedt.model.common.ResponseResult;
import com.richstonedt.model.param.DoubanParams;
import com.richstonedt.model.po.Douban;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Api(tags = "DownloadController")
public class DownloadController {
    private DoubanService doubanService;

    @GetMapping("/excel")
    @ApiOperation("下载Excel文件")
    public ResponseEntity<InputStreamResource> downloadExcel(DoubanParams params, String id) throws IOException {
        String fileName = ExcelUtils.exportToExcel(doubanService.listByParams(params), Douban.class);
        return DownloadFileUtils.fileToStream(fileName, "导出豆瓣数据");
    }
}
