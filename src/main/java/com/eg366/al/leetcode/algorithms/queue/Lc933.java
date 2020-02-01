package com.eg366.al.leetcode.algorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算最近的请求次数
 * <p>
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 * <p>
 * 返回从 3000 毫秒前到现在的 ping 数。
 * <p>
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 * <p>
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 */
public class Lc933 {

    private Queue<Integer> queue;

    public Lc933() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Lc933 lc = new Lc933();

        System.out.println(lc.ping(1));
        System.out.println(lc.ping(100));
        System.out.println(lc.ping(3001));
        System.out.println(lc.ping(3002));
    }
}
