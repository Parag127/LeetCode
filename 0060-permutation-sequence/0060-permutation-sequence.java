class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            list.add(i);
            fact *= i;
        }       

        list.add(n);
        k--;
        StringBuilder str = new StringBuilder();
    
        while (true) {
            str.append(String.valueOf(list.get(k / fact)));
            list.remove(k / fact);

            if (list.size() == 0) {
                break;
            }

            k = k % fact;
            fact /= list.size();
        }
        
        return str.toString();
    }
}