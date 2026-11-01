class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack();

        for(String t: tokens){

            if(t.equals("+") || t.equals("-") || t.equals("/") || t.equals("*")){

                int b = stack.pop();
                int a = stack.pop();
                int sum=0;

                if(t.equals("+")) sum=a+b;
                else if(t.equals("-")) sum = a-b;
                else if(t.equals("*")) sum = a*b;
                else sum = a/b;

                stack.push(sum);

            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }
}
