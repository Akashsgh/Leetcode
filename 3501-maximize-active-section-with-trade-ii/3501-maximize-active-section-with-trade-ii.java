import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int tot = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') tot++;
        }
        
        List<int[]> b = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int st = i;
                while (i < n && s.charAt(i) == '0') i++;
                b.add(new int[]{st, i - 1});
            } else {
                i++;
            }
        }
        
        int m = b.size();
        ST st = null;
        
        if (m > 1) {
            int[] g = new int[m - 1];
            for (int j = 0; j < m - 1; j++) {
                int l1 = b.get(j)[1] - b.get(j)[0] + 1;
                int l2 = b.get(j + 1)[1] - b.get(j + 1)[0] + 1;
                g[j] = l1 + l2;
            }
            st = new ST(g);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            if (m == 0) {
                ans.add(tot);
                continue;
            }
            
            int a = -1;
            int lo = 0, hi = m - 1;
            while (lo <= hi) {
                int md = lo + (hi - lo) / 2;
                if (b.get(md)[1] >= l) {
                    a = md;
                    hi = md - 1;
                } else {
                    lo = md + 1;
                }
            }
            
            int c = -1;
            lo = 0; hi = m - 1;
            while (lo <= hi) {
                int md = lo + (hi - lo) / 2;
                if (b.get(md)[0] <= r) {
                    c = md;
                    lo = md + 1;
                } else {
                    hi = md - 1;
                }
            }
            
            if (a == -1 || c == -1 || a >= c) {
                ans.add(tot);
            } else {
                int mx = 0;
                
                if (a + 1 == c) {
                    int lLen = b.get(a)[1] - Math.max(l, b.get(a)[0]) + 1;
                    int rLen = Math.min(r, b.get(c)[1]) - b.get(c)[0] + 1;
                    mx = lLen + rLen;
                } else {
                    int fg = (b.get(a)[1] - Math.max(l, b.get(a)[0]) + 1) + 
                             (b.get(a + 1)[1] - b.get(a + 1)[0] + 1);
                    
                    int lg = (b.get(c - 1)[1] - b.get(c - 1)[0] + 1) + 
                             (Math.min(r, b.get(c)[1]) - b.get(c)[0] + 1);
                    
                    mx = Math.max(fg, lg);
                    
                    if (a + 1 <= c - 2) {
                        int mg = st.query(a + 1, c - 2);
                        mx = Math.max(mx, mg);
                    }
                }
                ans.add(tot + mx);
            }
        }
        return ans;
    }
    
    class ST {
        int[] t;
        int sz;
        
        ST(int[] a) {
            sz = a.length;
            t = new int[4 * sz];
            if (sz > 0) {
                build(a, 0, 0, sz - 1);
            }
        }
        
        void build(int[] a, int nd, int s, int e) {
            if (s == e) {
                t[nd] = a[s];
            } else {
                int md = s + (e - s) / 2;
                build(a, 2 * nd + 1, s, md);
                build(a, 2 * nd + 2, md + 1, e);
                t[nd] = Math.max(t[2 * nd + 1], t[2 * nd + 2]);
            }
        }
        
        int query(int l, int r) {
            if (sz == 0 || l > r) return 0;
            return query(0, 0, sz - 1, l, r);
        }
        
        int query(int nd, int s, int e, int l, int r) {
            if (r < s || e < l) return 0;
            if (l <= s && e <= r) return t[nd];
            int md = s + (e - s) / 2;
            int p1 = query(2 * nd + 1, s, md, l, r);
            int p2 = query(2 * nd + 2, md + 1, e, l, r);
            return Math.max(p1, p2);
        }
    }
}