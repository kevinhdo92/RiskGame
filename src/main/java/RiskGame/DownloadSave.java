package RiskGame;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.InputStream;

public class DownloadSave {

    public static InputStream GetInputStream(String fileName) {
        String bucketName = "riskgame";
        AWSCredentials credentials = new BasicAWSCredentials("AKIAIMKWFF2WIMNHS6HQ", "SxUcC23j5Dq9V2rb8QQMqsdEDbWuBsKbOOZvYlx+");
        AmazonS3 s3 = new AmazonS3Client(credentials);
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, fileName));
        return object.getObjectContent();
    }

    public static boolean IsFileExist(String fileName) {
        String bucketName = "riskgame";
        AWSCredentials credentials = new BasicAWSCredentials("AKIAIMKWFF2WIMNHS6HQ", "SxUcC23j5Dq9V2rb8QQMqsdEDbWuBsKbOOZvYlx+");
        AmazonS3 s3 = new AmazonS3Client(credentials);
        return s3.doesObjectExist(bucketName, fileName);
    }
}
