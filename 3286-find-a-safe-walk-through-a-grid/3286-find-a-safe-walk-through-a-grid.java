class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int safeHealth = health - grid.get(0).get(0);
        if(safeHealth<1)
        return false;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->q[0]-p[0]);
        int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
        int[][] safeness = new int[n][m];
        for(int[] i:safeness)
        {
            Arrays.fill(i,-1);
        }
        pq.offer(new int[]{safeHealth,0,0});
        while(!pq.isEmpty())
        {
            int[] cur = pq.poll();
            int safe = cur[0];
            int x = cur[1];
            int y = cur[2];
            if(x==n-1 && y==m-1)
            {
                if(safe>=1)
                return true;
            }
            for(int[] d:dir)
            {
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m)
                {
                    int newSafe = safe-grid.get(nx).get(ny);
                    if(newSafe>0 && newSafe>safeness[nx][ny])
                    {
                        safeness[nx][ny] = newSafe;
                        pq.offer(new int[]{newSafe,nx,ny});
                    }              
                }
            }
        }
        return false;
    }
}