package com.caihao.password_manager.algorithm.recursive;

/**
 * TODO
 *
 * @author caihao
 * @date 2020/3/3 21:22
 */
public class CombinationTest {
  public static final int COMBINATION_CNT = 2;        // 组合中需要被选中的个数
  public static void combination(int[] arr, int k, int[] select) {

    int selectNum = selectedNum(select);
    // 终止条件2：选中的元素已经等于我们要选择的数组个数了
    if (selectNum == COMBINATION_CNT) {
      for (int j = 0; j < select.length; j++) {
        if (select[j] == 1) {
          System.out.print(arr[j]);
        }
      }
      System.out.print("\n");
    } else {
      // 终止条件1：开始选取的数组索引 超出数组范围了
      if (k >= arr.length) {
        return;
      }

      // 第 k 位被选中
      select[k] = 1;
      combination(arr, k+1, select);

      // 第 k 位未被选中
      select[k] = 0;
      // 则从第 k+1 位选择 COMBINATION_CNT - selectNum 个元素
      combination(arr, k+1, select);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4};
    int[] select = {0,0,0,0};
    // 一开始从 0 开始选 组合数
    combination(arr, 0, select);
  }

  public static int selectedNum(int[] arr){
    int select = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i]==1){
        select++;
      }
    }
    return select;
  }

}
  