package com.richstonedt.rs.Controller;

import com.richstonedt.common.util.IdUtils;
import com.richstonedt.model.common.ResponseResult;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@Slf4j
@RequestMapping("file")
@Api(tags = "UploadController")
public class UploadController {

    private final String uploadFilePath = "/tmp/uploadfile";

    @PostMapping("/upload")
    public ResponseResult<Object> httpupload(MultipartFile file){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
            String fileName = sdf.format(new Date()) + file.getOriginalFilename();
            File dest = new File(new File(uploadFilePath).getAbsolutePath() + "/" + fileName);
            if (!dest.getParentFile().exists()){
                if (!dest.getParentFile().mkdirs()){
                    throw new IOException("创建目录失败");
                }
            }
            file.transferTo(dest);
            return ResponseResult.success(fileName);
        }
        catch (IOException e){
            log.error("保存文件出错",e);
            return ResponseResult.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
