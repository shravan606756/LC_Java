class Solution {
    public int minJumps(int[] arr) 
    {
        /*  3 options to move : 
                i] i+1 ; i + 1 < arr.length
                ii] i-1 ; i + 0>= arr.length
                iii] i=j ; arr[i] == arr[j] & i != j

            *** -ve elements present (hence using a boolean arr visit to track already visited elements)

            *** dupes exists hence using a hashmap for tracking index of same elements specifically for "iii" case

            *** questions asks for minimum no. of jumps , therefor using bsf to avoid uneccesary depths
                and the very first path found for end pos will be minimum
        */

        int n = arr.length , jump=0;
        if(n==1)
        {
            return 0;
        }
        Map<Integer , List<Integer>> map = new HashMap<>();

        for(int i=0 ; i<n ; i++)
        {
            map.computeIfAbsent(arr[i] , k-> new ArrayList<>()).add(i);

            //this will create key-val par as : arr[idx] -> {idx1 , idx2 , ... idxn};
        }

        boolean visit[] = new boolean[n]; //all false by default

        //BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0]=true;

        while(!q.isEmpty())
        {   
            int size = q.size();
            while(size>0)
            {
                int curr = q.poll();
                if(curr==n-1)
                {
                    return jump;
                }

                //case 1
                if(curr+1 < n && visit[curr+1]==false)
                {
                    q.offer(curr+1);
                    visit[curr+1]=true;
                }

                //case 2
                if(curr-1 >=0 && visit[curr-1]==false)
                {
                    q.offer(curr-1);
                    visit[curr-1]=true;
                }

                //case 3
                if(map.containsKey(arr[curr]))
                {
                    for(int x : map.get(arr[curr]))
                    {
                        if(!visit[x])
                        {
                            q.offer(x);
                            visit[x]=true;
                        }
                    }
                    map.remove(arr[curr]);
                }
                size--;
            }
            jump++;
        }

        return jump;
    }
}