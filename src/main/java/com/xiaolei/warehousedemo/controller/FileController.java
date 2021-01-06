package com.xiaolei.warehousedemo.controller;

import com.xiaolei.warehousedemo.ret.RetResponse;
import com.xiaolei.warehousedemo.ret.RetResult;
import com.xiaolei.warehousedemo.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;

/* 类注解 */
@Api(value = "文件上传接口")
@RestController("/api/File")
public class FileController {
    @Value("${file.uploadFolder}")
    private String uploadFolder;
    private String staticAccessPath ="/static/upload/img/";

    @ApiOperation(value = "图片上传接口")
    @PostMapping("/imgUpload")
    public RetResult<String> imgUpload(@RequestBody MultipartFile file, HttpServletRequest request) throws FileNotFoundException {

        String domain = FileUtil.domain(request);
        String basePath = ResourceUtils.getURL("classpath:").getPath();
        String fileStr = FileUtil.inputUploadFile(file, uploadFolder);

        if(fileStr.equals("NOT_IMAGE")){
            return RetResponse.makeErrRsp("上传失败,"+fileStr);
        }else {
            return RetResponse.makeOKRsp(domain + staticAccessPath + fileStr);
        }

    }
}
