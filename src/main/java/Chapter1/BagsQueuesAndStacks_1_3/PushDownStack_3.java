/**
 * A push down stack (or simply a stack) is a data structure where the last element set in is
 * returned first. The tabs on an internet browser is an stack. Another example is the email stack.
 * 
 * As another example, consider the expression ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ). How does Java 
 * calculate this expression? Suppose all values are between 0 to 9 and we don't have compound
 * expressions like 1 + 2 * 3.
 * 
 * The answer is, we define two stacks, one for operands and one for operator. We move through
 * the expression. If we encounter left paranthesis, we just ignore it. For right ones, we pop
 * the last value put and we calculate the result.
 */
class ExpressionCalculation{
    public static void calculate(){
        Stack<String> ops;
    }

}

/**
 * Here's another riddle. How does one calculate a compound expression, like 1 + 2 * 3.
 */