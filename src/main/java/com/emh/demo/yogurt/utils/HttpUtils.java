package com.emh.demo.yogurt.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@Slf4j
public class HttpUtils {

    public static String getWithHeaders(String url, Map<String, String> headers) {
        final HttpGet httpGet = new HttpGet(url);
        if (!CollectionUtils.isEmpty(headers)) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                httpGet.addHeader(header.getKey(), header.getValue());
            }
        }

        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            log.info("[HttpUtils/getWithHeaders INFO] res: {}", httpResponse);
            if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            log.error("[HttpUtils/getWithHeaders ERROR] error:", e);
        }
        return null;
    }
}
