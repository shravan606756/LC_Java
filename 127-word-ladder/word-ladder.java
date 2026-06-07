class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> set = new HashSet<>();

        for(String s : wordList)
        {
            set.add(s);
        }    

        if(!set.contains(endWord))
        {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            Pair temp = q.peek();
            q.poll();

            String s = temp.word;
            int l = temp.level;

            if(s.equals(endWord)) return l;

            char [] ch = s.toCharArray();

            for(int i=0 ; i<ch.length ; i++)
            {
                char old = ch[i];

                for(char j='a' ; j <='z' ; j++)
                {
                    if(j==old)
                    {
                        continue;
                    }
                    
                    ch[i]=j;

                    String now = new String(ch);

                    if(set.contains(now))
                    {
                        q.offer(new Pair(now,l+1));
                        set.remove(now);
                    }
                }

                ch[i] = old;
            }
        }

        return 0;
    }

    static class Pair{
        String word;
        int level;

        Pair(String word, int level)
        {
            this.word=word;
            this.level=level;
        }
    }
}