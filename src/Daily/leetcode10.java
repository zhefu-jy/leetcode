package Daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，
 * 返回 true；否则，返回 false 。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class leetcode10 {
    public static void main(String[] args) {
        int []pushed=new int[]{1,2,3,4,5};
        int []popped=new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));

    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque=new ArrayDeque<>();
        int index=0;
        for (int i = 0; i < pushed.length; i++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && deque.peek()==popped[index]){
                deque.pop();
                index++;
            }
        }
        return deque.isEmpty();

    }
}
