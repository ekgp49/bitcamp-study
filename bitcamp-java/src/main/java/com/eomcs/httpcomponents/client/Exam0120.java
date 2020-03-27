// Apache HttpComponent 사용 - HttpGet 클래스
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;


public class Exam0120 {

  public static void main(String[] args) throws Exception {
    CloseableHttpClient httpClient = HttpClients.createDefault();

    HttpGet get = new HttpGet("https://www.daum.net");

    CloseableHttpResponse response = httpClient.execute(get);

    HttpEntity entity = response.getEntity();

    if (entity != null) {

      System.out.printf("응답 데이터 크기 => %d\n", entity.getContentLength());
      System.out.printf("응답 데이터의 타입 => %s\n", entity.getContentType());

      System.out.println("---------------------------------");

      // HttpEntity에 들어 있는 서버 응답 데이터를 꺼내려면 getContent()를 사용해야 한다.
      // getContent()의 리턴 값은 InputStream 객체이다.
      // InputStream을 가지고 데이터를 읽으려면 입출력 코딩을 작성해야 한다.
      // => 이 부분을 대신 해주는 도우미 클래스가 있다.
      String content = EntityUtils.toString(entity);
      System.out.println(content);
    }
  }

}

