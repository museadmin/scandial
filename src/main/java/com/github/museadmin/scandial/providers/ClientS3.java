package com.github.museadmin.scandial.providers;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.IOException;

public class ClientS3 {

  public static void main(String[] args) throws IOException {
    AWSCredentials credentials = null;
    try {
      credentials = new ProfileCredentialsProvider("museadmin").getCredentials();
    } catch (Exception e) {
      throw new AmazonClientException(
          "Cannot load the credentials from the credential profiles file. " +
              "Please make sure that your credentials file is at the correct " +
              "location (~/.aws/credentials), and is in valid format.",
          e);
    }

    AmazonS3 s3 = AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .withRegion("us-west-2")
        .build();

    int x = 0;
  }




}
