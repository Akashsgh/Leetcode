class Solution {
    static class Pair{
        int node;
        long wt;
        Pair(int node, long wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int m=edges.length, n=online.length;
        if(m==0) return -1;
    
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] it: edges){
            if(!online[it[0]] || !online[it[1]]) continue;
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }

        int l=0, ans=-1, h=0;
        for(int[] it: edges){
            h=Math.max(h, it[2]);
        }
        while(l<=h){
            int mid=l+(h-l)/2;

            if(dijkstra(adj,mid,k)){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        return ans;
    }

    boolean dijkstra(List<List<int[]>> adj, int lim, long k){
        int n=adj.size();
        long[] dist=new long[n];
        Arrays.fill(dist,k+1);
        dist[0]=0;

        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)-> Long.compare(a.wt,b.wt));
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair temp=q.poll();
            int node=temp.node;
            long wt=temp.wt;

            if(node==n-1 && wt<=k) return true;
            if(wt>dist[node]) continue;
            
            for(int[] it: adj.get(node)){
                int curr=it[0], curr_d=it[1];
                long newd=dist[node]+curr_d;

                if(curr_d>=lim && newd<dist[curr] && newd<=k){
                    dist[curr]=newd;
                    q.add(new Pair(curr,newd));
                }
            }
        }
        return false;
    }
}