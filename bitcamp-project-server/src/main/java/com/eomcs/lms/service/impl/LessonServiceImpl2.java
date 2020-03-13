package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

public class LessonServiceImpl2 implements LessonService {
  SqlSessionFactory sqlSessionFactory;

  public LessonServiceImpl2(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public Lesson get(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession 객체를 사용하여 BoardDao의 구현체를 얻는다.
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      return lessonDao.findByNo(no);
    }
  }

  @Override
  public int add(Lesson lesson) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession 객체를 사용하여 BoardDao의 구현체를 얻는다.
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      return lessonDao.insert(lesson);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession 객체를 사용하여 BoardDao의 구현체를 얻는다.
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      return lessonDao.delete(no);
    }
  }

  @Override
  public List<Lesson> list() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession 객체를 사용하여 BoardDao의 구현체를 얻는다.
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      return lessonDao.findAll();
    }
  }

  @Override
  public List<Lesson> search(HashMap<String, Object> params) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession 객체를 사용하여 BoardDao의 구현체를 얻는다.
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      return lessonDao.findByKeyword(params);
    }
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession 객체를 사용하여 BoardDao의 구현체를 얻는다.
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);
      return lessonDao.update(lesson);
    }
  }
}


