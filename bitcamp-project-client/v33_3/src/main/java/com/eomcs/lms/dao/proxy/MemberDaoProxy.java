package com.eomcs.lms.dao.proxy;

import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDaoProxy implements MemberDao {
  DaoProxyHelper daoProxyHelper;

  public MemberDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Member> findAll() throws Exception {
    return (List<Member>) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/member/list");
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (List<Member>) in.readObject();
    });
  }

  @Override
  public int insert(Member member) throws Exception {
    return (int) daoProxyHelper.request(new MemberInsertWorker(member));
  }

  @Override
  public Member findByNo(int no) throws Exception {
    return (Member) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/member/detail");
      out.writeInt(no);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (Member) in.readObject();
    });
  }

  @Override
  public int update(Member member) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/member/update");
      out.writeObject(member);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }

  @Override
  public int delete(int no) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/member/delete");
      out.writeInt(no);
      out.flush();
      if (in.readUTF().equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      System.out.println(in.readUTF());
      return 1;
    });
  }
}
