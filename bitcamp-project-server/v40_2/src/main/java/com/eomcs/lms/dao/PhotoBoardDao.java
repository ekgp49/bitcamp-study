package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {
  List<PhotoBoard> findAllByLessonNo(int lessonNo) throws Exception;

  int insert(PhotoBoard photoBoard) throws Exception;

  PhotoBoard findByNo(int no) throws Exception;

  int update(PhotoBoard photoBoard) throws Exception;

  int delete(int no) throws Exception;

}
