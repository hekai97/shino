package com.hekai.backend.utils;

import com.hekai.backend.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CommonFunction {
    public static ServerResponse<String> uploadImage(MultipartFile image,String path){
        try {
            File file=new File(path, UUIDUtil.generationFileName()+ Objects.requireNonNull(image.getOriginalFilename()).substring(image.getOriginalFilename().lastIndexOf(".")));
            image.transferTo(file);
            String newPath=file.getPath();
            return ServerResponse.createRespBySuccess(RegexUtil.getRelativePath(newPath));
        } catch (IOException e) {
            return ServerResponse.createByErrorMessage("图片上传错误！");
        }
    }
}
