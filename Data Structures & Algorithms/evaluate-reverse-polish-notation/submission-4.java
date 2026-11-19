class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length < 1) {
            return 0;
        }
        Integer a = null;
        Integer b = null;
        Stack<Integer> stack = new Stack<>();

        boolean reverse = false;
        for(String ch : tokens) {
            if(isOperand(ch)) {
                
                b = stack.pop();
                a = stack.pop();
                stack.push(evaluate(a, b, ch));
               //System.out.println("Sum is "+ stack.peek());
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.peek();
    }

    public boolean isOperand(String ch) {
        switch(ch) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    public int evaluate(int a, int b, String operand) {
        switch(operand) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
