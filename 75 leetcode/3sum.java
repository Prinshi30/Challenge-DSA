import java.util.*;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        // Return a custom list implementation that lazily initializes and computes results
        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int i) { init(); return res.get(i); }
            public int size() { init(); return res.size(); }
            
            // Method to initialize and compute the result list only once
            void init() {
                if (res != null) return;  // Avoid re-computation if already computed
                
                Arrays.sort(nums);  // Sort array to enable two-pointer technique
                res = new ArrayList<>();
                int n = nums.length, j = 0, k = 0, sum = 0;
                
                // Loop through each number as a potential first element of the triplet
                for (int i = 0; i < n - 2; i++) {
                    // Skip duplicates for the first element
                    if (i > 0 && nums[i] == nums[i - 1]) continue;
                    
                    // Since array is sorted, stop if nums[i] is positive
                    if (nums[i] > 0) break;
                    
                    j = i + 1;          // Initialize left pointer
                    k = n - 1;          // Initialize right pointer
                    
                    // Two-pointer approach to find pairs that sum with nums[i] to 0
                    while (j < k) {
                        sum = nums[i] + nums[j] + nums[k];
                        
                        if (sum == 0) {
                            // If a triplet is found, add it to the result
                            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            
                            // Skip duplicates for left and right pointers
                            while (j < k && nums[j] == nums[j + 1]) j++;
                            while (j < k && nums[k] == nums[k - 1]) k--;
                            
                            j++; k--;  // Move both pointers inward for new pairs
                        } else if (sum < 0) {
                            j++;      // Move left pointer right to increase sum
                        } else {
                            k--;      // Move right pointer left to decrease sum
                        }
                    }
                }
            }
        };
    }
}
