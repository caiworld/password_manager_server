package com.caihao.password_manager.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 无重叠区间 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 注意： 可以认为区间的终点总是大于它的起点。区间[1,2]和[2,3]的边界相互“接触”，但没有相互重叠。
 * 示例1：输入[[1,2],[2,3],[3,4],[1,3]]输出1，解释：移除[1,3]后剩下的区间没有重叠。 示例2：输入[[1,2],[1,2],[1,2]]输出2，解释：需要移除两个[1,2]来使剩下的区间没有重叠。
 * 示例3：输入[[1,2],[2,3]]输出0，因为它们已经是无重叠的区间了。
 *
 * @author caihao
 * @date 2020/3/2 21:04
 */
public class GreedyTest1 {

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
    list.add(new Interval(2, 3));
    list.add(new Interval(1, 5));
    list.add(new Interval(4, 5));
    recursiveSolution(list);
  }

  // 递归解决
  static void recursiveSolution(List<Interval> list) {
    list.sort((o1, o2) -> o1.start - o2.start);
    int remove = removeSubDuplicate2(-1, 0, list);
    System.out.println("remove:" + remove);
  }

  // 移除重复的子区间
  static Integer removeSubDuplicate2(int pre, int cur, List<Interval> list) {
    if (cur == list.size()) {
      return 0;
    }
    int notRemove = Integer.MAX_VALUE;
    if (pre == -1 || list.get(pre).end <= list.get(cur).start) {
      notRemove = removeSubDuplicate2(cur, cur + 1, list);
    }
    int remove = removeSubDuplicate2(pre, cur + 1, list) + 1;
    return Math.min(notRemove, remove);
  }

  // 区间间隔类，包括起始值和终点值
  static class Interval {

    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}
