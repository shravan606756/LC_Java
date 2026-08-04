class Solution {
    public List<Integer> findMissingElements(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        int max = -1;
        int min = 101;

        for(int i=0 ; i<nums.length ; i++)
        {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);
        }    

        /*for(int i=min ; i<=max ; i++)
        {
            want.add(i);
        }

        return diff(nums, want, max, min);*/

        List<Integer> res = new ArrayList<>();

        for(int i=min ; i<=max ; i++){
            if(!set.contains(i)){
                res.add(i);
            }
        }

        return res;
    }

    /*public static List<Integer> diff(int arr[], List<Integer> want, int max, int min){
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        
        int i=0, j=0;
        while(i<arr.length && j<want.size()){
            if(arr[i]==want.get(j)){
                i++;
                j++;
            }else if(arr[i]>want.get(j)){
                res.add(want.get(j));
                j++;
            }else{
                i++;
            }
        }

        while(j<want.size()){
            res.add(want.get(j));
            j++;
        }

        return res;
    }*/
}