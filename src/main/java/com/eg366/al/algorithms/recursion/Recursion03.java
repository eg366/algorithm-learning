package com.eg366.al.algorithms.recursion;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 编程实现一组数据集合的全排列
 */
public class Recursion03 {

    public void method01(String[] array) {
        Queue<LinkedList<String>> result = new LinkedList<>();
        result.add(new LinkedList<>());

        result = this.doMethod01(array, 0, result);

        System.out.println(result.size());
        System.out.println(result);
    }

    private Queue<LinkedList<String>> doMethod01(String[] array, int index, Queue<LinkedList<String>> preResult) {
        // 当递归遍历至数组中最后一个元素时，结束
        if (index == (array.length)) {
            return preResult;
        }

        Queue<LinkedList<String>> result = new LinkedList<>();

        // 当前数组元素
        String curStr = array[index];
        // 遍历上一层的结果集
        while (!preResult.isEmpty()) {
            // 获取上层
            LinkedList<String> baseList = preResult.poll();
            for (int i = 0; i <= baseList.size(); i++) {
                LinkedList<String> tmpList = (LinkedList<String>) baseList.clone();
                tmpList.add(i, curStr);

                result.add(tmpList);
            }
        }

        return this.doMethod01(array, ++index, result);
    }

    public static void main(String[] args) {
        Recursion03 r = new Recursion03();

        String[] array = {"1"};
//        array = new String[]{"1", "2", "3"};
        array = new String[]{"1", "2", "3", "4"};
        r.method01(array);

    }
}
