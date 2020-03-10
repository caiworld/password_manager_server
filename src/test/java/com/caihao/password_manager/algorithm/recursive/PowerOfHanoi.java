package com.caihao.password_manager.algorithm.recursive;

/**
 * 从左到右有A、B、C三根柱子，其中A柱子上面有从小叠到大的n个圆盘，
 * 现要求将A柱子上的圆盘移到C柱子上去，期间只有一个原则：
 * 一次只能移到一个盘子且大盘子不能在小盘子上面，求移动的步骤和移动的次数
 *
 * @author caihao
 * @date 2020/3/3 14:20
 */
public class PowerOfHanoi {

  public static void main(String[] args) {
    func(2, 'a', 'b', 'c');
    System.out.println("--------------");
    func(3, 'a', 'b', 'c');
    System.out.println("--------------");
    func(4, 'a', 'b', 'c');
  }

  // 将n个圆盘从a经由b移动到c
  static void func(int n, char a, char b, char c) {
    if (n <= 0) {
      return;
    }
    // 将上面的n-1个圆盘经由c移到b
    func(n - 1, a, c, b);
    // 此时将a底下那块最大的圆盘移到c
    move(a, c);
    // 将b上的n-1个圆盘经由a移到c
    func(n - 1, b, a, c);
  }

  static void move(char a, char c) {
    System.out.println(a + " => " + c);
  }
}
