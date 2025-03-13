package com.example.demo_final_project.Manger;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.util.Timeout;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class YahooFinanceAPI {
    private static final String BASE_URL = "https://query1.finance.yahoo.com/v1/test/getcrumb";
    private static final String HOME_URL = "https://fc.yahoo.com";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    public static void main(String[] args) {
        try {
            String crumb = getNewCrumb3();
            System.out.println("Crumb: " + crumb);
            String crumb1 = getNewCrumb3();
            System.out.println("Crumb: " + crumb1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getNewCrumb() throws IOException {
        CookieStore cookieStore = new BasicCookieStore();

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(Timeout.ofSeconds(5))
                .setResponseTimeout(Timeout.ofSeconds(5))
                .build();

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .setDefaultRequestConfig(requestConfig)
                .setUserAgent(USER_AGENT)
                .build()) {

            // **Step 1: 訪問 Yahoo Finance 取得 Cookie**
            HttpGet homeRequest = new HttpGet(HOME_URL);
            try (CloseableHttpResponse homeResponse = httpClient.execute(homeRequest)) {
                HttpEntity entity = homeResponse.getEntity();
                EntityUtils.consume(entity); // 讀取回應，觸發 Cookie 設置
            }

            // **Step 2: 用 Cookie 取得 Crumb**
            RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", USER_AGENT);
            
            ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, String.class);
            
            return response.getBody();
        }


    }

  //   public static String getNewCrumb2() throws IOException {
  //     CookieStore cookieStore = new BasicCookieStore();
  
  //     RequestConfig requestConfig = RequestConfig.custom()
  //             .setConnectTimeout(Timeout.ofSeconds(5))
  //             .setResponseTimeout(Timeout.ofSeconds(5))
  //             .build();
  
  //     try (CloseableHttpClient httpClient = HttpClients.custom()
  //             .setDefaultCookieStore(cookieStore)
  //             .setDefaultRequestConfig(requestConfig)
  //             .setUserAgent(USER_AGENT)
  //             .build()) {
  
  //         // **Step 1: 訪問 Yahoo Finance 取得 Cookie**
  //         HttpGet homeRequest = new HttpGet(HOME_URL);
  //         try (CloseableHttpResponse homeResponse = httpClient.execute(homeRequest)) {
  //             HttpEntity entity = homeResponse.getEntity();
  //             EntityUtils.consume(entity); // 讀取回應，觸發 Cookie 設置
  //         }
  
  //         // **Step 2: 用 Cookie 取得 Crumb**
  //         RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
  //         HttpHeaders headers = new HttpHeaders();
  //         headers.set("User-Agent", USER_AGENT);
  
  //         ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, String.class);
          
  //         String crumb = response.getBody();
  
  //         // **手動清空 CookieStore**
  //         cookieStore.clear();  
  
  //         return crumb;
  //     }
  // }

    // static final CookieStore cookieStore = new BasicCookieStore();
    // static final RequestConfig requestConfig = RequestConfig.custom()
    //       .setConnectTimeout(Timeout.ofSeconds(5))
    //       .setResponseTimeout(Timeout.ofSeconds(5))
    //       .build();
    // static final CloseableHttpClient httpClient = HttpClients.custom()
    //           .setDefaultCookieStore(cookieStore)
    //           .setDefaultRequestConfig(requestConfig)
    //           .setUserAgent(USER_AGENT)
    //           .build() ;
    // static final  RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));




      public static String getNewCrumb3() throws IOException {
        
         CookieStore cookieStore = new BasicCookieStore();
        RequestConfig requestConfig = RequestConfig.custom()
          .setConnectTimeout(Timeout.ofSeconds(5))
          .setResponseTimeout(Timeout.ofSeconds(5))
          .build();
      CloseableHttpClient httpClient = HttpClients.custom()
              .setDefaultCookieStore(cookieStore)
              .setDefaultRequestConfig(requestConfig)
              .setUserAgent(USER_AGENT)
              .build() ;
       RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
          // **Step 1: 訪問 Yahoo Finance 取得 Cookie**
          HttpGet homeRequest = new HttpGet(HOME_URL);
          CloseableHttpResponse homeResponse = httpClient.execute(homeRequest) ;
              HttpEntity entity = homeResponse.getEntity();
              EntityUtils.consume(entity); // 讀取回應，觸發 Cookie 設置
          
  
          // **Step 2: 用 Cookie 取得 Crumb**
          HttpHeaders headers = new HttpHeaders();
          headers.set("User-Agent", USER_AGENT);
  
          ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, String.class);
          
          String crumb = response.getBody();
  
          // **手動清空 CookieStore**
           //cookieStore.clear();  
  
          return crumb;
      
  }

//   static final CookieStore cookieStore = new BasicCookieStore();
//     static final PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    
//     static final RequestConfig requestConfig = RequestConfig.custom()
//             .setConnectTimeout(Timeout.ofSeconds(5))
//             .setResponseTimeout(Timeout.ofSeconds(5))
//             .build();
    
//     static final CloseableHttpClient httpClient = HttpClients.custom()
//             .setConnectionManager(connectionManager)
//             .setDefaultCookieStore(cookieStore)
//             .setDefaultRequestConfig(requestConfig)
//             .setUserAgent(USER_AGENT)
//             .build();
    
//     // 用這個 RestTemplate 發送請求，始終使用同一個 httpClient
//     static final RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));

//     public static String getNewCrumb4() throws IOException {
//         // 如果 CookieStore 為空，先訪問 Yahoo Finance 取得 Cookie
//         if (cookieStore.getCookies().isEmpty()) {
//             HttpGet homeRequest = new HttpGet(HOME_URL);
//             try (CloseableHttpResponse homeResponse = httpClient.execute(homeRequest)) {
//                 HttpEntity entity = homeResponse.getEntity();
//                 EntityUtils.consume(entity); // 觸發 Cookie 設置
//             }
//         }
        
//         // 使用相同的 httpClient 與 CookieStore 發送 crumb 請求
//         ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, String.class);
//         return response.getBody();
//     }
  
}
