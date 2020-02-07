package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.BoardDao;

public class BoardDeleteServlet implements Servlet {
  BoardDao boardDao;

  public BoardDeleteServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();

    if (boardDao.delete(no) > 0) {
      out.writeUTF("OK");
      out.writeUTF("게시글을 삭제했습니다.");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당번호의 게시물이 없습니다.");
    }
  }
}
