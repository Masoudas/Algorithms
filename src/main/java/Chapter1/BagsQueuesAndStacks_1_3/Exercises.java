package Chapter1.BagsQueuesAndStacks_1_3;

import java.util.Stack;

class Three{
    /**
     * a is Ok.
     * b is not Ok. Because we need to have put 6 before 4.
     * c is ok, need to put five before 2.
     * d is ok.
     * e is ok if we put 0 1 2 3 4 5 then pop till 1, then put 6 7 8 9 then pop again.
     * f is not ok, because after poping 8, we need to pop 7.
     * g is not ok. After poping 3, we need to pop 2.
     * h is ok. we put 0, from then every two that we put, we pop two numbers.
     */
}

class Four{
    public static boolean isBalanced(String str){
        if (str == null || str.length() == 0){
            return true;
        }

        Stack<Character> stck = new Stack<>();
        boolean isNotBalanced = false;
        for (int i = 0; i < str.length() && !isNotBalanced; i++) {
            char c = str.charAt(i);

            if (c == '{' || c == '(' || c == '[') stck.push(c);
            else if (stck.isEmpty()){
                isNotBalanced = true;
            }
            else {
                char last = stck.pop();
                if (last == '{' && c != '}'){
                    isNotBalanced = true;
                }
                if (last == '(' && c != ')'){
                    isNotBalanced = true;
                }
                if (last == '[' && c != ']'){
                    isNotBalanced = true;
                }
            }
        }

        return !isNotBalanced && stck.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[]}"));
    }
}

class Five{
    /**
     * What does the code fragment do?
     * We see that at each iteration, we calculate the remainder to two. Then we devive by two.
     * Hence, we are calculating the bit presentation.
     */
    public static void method() {
        int N = 0;
        Stack<Integer> stack = new Stack<Integer>(); 
        while (N > 0) {   
            stack.push(N % 2);   N = N / 2; 
        } 
        for (int d : stack) System.out.print(d);
    }
    
}

class Six{
    /**
     * The first while deques (the item that came first), and puts it in a stack. Hence, it changes the order
     * in the sense that it now becomes a LIFO. So the last in the queue is now the first in stack.
     * 
     * So now, the last in queue is being put first in the queue. So the order of the queue has changed.
     * Conclusion, if we want to change the order of a queue, we should pas it through a stack!
     * 
     * However, passing a stack through a stack in and of itself changes the order of the stack.
     */
}

class Seven{
    /** We can keep a refernece to the last item, or just return it. */
}

class Eight{
    /** we know that if x elements are in the stack, the size is x*4 */
}


class Nine {
    /**
     * There's an implicit assumption here, and that is that a paranthesis is used when there are
     * only two expressions, something like (()*()). Hence for example something like (() * () * ())
     * is not accepted with this problem. 
     * 
     * If we look at it this way, now we see that the problem is solvable! in the sense that when we reach
     * a right paranthesis, we have an expression to calculate. Hence that expression together with its operator
     * form a ().
     * 
     * To extend it to the three paranthesis case, we just need to write a for loop it seems.
     */
	private static String getInfixExpression(String input) {
		
		Stack<String> operands = new Stack<>();
		Stack<String> operators = new Stack<>();
		
		String[] inputValues = input.split("\\s"); // Break on \s, or white space
		
		for (String value : inputValues) {
		    if (value.equals("+") 
					|| value.equals("-") 
					|| value.equals("*") 
					|| value.equals("/")) {
				operators.push(value);
			} else if (value.equals(")")) {
				String operator = operators.pop();
				String value2 = operands.pop();
				String value1 = operands.pop();
				
				String subExpression = "( " + value1 + " " + operator + " " + value2 + " )";
				operands.push(subExpression);
			} else {
				operands.push(value);
			}
		}
		
		return operands.pop();
	}

}

class Ten{
    /**
     * Infix expression: The normal form of expression we see, such as 1 + 2 * 3.
     * 
     * Prefix: All operations come before the operand. Hence, A + B would be +AB. A + B * C would be +A*BC. The latter
     * happens because A + *BC, and then +A*BC. It kind of shoots the highest priority operation to right.
     * Another example is A + B*C*D + E would be +E+A+**BDC I guess.
     * 
     * Postfix: All operations come after the operand. For example, A + B would be AB+. A + B * C would be ABC*+ (postfix).
     * 
     */

     public static String infixToPostFix(String exp){
        if (exp.length() == 0 || exp == null) {
            return null;
        }

        String[] inputValues = exp.split("\\s"); // Break on \s, or white space

        Stack<String> opr = new Stack<>();
        Stack<String> ops = new Stack<>();
        for (String string : inputValues) {
            if (string.equals("*") || string.equals("+"))  ops.push(string);
            else if (string.equals("("));
            else if (string.equals(")")){
                String temp = opr.pop() + opr.pop() + ops.pop();
                opr.push(temp);
            }else{
                opr.push(string);
            }
        }

        return opr.pop();
     }

     public static void main(String[] args) {
         System.out.println(infixToPostFix("( ( 1 + 2 ) * ( 3 + 4 ) )"));
     }
}

class Eleven{
    /**
     * This is straight forward I guess. We just keep the oprands and when ever we see the an operation,
     * we do it.
     */
    public static int EvaluatePostFix(String exp) {
        if (exp.length() == 0 || exp == null) {
            throw new ArithmeticException();
        }

        String[] inputValues = exp.split("\\s"); // Break on \s, or white space

        Stack<Integer> opr = new Stack<>();
        for (String string : inputValues) {
            if (string.equals("*")){
                opr.push(opr.pop() * opr.pop());
            }
            else if (string.equals("+")) {
                opr.push(opr.pop() + opr.pop());
                
            }else{
                opr.push(Integer.parseInt(string));
            }
        }

        return opr.pop();
    }
}
