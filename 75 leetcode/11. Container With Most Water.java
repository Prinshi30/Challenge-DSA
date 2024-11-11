class Solution {
    public int maxArea(int[] height) {
        int max = 0;  // Variable to store the maximum area found
        int left = 0;  // Left pointer starting at the beginning of the array
        int right = height.length - 1;  // Right pointer starting at the end of the array

        // Continue until the two pointers meet
        while (left < right) {
            int width = right - left;  // Calculate the width between the two pointers
            // Calculate the area with the shorter of the two heights
            int area = Math.min(height[left], height[right]) * width;

            // Update max if the new area is greater than the current max
            max = Math.max(max, area);

            // Move the pointer pointing to the shorter line inward
            if (height[left] <= height[right]) {
                left++;  // Move the left pointer rightward
            } else {
                right--;  // Move the right pointer leftward
            }
        }
        return max;  // Return the maximum area found
    }
}
