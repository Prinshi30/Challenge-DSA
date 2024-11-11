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

//

/* 
Sort the Array:
Sort the array in non-decreasing order to simplify the search process and allow for an efficient two-pointer method.
Loop Through Each Element:

Loop through the array up to the third-last element. For each element at index i, treat it as the first element of a potential triplet.
Set a Target Sum:

For each nums[i], calculate a target sum as -nums[i]. We want to find two other elements that add up to this target to achieve a sum of zero with nums[i].
Initialize Two Pointers:

Set up two pointers: one (j) just after i and the other (k) at the end of the array. These pointers help us find pairs that meet the target sum.
Search for Pair with Target Sum:

While the left pointer j is less than the right pointer k:
If nums[j] + nums[k] == target, add the triplet {nums[i], nums[j], nums[k]} to the results.
Move both pointers inward to explore other pairs.
If nums[j] + nums[k] < target, increment j to increase the sum.
If nums[j] + nums[k] > target, decrement k to decrease the sum.
Skip Duplicates:

Skip duplicates for nums[i] to avoid repeating the same triplet.
Similarly, after finding a valid pair, skip over consecutive duplicates of nums[j] and nums[k] to ensure unique pairs.
Repeat Until All Triplets are Found:

Continue this process for each element until you’ve checked all possible unique triplets that sum to zero. */
