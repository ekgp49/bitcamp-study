// Apache HttpComponent 사용 - HttpGet 클래스
package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

public class Exam0140 {

  public static void main(String[] args) throws Exception {
    // 더 간결하게 HTTP 요청하기
    // => httpclient-fluent 라이브러리 추가
    Content content = Request.get("https://daum.net").execute().returnContent();
    System.out.println(content.toString());
  }
}

