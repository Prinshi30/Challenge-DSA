class Solution {
    public int maxProduct(int[] nums) {
        // Check if the input array is empty
        if(nums.length == 0){
            return 0;
        }
        // Initialize min and max values with the first element
        int min = nums[0]; // 'min' the minimum product (to account for negative numbers)
        int max = nums[0]; // 'max'  the maximum product 
        int result = max;  // 'result' stores the maximum product found throughout the array traversal

        for(int i = 1; i < nums.length; i++){
            int curr = nums[i]; // Current number in the array

            // Calculate the temporary maximum product at the current position
            // This includes the current element itself, the max product so far * curr, and min product so far * curr
            // Using 'temp' here to avoid overwriting 'max' before updating 'min'
            int temp = Math.max(curr, Math.max(max * curr, min * curr));
            
            // Update 'min' to be the smallest product at the current position
            min = Math.min(curr, Math.min(min * curr, max * curr));
            
            // Update 'max' with the temporary value calculated above
            max = temp;

            // Update 'result' with the highest maximum product encountered so far
            result = Math.max(result, max);
        }
        return result;
    }
}
