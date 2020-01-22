package com.example.cursomcsozinho.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	
	@Value("${aws.access_key_id}")
	private String ACCESS_KEY;
	@Value("${aws.secret_access_key}")
	private String SECRET_KEY;
	@Value("${s3.region}")
	private String REGION;

	@Bean
	public AmazonS3 s3client() {
		
		BasicAWSCredentials awsCred = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		return AmazonS3ClientBuilder.standard().withRegion(REGION)
	            .withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
	}
	
}
