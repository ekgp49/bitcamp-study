package com.eomcs.sql;

public class TransactionTemplate {
  PlatformTransactionManager txManager;

  public TransactionTemplate(PlatformTransactionManager txManager) {
    this.txManager = txManager;
  }

  public Object execute(TransactionCallback action) throws Exception {
    txManager.beginTransaction();
    try {
      // 트랜잭션으로 묶인 작업들
      Object result = null;

      action.doInTransaction();

      txManager.commit();
      return result;
    } catch (Exception e) {
      // 예외가 발생하면 지금까지 한 작업을 취소한다
      txManager.rollback();
      throw e;
    }
  }
}
