class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String>obs = new HashSet<>();
        for (int[] obst : obstacles) {
            String key = obst[0] + "_" + obst[1];
            obs.add(key);
        }
        int x=0;
        int y=0;
        int maxd=0;
        int[] dir = {0,1};//north-default
        for(int i=0;i<commands.length;i++){
            //for turning left 90 degree
            if(commands[i]==-2){
                dir = new int[]{-dir[1],dir[0]};
            }
            //for turning right 90 degree
            if(commands[i]==-1){
                dir = new int[]{dir[1],-dir[0]};
            }
            else{
                for(int step=0;step<commands[i];step++){
                    int newX = x+dir[0];
                    int newY = y+dir[1];
                    
                    //checking obstacles
                    String newK = newX+"_"+newY;
                    if(obs.contains(newK)){
                        break;
                    }
                    x = newX;
                    y = newY;
                }
            }
            maxd = Math.max(maxd,x*x+y*y);
        }
        return maxd;
    }
}