import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String s : operations) {

            if (s.equals("D")) {
                st.push(2 * st.peek());
            }
            else if (s.equals("+")) {
                int top = st.pop();
                int secondTop = st.peek();
                int sum = top + secondTop;
                st.push(top);
                st.push(sum);
            }
            else if (s.equals("C")) {
                st.pop();
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;

        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}