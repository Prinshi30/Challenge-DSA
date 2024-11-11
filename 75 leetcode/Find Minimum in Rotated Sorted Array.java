class Solution {
    public int findMin(int[] nums) {
        int left = 0;                      // Start pointer
        int right = nums.length - 1;       // End pointer
        int ans = nums[0];                 // Initialize answer with the first element

        // If there's only one element, return it as the minimum
        if (nums.length == 1) {
            return nums[0];
        }
        
        while (left <= right) {
            // If the subarray is already sorted, the minimum is at 'left'
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;                      // No need to search further
            }

            int mid = (left + right) / 2;   // Find the midpoint
            ans = Math.min(ans, nums[mid]); // Update the minimum

            // If the left part is sorted, move to the right part
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {                        // Else, move to the left part
                right = mid - 1;
            }
        }
        return ans;                        
    }
}
