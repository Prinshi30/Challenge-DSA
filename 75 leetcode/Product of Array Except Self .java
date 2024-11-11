class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; // create array
        Arrays.fill(result,1); // set default as 1
        int pre = 1, post= 1; // post & pre for process
        for(int i =0;i<nums.length;i++){  // pre (forward 1 to 4)
            result[i] = pre;
            pre = nums[i]*pre;
        }
        for(int i=nums.length-1;i>=0;i--){ //post (bacward 4 to 1)
            result[i] *= post;
            post = post*nums[i];
        }
        return result; // ans 
    }
}
