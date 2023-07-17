package com.example.miniospring.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStoreService {

    String uploadImage(MultipartFile file);

    Resource downloadImage(String fileName);

    String uploadVideo(MultipartFile file);

    Resource downloadVideo(String fileName);

}
