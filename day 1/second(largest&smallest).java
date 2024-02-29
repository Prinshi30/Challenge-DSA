import java.util.Arrays;

public class Solution {
    public static int[] getSecondOrderElements(int n, int[] a) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : a) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }

            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        return new int[]{secondLargest, secondSmallest};
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {4, 5, 3, 6, 7};
        int[] result = getSecondOrderElements(n, arr);
        System.out.println(Arrays.toString(result));  // Output: [6, 4]
    }
}
