package com.caihao.password_manager.algorithm.recursive;

import java.util.Arrays;

/**
 * 全排列
 *
 * @author caihao
 * @date 2020/3/3 15:29
 */
public class WholeArrangement {

  public static void main(String[] args) {
//    arrangement(new int[]{0, 1, 2, 3}, 0);
    printAllArrangement(new int[]{0, 2, 1, 3});
  }

  // 递归方式解全排列
  static void arrangement(int[] arr, int k) {
    // 当k指向最后一个元素的时候，递归终止，打印此时的排列顺序
    if (k == arr.length - 1) {
      System.out.println(Arrays.toString(arr));
    }
    for (int i = k; i < arr.length; i++) {
      // 将k与之后的元素i进行交换，然后可以认为选中了第k位
      swap(arr, i, k);
      // 第k位选择完成后，求剩余元素的全排列
      arrangement(arr, k + 1);
      // 这一步很关键，将k与i交换回来，保证是原始的顺序
      swap(arr, k, i);
    }
  }

  // 输出非递归方式的全排列方案
  static void printAllArrangement(int[] arr) {
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    while (arrangement2(arr)) {
      System.out.println(Arrays.toString(arr));
    }
  }

  // 非递归方式解全排列
  static boolean arrangement2(int[] arr) {
    int currentIndex = arr.length - 1;
    int beforeIndex = 0;
    boolean allBig = true;
    // 1.从右到左（即从个位数到十位数）找出找出第一个左邻小于右邻的数
    for (; currentIndex > 0; currentIndex--) {
      beforeIndex = currentIndex - 1;
      if (arr[beforeIndex] < arr[currentIndex]) {
        allBig = false;
        break;
      }
    }
    if (allBig) {
      return false;
    }
    // 2.再从右往左找出第一个比第一步找出的数还大的数
    int firstLargeIndex = arr.length - 1;
    for (; firstLargeIndex > beforeIndex; firstLargeIndex--) {
      if (arr[firstLargeIndex] > arr[beforeIndex]) {
        break;
      }
    }
    // 3.交换前两步找出的数
    swap(arr, beforeIndex, firstLargeIndex);
    // 4.对beforeIndex之后的数进行排序
    Arrays.sort(arr, beforeIndex + 1, arr.length);
    return true;
  }

  static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

}
