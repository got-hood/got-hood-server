package com.gachon.gothood.domain.image.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
@Service
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(MultipartFile multipartFile) throws IOException {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getInputStream().available());

        amazonS3.putObject(bucket, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), objectMetadata);
        return amazonS3.getUrl(bucket, multipartFile.getOriginalFilename()).toString();
    }

    public void delete(String fileName) {
        try {
            amazonS3.deleteObject(bucket, fileName);
        } catch (AmazonS3Exception e) {
            System.err.println(e.getErrorMessage());
        }
    }
}
