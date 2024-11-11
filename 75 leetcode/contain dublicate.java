class Solution {
    public boolean containsDuplicate(int[] nums) {
       Set<Integer> visited =new HashSet<>(); // create hashSet
       for(int i=0;i<nums.length;i++){
            if(visited.contains(nums[i])) { // check exist or not 
                return true;
            }else{
                visited.add(nums[i]); // add is not exist
            }
       }

        return false; // if not found still false
    }
}
