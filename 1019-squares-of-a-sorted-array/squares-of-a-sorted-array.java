class Solution {
    public int[] sortedSquares(int[] arr) 
    {
        int n = arr.length;
        int idx=0;

        List<Integer> pos = new ArrayList<>();        
        List<Integer> neg = new ArrayList<>();

        int res[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            if (arr[i] >= 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }

        if(pos.size()==0){
            for(int i=0;i<neg.size();i++)
                res[i]=neg.get(i)*neg.get(i);
            return rev(res);
        }

        if(neg.size()==0)
        {
            for(int i=0;i<pos.size();i++)
                res[i]=pos.get(i)*pos.get(i);
            return res;
        }

        int l=0 , r=neg.size()-1;
        while(l<pos.size() && r>=0)
        {
            int a = pos.get(l)*pos.get(l);
            int b = neg.get(r)*neg.get(r);

            if(a>b)
            {
                res[idx++] = b;
                r--;
            }

            else if(a<b)
            {
                res[idx++] = a;
                l++;
            }

            else{
                res[idx++] = a;
                res[idx++] = b;
                l++;
                r--;
            }
        }

        while(l<pos.size())
        {
            res[idx++] = pos.get(l)*pos.get(l);
            l++;
        }
        while(r>=0)
        {
            res[idx++] = neg.get(r)*neg.get(r);
            r--;
        }

        return res;
    }

    public int [] rev(int arr[])
    {
        int n = arr.length;
        for(int i=0 ; i<n/2 ; i++)
        {
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }

        return arr;
    }
}