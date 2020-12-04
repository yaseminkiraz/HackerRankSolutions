package yk.InterviewPreparationKit.CTCI_Chapter3_StacksAndQueues;

//Stack Min: How would you design a stack which, in addition to push and pop, has a function min
//        which returns the minimum element? Push, pop and min should all operate in 0(1) time.

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P02_StackMin {
    class StackWithMin extends Stack<Integer>{
        Stack<Integer> minStack;

        public StackWithMin() {
            this.minStack = new Stack<>();
        }

        public void push(int value){

            if (value <= currentMin()) {
                minStack.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == currentMin()) {
                minStack.pop();
            }
            return value;
        }

        public Integer min() {
            return minStack.peek();
        }

        private int currentMin() {
            return minStack.isEmpty() ? Integer.MAX_VALUE : min();
        }
    }

    @Test
    public void test() {
        StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        assertEquals(1, (long) stack.min());
        stack.pop();
        assertEquals(2, (long) stack.min());
    }
}
