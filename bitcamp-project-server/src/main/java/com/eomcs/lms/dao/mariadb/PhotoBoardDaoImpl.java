package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.sql.DataSource;

public class PhotoBoardDaoImpl implements PhotoBoardDao {
  DataSource dataSource;
  SqlSessionFactory sqlSessionFactory;

  public PhotoBoardDaoImpl(DataSource dataSource, SqlSessionFactory sqlSessionFactory) {
    this.dataSource = dataSource;
    this.sqlSessionFactory = sqlSessionFactory;
  }


  @Override
  public List<PhotoBoard> findAllByLessonNo(int lessonNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("PhotoBoardMapper.selectPhotoBoard", lessonNo);
    }
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.insert("PhotoBoardMapper.insertPhotoBoard", photoBoard);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("PhotoBoardMapper.detailPhotoBoard", no);
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.update("PhotoBoardMapper.updatePhotoBoard", photoBoard);
      sqlSession.commit();
      return count;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int count = sqlSession.delete("PhotoBoardMapper.deletePhotoBoard", no);
      sqlSession.commit();
      return count;
    }
  }

}
