package com.caihao.password_manager.algorithm.recursive;

/**
 * 细胞分裂 有一个细胞 每一个小时分裂一次，一次分裂一个子细胞，第三个小时后会死亡。
 * 那么n个小时候有多少细胞？
 *
 * @author caihao
 * @date 2020/3/3 14:49
 */
public class CellDivisionTest {

  public static void main(String[] args) {
    System.out.println(allCells(1));
    System.out.println(allCells(2));
    System.out.println(allCells(3));
    System.out.println(allCells(4));
    System.out.println(allCells(5));
  }

  // n小时后的细胞数
  static int allCells(int n) {
    return aCells(n) + bCells(n) + cCells(n);
  }

  static int aCells(int n){
    if (n==1){
      return 1;
    }
    return aCells(n-1)+bCells(n-1)+cCells(n-1);
  }

  static int bCells(int n) {
    if (n == 1) {
      return 0;
    }
    return aCells(n - 1);
  }

  static int cCells(int n) {
    if (n == 1 || n == 2) {
      return 0;
    }
    return bCells(n - 1);
  }
}
