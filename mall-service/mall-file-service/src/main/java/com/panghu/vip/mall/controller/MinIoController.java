package com.panghu.vip.mall.controller;

import com.panghu.vip.mall.config.MinIoProperties;
import com.panghu.vip.mall.config.MinIoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * @author 胖虎
 * @date 2022/5/9 下午 3:35
 */
@RestController
@RequestMapping("/minio")
public class MinIoController {

    @Autowired
    MinIoProperties minIoProperties;

    /**
     * 上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        String fileUrl = MinIoUtil.upload(minIoProperties.getBucketName(), file);
        return "文件下载地址：" + fileUrl;
    }

    @GetMapping(value = "/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        MinIoUtil.download(minIoProperties.getBucketName(), fileName, response);
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam("fileName") String fileName) {
        MinIoUtil.deleteFile(minIoProperties.getBucketName(), fileName);
        return "删除成功";
    }

}
