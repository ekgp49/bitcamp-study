package com.eomcs.lms.service;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Member;

public interface MemberService {

  List<Member> list() throws Exception;

  int delete(int no) throws Exception;

  int add(Member member) throws Exception;

  Member get(int no) throws Exception;

  Member get(Map<String, Object> params) throws Exception;

  List<Member> search(String keyword) throws Exception;

  int update(Member member) throws Exception;


}
