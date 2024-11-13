class Solution {
    public int missingNumber(int[] nums) {
        // Calculate the total number of elements supposed to be in the array,
        // which is n elements (from 0 to n inclusive).
        int n = nums.length;
        
        // Use the formula for the sum of the first 'n' natural numbers:
        // (n * (n + 1)) / 2 gives us the sum from 0 to n.
        // This will be our expected total if no numbers were missing.
        int total = (n * (n + 1)) / 2;
        
        // Initialize a variable to keep track of the sum of the elements in the array.
        int sum = 0;
        
        // Iterate through the array and calculate the sum of all elements.
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        
        // The missing number is the difference between the expected sum and the actual sum.
        // Subtracting sum from total gives the missing number.
        return total - sum;
    }
}
