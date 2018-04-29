package smb;

import java.util.Stack;

public class NumberSequence {

    int[] array;

    public NumberSequence(int[] array) {
        this.array = array;
    }

    public boolean isSmb1() {
        boolean firstSeq = false;
        int previous = -1;
        for (int i = 0; i < array.length; i++) {
            if (firstSeq) {
                if (i > 1 && previous < array[i]) {
                    return true;
                }
            }
            if (i > 0 && array[i] < previous) {
                firstSeq = true;
            } else {
                firstSeq = false;
            }
            previous = array[i];
        }
        return false;
    }

    public boolean isSmb2() {
        int firstSeq = -1;
        int previous = -1;
        for (int i = 0; i < array.length; i++) {
            if (firstSeq > 0) {
                int secondSeq = array[i] - previous;
                if (i > 1 && secondSeq > 0 && secondSeq > firstSeq) {
                    return true;
                }
            }
            firstSeq = previous - array[i];
            previous = array[i];
        }
        return false;
    }

    public boolean isSmb() {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (stack.empty()) {
                stack.push(array[i]);
            } else {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    continue;//do nothing
                } else {
                    int prev2 = stack.pop();
                    // check the full smb sequence
                    if (array[i] > prev && prev < prev2 && array[i] > prev2) {
                        return true;
                    }
                }
                // push back if the last two number meet the first rule
                if (array[i] < prev) {
                    stack.push(prev);
                    stack.push(array[i]);
                }
            }
        }
        return false;
    }
}
