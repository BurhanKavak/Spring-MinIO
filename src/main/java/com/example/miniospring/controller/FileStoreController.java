package com.example.miniospring.controller;

import com.example.miniospring.service.FileStoreService;
import io.minio.MinioClient;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/images")
public class FileStoreController {

    private final FileStoreService fileStoreService;


    public FileStoreController(FileStoreService fileStoreService, MinioClient minioClient) {
        this.fileStoreService = fileStoreService;

    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage (@RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(fileStoreService.uploadImage(file), HttpStatus.CREATED);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadImage(@PathVariable("fileName") String fileName) {
        Resource resource = fileStoreService.downloadImage(fileName);
        if (resource != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload/video")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileStoreService.uploadVideo(file));
    }

    @GetMapping("/download/video/{fileName}")
    public ResponseEntity<Resource> downloadVideo(@PathVariable("fileName") String fileName) {
        Resource resource = fileStoreService.downloadVideo(fileName);
        if (resource != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video.mp4"))
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}