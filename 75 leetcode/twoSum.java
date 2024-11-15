class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>(); // create hashmap
        for(int i=0;i<nums.length;i++){ // loop
            int diff = target-nums[i]; 
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i}; // here we check value contain or not
            }
            map.put(nums[i],i);        
            }
            return null;
    }
}
