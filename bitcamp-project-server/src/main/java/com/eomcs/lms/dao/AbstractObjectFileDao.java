package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// 서브 클래스에게 공통 필드나 메드를 상속해주는 역할을 하기 때문에
// => abstract
public abstract class AbstractObjectFileDao<T> {
  protected String filename;
  protected List<T> list;

  public AbstractObjectFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();
  }

  @SuppressWarnings("unchecked")
  protected void loadData() {
    File file = new File(filename);
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      list = (List<T>) in.readObject();
      System.out.printf("총 %d개의 객체를 로딩했습니다.\n", list.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생 - " + e.getMessage());
    }
  }

  protected void saveData() {
    File file = new File(filename);
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset();
      out.writeObject(list);
      System.out.printf("총 %d 개의 객체를 저장했습니다.\n", list.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  // 서브 클래스들의 공통 메서드이기 때문에
  // => 수퍼클래스에 정의한다.
  // 서브 클래스에서 접근할 수 있어야 하기 때문에
  // => protected
  // 서브클래스마다 구현 방법이 다르기 때문에 구현하면 안된다.
  // => abstract
  // 서브 클래스에서 반드시 구현해야 할 메서드이기 때문에
  // => abstract
  protected abstract <K> int indexOf(K key);

}
