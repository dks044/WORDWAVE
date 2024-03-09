	package com.wordwave.aws;
	
	import java.io.IOException;
	import java.net.URL;
	import java.net.URLDecoder;
	import java.util.Date;
	
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.stereotype.Service;
	import org.springframework.web.multipart.MultipartFile;
	
	import com.amazonaws.AmazonServiceException;
	import com.amazonaws.HttpMethod;
	import com.amazonaws.services.s3.AmazonS3;
	import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
	import com.amazonaws.services.s3.model.ObjectMetadata;
	
	import lombok.RequiredArgsConstructor;
	import lombok.extern.slf4j.Slf4j;
	
	@Slf4j
	@Service
	@RequiredArgsConstructor
	public class S3Service {
	
	    private final AmazonS3 amazonS3;
	
	    @Value("${cloud.aws.s3.bucket}")
	    private String bucket;
	
	    public String saveFile(MultipartFile multipartFile) throws IOException {
	        String originalFilename = multipartFile.getOriginalFilename();
	
	        ObjectMetadata metadata = new ObjectMetadata();
	        metadata.setContentLength(multipartFile.getSize());
	        metadata.setContentType(multipartFile.getContentType());
	
	        amazonS3.putObject(bucket, originalFilename, multipartFile.getInputStream(), metadata);
	        // 등록된 객체의 url 반환 (decoder: url 안의 한글or특수문자 깨짐 방지)
	        return URLDecoder.decode(amazonS3.getUrl(bucket, originalFilename).toString(), "utf-8");
	    }
	    //*설명*
	    //putObject() 메소드가 파일을 저장해주는 메소드
	    //getURl()을 통해 파일이 저장된 URL을 return 해주고, 이 URL로 이동 시 해당 파일이 오픈됨 
	    //(버킷 정책 변경을 하지 않았으면 파일은 업로드 되지만 해당 URL로 이동 시 accessDenied 됨)
	    
	    /* 2. 파일 삭제 */
	    public void delete (String keyName) {
	        try {
	        	// deleteObject(버킷명, 키값)으로 객체 삭제
	            amazonS3.deleteObject(bucket, keyName);
	        } catch (AmazonServiceException e) {
	            log.error(e.toString());
	        }
	    }
	
	    /* 3. 파일의 presigned URL 반환 */
	    public String getPresignedURL (String keyName) {
	        String preSignedURL = "";
			// presigned URL이 유효하게 동작할 만료기한 설정 (2분)
	        Date expiration = new Date();
	        Long expTimeMillis = expiration.getTime();
	        expTimeMillis += 1000 * 60 * 2;
	        expiration.setTime(expTimeMillis);
	
	        try {
	        	// presigned URL 발급
	            GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, keyName)
	                        .withMethod(HttpMethod.GET)
	                        .withExpiration(expiration);
	            URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
	            preSignedURL = url.toString();
	        } catch (Exception e) {
	            log.error(e.toString());
	        }
	
	        return preSignedURL;
	    }
	}
