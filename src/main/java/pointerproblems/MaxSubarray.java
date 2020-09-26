package pointerproblems;

import lombok.val;

public class MaxSubarray {

    public static void main(String[] args) {
        val test1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        assert maxSubarray(test1) == 6;

        val test2 = new int[] {-2,-3,4,-1,-2,1,5,-3};
        assert maxSubarray(test2) == 7;

        val test3 = new int[] {-3,1,-8,4,-1,2,1,-5,5};
        assert maxSubarray(test3) == 6;
    }

    public static int maxSubarray(final int[] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];

        int left = 0;
        int right = left;
        int max = array[left];
        int rollingSum = array[left];

        while(right < array.length - 1) {
            rollingSum += array[++right];
            if(rollingSum > 0) {
                if(rollingSum > max) {
                    max = rollingSum;
                }
            } else {
                rollingSum -= array[left++];
                if(rollingSum > 0) {
                    if(rollingSum > max) {
                        max = rollingSum;
                    }
                }
            }
        }
        return max;
    }
}
