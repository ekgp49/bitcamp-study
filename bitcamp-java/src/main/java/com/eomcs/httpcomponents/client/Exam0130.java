// Apache HttpComponent 사용 - HttpGet 클래스
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;


public class Exam0130 {

  public static void main(String[] args) throws Exception {
    // try-with-resources 적용
    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("https://www.daum.net");

      try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
        System.out.println(response.getCode() + " " + response.getReasonPhrase());
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
      }

    }
  }

}

