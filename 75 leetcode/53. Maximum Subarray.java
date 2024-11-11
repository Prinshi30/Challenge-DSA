class Solution {
    public int maxSubArray(int[] nums) {
        int curr=0; // current sum
        int max= nums[0]; // max is first element of array
        for(int i=0;i<nums.length;i++){ //loop
            if(curr<0){ // check sum is 0 or not
                curr=0;  // if not 0 make it 0
            }
            curr += nums[i]; // current sum + upcoing element
            max = Math.max(curr,max); // maximum of max n current sum
        }
        return max; // ans
    }
}
