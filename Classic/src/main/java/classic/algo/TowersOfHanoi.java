package classic.algo;

import java.util.Stack;

public class TowersOfHanoi {

    public static void main(String[] args) {
        Tower a = new Tower("A");
        Tower b = new Tower("B");
        Tower c = new Tower("C");
        int n = 10;
        for (int i = 0; i < n && a.push(n - i); ++i)
            ;
        hanoi(a, b, c, a.size());
    }

    private static void hanoi(Tower a, Tower b, Tower c, int n) {
        printTowers(a, b, c);
        if (n == 1) {
            b.push(a.pop());
            return;
        }
        if (n == 0) return;
        hanoi(a, c, b, n - 1);
        b.push(a.pop());
        hanoi(c, b, a, n - 1);
        printTowers(a, b, c);
    }

    private static void printTowers(Tower a, Tower b, Tower c) {
        System.out.println("Tower " + a.getName() + ": -> " + a);
        System.out.println("Tower " + b.getName() + ": -> " + b);
        System.out.println("Tower " + c.getName() + ": -> " + c);
        System.out.println();
    }

}

class Tower {
    private Stack<Integer> stack = new Stack<Integer>();

    private String name;

    public Tower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer pop() {
        return stack.pop();
    }

    public boolean push(Integer element) {
        if (!stack.empty() && element > stack.peek()) {
            System.out.println(element +" is greater than " + stack.peek());
            return false;
        }
        else {
            stack.push(element);
            return true;
        }
    }

    public Integer peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}