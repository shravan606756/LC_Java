class Solution {
    public long minSumSquareDiff(int[] num1, int[] num2, int k1, int k2) {
        int diffArr[] = new int[num1.length];
        int maxDiff = 0;

        for(int i=0 ; i<num1.length ; i++)
        {
            diffArr[i] = Math.abs(num1[i]-num2[i]);
            maxDiff = Math.max(maxDiff, diffArr[i]);
        }
        int countDiff[] = new int[maxDiff+1];

        for(int d : diffArr)
        {
            countDiff[d]++;
        }

        long k = (long) k1+k2;
        long res=0;

        for(int currDiff=maxDiff ; currDiff>0 && k>0 ; currDiff--)
        {
            if (countDiff[currDiff] == 0){
                continue;
            }

            int maxOp = (int) Math.min(k, countDiff[currDiff]);
            countDiff[currDiff] -= maxOp;
            countDiff[currDiff-1] += maxOp;
            k -= maxOp;
        }

        for(long i=0 ; i<=maxDiff ; i++)
        {
            res += (long)(i*i*countDiff[(int)i]); 
        }

        /*Queue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);

        for(int i=0 ; i<diffArr.length ; i++)
        {
            heap.offer(diffArr[i]);
        }

        while(k>0 && heap.peek()>0){
            int temp = heap.poll();
            heap.offer(temp-1);
            k--;
        }

        long res=0;

        while(!heap.isEmpty()){
            int temp = heap.poll();
            res += (long) temp*temp;
        }*/

        return res;
    }
}