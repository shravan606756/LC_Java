class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];

        int low=0, high=nums.length-1;

        /*while(low<high){
            int sum = nums[low]+nums[high];

            if(sum==target){
                res[0]=low;
                res[1]=high;
                low++;
                high--;
            }
            else if(sum>target){
                high--;
            }else{
                low++;
            }
        }

        return res;*/

        for(int i=0 ; i<nums.length; i++)
        {
            for(int j=i+1 ; j<nums.length ; j++)
            {
                int sum=nums[i]+nums[j];

                if(sum==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }

        return res;
    }
}