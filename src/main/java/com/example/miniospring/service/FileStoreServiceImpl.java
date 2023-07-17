package com.example.miniospring.service;


import java.io.InputStream;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;


@Slf4j
@Service
@RequiredArgsConstructor
public class FileStoreServiceImpl implements FileStoreService {


    private final MinioClient minioClient;

    @Value("${spring.minio.bucket}")
    private String bucketName;

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                InputStream inputStream = file.getInputStream();
                long size = file.getSize();
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(fileName)
                                .stream(inputStream, size, -1)
                                .contentType(file.getContentType())
                                .build()
                ).bucket();
                return "Image uploaded successfully.";
            } else {
                return "No file selected.";
            }
        } catch (Exception e) {
            return "Failed to upload image.";
        }
    }

    @Override
    public Resource downloadImage(String fileName) {
        try {
            InputStream inputStream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            return new InputStreamResource(inputStream);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String uploadVideo(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                InputStream inputStream = file.getInputStream();
                long size = file.getSize();
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(bucketName)
                                .object(fileName)
                                .stream(inputStream, size, -1)
                                .contentType(file.getContentType())
                                .build()
                );
                return "Video uploaded successfully.";
            } else {
                return "No file selected.";
            }
        } catch (Exception e) {
            return "Failed to upload video.";
        }
    }

    @Override
    public Resource downloadVideo(String fileName) {
        try {
            InputStream inputStream = minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(fileName)
                            .build()
            );
            return new InputStreamResource(inputStream);
        } catch (Exception e) {
            return null;
        }
    }


}

