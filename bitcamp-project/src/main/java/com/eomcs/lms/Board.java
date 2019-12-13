package com.eomcs.lms;

import java.sql.Date;

//게시물 데이터를 저장할 새로운 형태의 메모리를 설계. 식판이라고 생각하면 됨
public class Board {

  //아래 네개는 반찬 칸
  int no;
  String title;
  Date date;
  int viewCount;
}
