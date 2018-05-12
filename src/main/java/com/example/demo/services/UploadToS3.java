package com.example.demo.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;

public class UploadToS3 {

    @Value("${AWSAPIKEY}")
    String apiKey;

    @Value("${AWSSECRETKEY}")
    String secretKey;


    @Value("${BUCKETNAME}")
    String bucketName;


    public String upload(String filename, FileInputStream fs){
        String fileURI;
        BasicAWSCredentials cred = new BasicAWSCredentials(apiKey,
                secretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred))
                .withRegion(Regions.US_EAST_2).build();

            PutObjectRequest putReq = new PutObjectRequest(bucketName, filename,
                    fs, new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);

            s3Client.putObject(putReq);
            fileURI = "http://"+bucketName+".s3.amazonaws.com/"+filename;

            return fileURI;

    }

}
