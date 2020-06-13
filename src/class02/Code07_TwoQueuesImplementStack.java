package class02;

import java.util.LinkedList;
import java.util.Queue;

public class Code07_TwoQueuesImplementStack {
    public static class TwoQueuesStack {
        public Queue<Integer> queue;
        public Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int value) {
            queue.offer(value);
        }

        public int poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            int res = queue.poll();
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return res;
        }

        public int peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            int res = queue.poll();
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            help.offer(res);
            return res;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}
