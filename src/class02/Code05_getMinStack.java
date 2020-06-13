package class02;

import java.util.Stack;

public class Code05_getMinStack {
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public void push(int value) {
            if (this.stackMin.empty()) {
                stackMin.push(value);
            } else {
                stackMin.push(value <= this.getMin() ? value : this.getMin());
            }
            stackData.push(value);
        }

        public int pop() {
            if (this.stackData.empty())
                throw new RuntimeException("stack is empty");
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackMin.empty())
                throw new RuntimeException("stack is empty");
            return this.stackMin.peek();
        }
    }
}
