package puzzles.classic;

import java.util.Stack;

public class HistogramMaxRectangle {

    public static void main(String[] args) {
        Integer heights[] = { 3,2,5,6,1,4,4 };
        Integer maxArea = heights[0];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(heights[0]);
        for (Integer i = 1; i < heights.length; i++) {
            Integer n = heights[i];
            stack.push(n);
            @SuppressWarnings("unchecked")
            Stack<Integer> clonedStack = (Stack<Integer>) stack.clone();
            int counter = 1;
            int min = n;
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (pop < min) {
                    min = pop;
                }
                int rect = min * counter;
                if (maxArea < rect) {
                    maxArea = rect;
                }
                counter++;
            }
            stack = clonedStack;
        }
        System.out.println(maxArea);


    }

}
