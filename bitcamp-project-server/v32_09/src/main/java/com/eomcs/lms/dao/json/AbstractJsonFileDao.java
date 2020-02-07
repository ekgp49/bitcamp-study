package com.eomcs.lms.dao.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

// 서브 클래스에게 공통 필드나 메드를 상속해주는 역할을 하기 때문에
// => abstract
public abstract class AbstractJsonFileDao<T> {
  protected String filename;
  protected List<T> list;

  public AbstractJsonFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  protected void loadData() {
    File file = new File(filename);
    try (BufferedReader in = new BufferedReader(new FileReader(file))) {

      // 현재 클래스의 정보를 알아낸다.
      Class<?> currType = this.getClass();
      System.out.println(currType);

      // 제네틱타입의 수퍼 클래스 정보를 알아낸다.
      Type parentType = currType.getGenericSuperclass();
      System.out.println(parentType);

      // 수퍼클래스의 타입 파라미터중에서 T 값을 추출한다.
      // => 수퍼클래스에 제네릭이 적용된 경우 실제 타입은 다음과 같다.
      ParameterizedType parentType2 = (ParameterizedType) parentType;

      // => 제네릭 수퍼 클래스 정보로부터 타입파라미터 목록을 꺼낸다
      Type[] typeParams = parentType2.getActualTypeArguments();

      Type itemType = typeParams[0];
      System.out.println(itemType);

      T[] arr = (T[]) Array.newInstance((Class) itemType, 0);

      T[] dataArray = (T[]) new Gson().fromJson(in, arr.getClass());
      for (T b : dataArray) {
        list.add(b);
      }

      System.out.printf("총 %d개의 객체를 로딩했습니다.\n", list.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생 - " + e.getMessage());
    }
  }

  protected void saveData() {
    File file = new File(filename);
    try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {


      out.write(new Gson().toJson(list));
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
