class Solution {
    public int maxProduct(int n) {
        List<Integer> a= new ArrayList<>();
        while (n!=0){
            a.add(n%10);
            n=n/10;
        }
        Collections.sort(a);
        
        
        return a.get(a.size()-1)*a.get(a.size()-2);
        
    }
}