class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            // Check if the mid element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target is in the left sorted half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;  // Search in the left half
                } else {
                    left = mid + 1;   // Search in the right half
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // Check if target is in the right sorted half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;   // Search in the right half
                } else {
                    right = mid - 1;  // Search in the left half
                }
            }
        }
        // Target not found
        return -1;
    }
}
