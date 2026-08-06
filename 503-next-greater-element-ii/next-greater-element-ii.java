class Solution 
{
    public int[] nextGreaterElements(int[] arr) 
    {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int res[] =new int[n];

        for(int i=(n-1)*2 ; i>=0 ; i--){
            int idx= i%n;
            if(idx<0) idx += n;

            while(!st.isEmpty() && st.peek()<=arr[idx]){
                st.pop();
            }

            if(st.isEmpty()){
                res[idx]=-1;
            }else{
                res[idx] = st.peek();
            }

            st.push(arr[idx]);
        }

        return res;
    }
}