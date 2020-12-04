package yk.InterviewPreparationKit.CTCI_Chapter3_StacksAndQueues;

import org.junit.jupiter.api.Test;

/*
* Three in One: Describe how you could use a single array to implement three stacks.
*/
public class P01_ThreeInOne {

    class ThreeInOne {
        //it has number of stack element = 3
        //nth stack shows count of elements in that stack
        private int[] topOfStack;

        //stores all stack's data
        private int[] stackData;

        public int[] getStackData() {
            return stackData;
        }

        //we have 2 purpose for nextIndex array.
        //1: when the element set, it s going to point to the prev into the index of prev item in the stack
        //2: when the element is not set, we stores the next available index.
        private int[] nextIndex;

        //next available index
        private int nextAvailable = 0;

        public ThreeInOne(int numStacks, int capacity) {
            //topOfStack={-1,-1,-1}
            //stackData={0,0,0,0,0,0}
            //nextIndex={1,2,3,4,5,-1}

            topOfStack = new int[numStacks];
            for (int i = 0; i < numStacks; i++) {
                topOfStack[i] = -1;
            }

            stackData = new int[capacity];
            nextIndex = new int[capacity];

            for (int i = 0; i < capacity - 1; i++) {
                nextIndex[i] = i + 1;
            }

            nextIndex[capacity - 1] = -1;
        }

        public void push(int stack, int value) {
            if (stack < 0 || stack >= topOfStack.length) {
                throw new IndexOutOfBoundsException();
            }

            if (nextAvailable < 0) return;

            int currentIndex = nextAvailable;
            nextAvailable = nextIndex[currentIndex];
            stackData[currentIndex] = value; //put the value into next available index
            nextIndex[currentIndex] = topOfStack[stack]; //we set element, so we put nextIndex
            // from prev value of topOfStack
            topOfStack[stack] = currentIndex;
        }

        public int pop(int stack) {
            if (stack < 0 || stack >= topOfStack.length
                    || topOfStack[stack] < 0) {
                throw new IndexOutOfBoundsException();
            }

            int currentIndex = topOfStack[stack];
            int value = stackData[currentIndex]; //we dont need to delete the value,
            // we ll change it when we push an element.

            topOfStack[stack] = nextIndex[currentIndex];

            nextIndex[currentIndex] = nextAvailable;
            nextAvailable = currentIndex;
            return value;
        }
    }

    @Test
    public void test() {
        ThreeInOne stacks = new ThreeInOne(3,6);
        stacks.push(0,8);
        stacks.push(0,9);
        stacks.push(1,12);
        int val = stacks.pop(0);
        System.out.println("POP:" +val);

        for (int ss :
                stacks.getStackData()) {
            System.out.println(ss);
        }
    }
}


