package smb;

import java.util.Stack;

public class NumberSequence {

    int[] array;

    public NumberSequence(int[] array) {
        this.array = array;
    }

    public boolean isSmb() {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
            int current = array[arrayIndex];

            // only one element
            if (stack.empty()) {
                stack.push(current);
                max = current;
                continue;
            } else {
                // only two elements OR there the trend is still up OR FOUND - keep pushing to the stack
                if (arrayIndex < 2  || current >= max || (current > max && current < min)) {
                    stack.push(current);
                } else {
                    // if trend changed - find where
                    Stack<Integer> tempStack = new Stack<>();
                    int ind = 0;
                    while (!stack.isEmpty()) {
                        int old = stack.pop();
                        if (old < current) {
                            System.out.println(current + " is between " + old + " and " + max);
                            return true;
                        }
                        tempStack.push(array[ind]);
                        ind++;
                    }
                    // put them back
                    tempStack.push(current);
                    stack = tempStack;
                }
                max = Math.max(max, current);
                min = Math.min(min, current);
            }
        }

        System.out.println("sequence not valid");
        return false;
    }
}
