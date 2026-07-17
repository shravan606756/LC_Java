class Solution {
    public int bs(long arr[],long x) {
        int s = 1;
        int e = arr.length-1;
        int ans = arr.length-1;
        while(s<=e) {
            int mid = (s+e)/2;
            if(arr[mid]>=x) {
                e = mid-1;
                ans = mid;
            } else {
               s = mid+1;
            } 
        }
        return ans;
    }
    public int[] gcdValues(int[] nums, long[] queries) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(nums[i],max);
        }
        long b[] = new long[max+1];
        for(int i=max; i>=1; i--) {
            int curr = i;
            long count = 0;
            while(curr<=max) {
                count = count + map.getOrDefault(curr,0);   
                curr = curr + i;
            }
            if(count>0) {
                b[i] = ((long)(count)*(count-1))/2;
            }
        }
        for(int i=max; i>=1; i--) {
            for(int j = i*2; j<=max; j=j+i) {
                b[i] = b[i]-b[j];
            }
        }
        long total = 0;
        for(int i=0; i<b.length; i++) {
            total = total + b[i];
            b[i] = total;
            System.out.print(b[i]+" ");
        }
        int ans[] = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            ans[i] = bs(b,queries[i]+1);
            // if(b[ans[i]]!=queries[i]+1) {
            //     ans[i]--;
            // }
        }
        return ans;
    }
}