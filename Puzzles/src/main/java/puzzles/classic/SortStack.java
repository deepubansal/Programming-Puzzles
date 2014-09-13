package puzzles.classic;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        stack.push(7);
        stack.push(3);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(8);
        stack.push(12);
        stack.push(6);
        Stack<Integer> sortedStack = new Stack<Integer>();
        int count = 0;
        while(!stack.isEmpty()) {
            Integer item = stack.pop();
            boolean isCounted = false;
            while (!sortedStack.isEmpty() && sortedStack.peek() > item) {
                count ++;
                isCounted = true;
                stack.push(sortedStack.pop());
            }
            if (!isCounted) count++;
            sortedStack.push(item);
        }
        System.out.println(sortedStack);
        System.out.println(count);
    }

}
