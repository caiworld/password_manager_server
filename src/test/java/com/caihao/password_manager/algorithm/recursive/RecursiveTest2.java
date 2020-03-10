package com.caihao.password_manager.algorithm.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归算法
 * 一只青蛙可以一次跳 1 级台阶或一次跳 2 级台阶,例如:
 * 跳上第 1 级台阶只有一种跳法：直接跳 1 级即可。跳上第 2 级台阶
 * 有两种跳法：每次跳 1 级，跳两次；或者一次跳 2 级。
 * 问要跳上第 n 级台阶有多少种跳法？
 *
 * @author caihao
 * @date 2020/3/2 22:13
 */
public class RecursiveTest2 {

  public static void main(String[] args) {
    System.out.println(func(3));
    map.clear();
    System.out.println(func(4));
    map.clear();
    System.out.println(func(5));
    map.clear();
    System.out.println(func(6));
    System.out.println(map);
  }

  static Map<Integer, Integer> map = new HashMap<>();

  static int func(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    if (map.get(n) != null) {
      return map.get(n);
    }
    int result = func(n - 1) + func(n - 2);
    map.put(n, result);
    return result;
  }
}
