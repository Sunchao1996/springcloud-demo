package com.sc.zull.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * what:   服务网关的服务降级-针对某个服务
 *
 * @author 孙超 created on 2018/7/14
 */
@Component
public class ProductFallbackProvider implements ZuulFallbackProvider {
    // 代表为那个服务提供fallback
    @Override
    public String getRoute() {
        return "e-book-product";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            /**
             * 返回状态码
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 0;
            }

            @Override
            public String getStatusText() throws IOException {
                // httpresponse的fallback的状态码，string
                return this.getStatusCode().toString();
            }

            @Override
            public void close() {

            }

            /**
             * 响应内容
             */
            @Override
            public InputStream getBody() throws IOException {
                String body = "商品服务不可用";
                return new ByteArrayInputStream(body.getBytes());
            }

            /**
             * 响应头
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders();
                //相当于
                MediaType mediaType = new MediaType("application", "json", Charset.forName("utf-8"));
                header.setContentType(mediaType);
                return header;
            }
        };
    }
}
