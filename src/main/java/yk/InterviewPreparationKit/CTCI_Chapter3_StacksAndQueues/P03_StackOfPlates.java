package yk.InterviewPreparationKit.CTCI_Chapter3_StacksAndQueues;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop ( )
 * should return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP
 * Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 */
public class P03_StackOfPlates {
//    Are we okay with some stacks not being at full capacity.
//    This would improve the time complexity.
//    LeftShift?
    class SetOfStacks {
        ArrayList<Stack> stacks;
        public int capacity;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
            stacks = new ArrayList<>();
        }

        public void push(int item) {
            Stack<Integer> stack = getCurrentStack();
            stack.push(item);
        }

        public int pop() {
            return popOnStack(getLastStack());
        }

        private int popOnStack(Stack<Integer> stack) {
            int item = stack.pop();
            if (stack.isEmpty()) {
                stacks.remove(stack);
            }
            return item;
        }

        public Stack getLastStack() {
            if (stacks.size() == 0) return null;

            return stacks.get(stacks.size() - 1);
        }

        public boolean isEmpty() {
            Stack last = getLastStack();
            return last == null || last.isEmpty();
        }

        public int popAt(int index) {
            if (index > stacks.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Stack stack = stacks.get(index);
            return popOnStack(stack);
        }

        private Stack<Integer> getCurrentStack() {
            if (stacks.isEmpty() || isFullCapacity(getLastStack())) {
                stacks.add(new Stack<>());
            }
            return stacks.get(stacks.size() - 1);
        }

        private boolean isFullCapacity(Stack<Integer> stack) {
            return stack.size() == capacity;
        }
    }

    @Test
    public void testPushPop() {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        int item = setOfStacks.pop();
        assertEquals(3, item);

        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);

        item = setOfStacks.pop();
        assertEquals(6, item);
    }

    @Test
    public void testPopAt() {
        SetOfStacks setOfStacks = new SetOfStacks(2);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);

        int item = setOfStacks.popAt(0);
        System.out.println(item);
        assertEquals(2, item);

        item = setOfStacks.popAt(1);
        System.out.println(item);
        assertEquals(3, item);

        item = setOfStacks.popAt(0);
        System.out.println(item);
        assertEquals(1, item);

    }
}
