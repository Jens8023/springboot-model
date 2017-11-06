package com.jens.springbootmodel.support;


import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

/**
 * =========================
 * FileName➤
 * Des☛
 * Date☀ 2017/10/16 || 17:22
 * @author Jens
 * =========================
 */
@Slf4j
@Service
public class OkClient {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    static OkHttpClient client = new OkHttpClient();

    public static String Post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public static String Get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * 上传文件  --根据本地固定位置的文件上传
     * @param url
     * @param fileAddr
     * @param dataMap
     * @return
     */
    public static String uploadFile(String url, String fileAddr, Map<String, String> dataMap) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        //"file"是固定写法,不能动
        parameters.add("file", new FileSystemResource(fileAddr));

        if (dataMap!=null) {
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                parameters.add(key, value);
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        headers.set("Accept", "text/plain");

        String result = restTemplate.postForObject(
                url,
                new HttpEntity<MultiValueMap<String, Object>>(parameters, headers),
                String.class);
        return result;
    }

    /**
     * 上传文件  --根据选择文件(位置不固定)上传文件
     * @param url
     * @return
     */
    public static String uploadFileEx(String url, MultipartFile file, HttpServletRequest request) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();

        //保存文件到工程
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
        File dir = new File(uploadDir);
        if( !dir.exists()){
            dir.mkdir();
        }
        String fileName = file.getOriginalFilename();
        File serverFile = new File(uploadDir + fileName);
        file.transferTo(serverFile);

        //"file"是固定写法,不能动
        String fileAddr = uploadDir + fileName;
        parameters.add("file", new FileSystemResource(fileAddr));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        headers.set("Accept", "text/plain");

        String result = restTemplate.postForObject(
                url,
                new HttpEntity<MultiValueMap<String, Object>>(parameters, headers),
                String.class);
        return result;
    }


    /**
     * 下载文件 --直接保存在本地
     * @apiNote 自动覆盖本地同名文件
     * @param url
     * @param fileAddr
     * @return
     */
    public static void downloadFile(String url, String fileAddr) {
        try (InputStream inputStream = new URL(url).openStream()) {
            Files.copy(inputStream, Paths.get(fileAddr), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 下载文件  --由网页地址请求下载
     * @param url
     * @return
     */
    public static InputStream downloadFileEx(String url) {
        InputStream inputStream = null;
        try {
            inputStream = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
