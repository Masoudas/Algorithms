package Chapter1.BagsQueuesAndStacks_1_3;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

class Twelve{
    /**
     * This one is easy. The question is, do we want a shallow or deep copy of the strings.
     * If we wanted a deep copy. As we know (yeah you knew :D), just assigning a string to a 
     * new variable makes a copy of it, because Strings are immutable. It's not that we actually
     * create a new copy in memory, but that if we change either of the strings, the other reference
     * is not affected, obviously!
     * 
     * In fact, any class that is immutable can be copied this way! Becuase you know, they can't be changed.
     */
    public void name() {
        String str = "a";
        String str1 = str;

        str = "b";  // Obviously str1 is not affected, because we're creating a new string reference here!

        
    }
}

class Thirteen{
    /**
     * b,c and could not occur. It's very interesting how queue keeps things in order, as opposed to stack.
     * It actually does tell you that how weird a society becomes if you don't respect the queue!
     */
}

class Fourteen{
    String[] str = new String[2];
    int N = 0;
    int first = 0;

    public void resizeArray(int size) {
        String[] d_arr = new String[size];

        IntStream.range(first, N).foreach(i-> d_arr[i - first] = str[i]);
        
        str = d_arr;
    }

}

class Fifteen{
    /**
     * This one was weird. Just a question: How do we get k string from the command line?
     * Maybe System.in repeats fifteen times in a loop, everytime terminates on a \n or enter?
     * 
     * By the way, I think this better be done with a stack.
     */
}

class Nineteen{
    class Node{
        Node next;
    }

    public void removeLastNode() {
        Node first = new Node();

        if (first.next == null) return;

        Node node = first;
        for (; node.next.next == null; node = node.next);
        node.next = null;
        
    }
}

class Twenty{
    /**
     * Assuming we have the first one, it's not easy. We need to iterate 17 times. Then replace the reference in 17
     * to 19.
     */
    class Node{
        Node next;
    }

    Node first;
    int N;

    public void removeElement(int k) {
        if ( k == 0){
            first = first.next;
            return;
        }

        if ( k > N - 1){
            return;
        }

        int count = 0;
        for (Node node = first; count <= k - 2 ; node = node.next){
            count++;
            if (count == k - 1){
                node = node.next.next;
            }
        };
        
        
    }
}

class TwnetyTwo{
    /**
     * Is the answer he gives correct? 
     * 
     * Suppose x->x1->t->t1. Setting t.next = x.next means x->x1->t->x1. Now x.next = t means x->t->x1. 
     * Ok, but t1 is removed!
     * 
     * If we also suppose t->t1->x->x1, it again removes whatever is after t, which is t1.
     * 
     * So there's a nuance here. It's true that we're putting t after x, but at the same time, we're removing
     * what ever there's after t!
     * 
     * I think actually trying to remove t from it's location and putting it next to x while preserving
     * the entire linked list requires knowledge of the previous node of t.
     */

     /**
      * Turns out, I was correct. Here's an implementation that actually takes care of this problem properly.
      * The scenarios are what happens if the nodes are in the beginning or end, or in the middle. We also
      * have to search for the previous node as well.
      */
    class Node { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 

    class LinkedList { 
        Node head; // head of list 
    
        /* Function to swap Nodes x and y in linked list by 
        changing links */
        public void swapNodes(int x, int y) 
        { 
            // Nothing to do if x and y are same 
            if (x == y) return; 
    
            // Search for x (keep track of prevX and CurrX) 
            Node prevX = null, currX = head; 
            while (currX != null && currX.data != x) 
            { 
                prevX = currX; 
                currX = currX.next; 
            } 
    
            // Search for y (keep track of prevY and currY) 
            Node prevY = null, currY = head; 
            while (currY != null && currY.data != y) 
            { 
                prevY = currY; 
                currY = currY.next; 
            } 
    
            // If either x or y is not present, nothing to do 
            if (currX == null || currY == null) 
                return; 
    
            // If x is not head of linked list 
            if (prevX != null) 
                prevX.next = currY; 
            else //make y the new head 
                head = currY; 
    
            // If y is not head of linked list 
            if (prevY != null) 
                prevY.next = currX; 
            else // make x the new head 
                head = currX; 
    
            // Swap next pointers 
            Node temp = currX.next; 
            currX.next = currY.next; 
            currY.next = temp; 
        } 
    
        /* Function to add Node at beginning of list. */
        public void push(int new_data) 
        { 
            /* 1. alloc the Node and put the data */
            Node new_Node = new Node(new_data); 
    
            /* 2. Make next of new Node as head */
            new_Node.next = head; 
    
            /* 3. Move the head to point to new Node */
            head = new_Node; 
        } 
    
        /* This function prints contents of linked list starting 
        from the given Node */
        public void printList() 
        { 
            Node tNode = head; 
            while (tNode != null) 
            { 
                System.out.print(tNode.data+" "); 
                tNode = tNode.next; 
            } 
        } 
    }
}

class TwentyThree{
    /**
     * I agree with the statement. But the same problem as the previous exercise remains.
     */
}

class TwnetyFour{
    /**
     * If we mean just removing the next element, the solution is something like this.
     */
    public static void removeAfter(Node node) {
        if (node.next == null) return;

        node.next = node.next.next;
    }
}

class TwentySix{
    /**
     * We need to find the last node of the first, which can be done by an exhaustive search,
     * then place the nodes right after. To ensure that the first list has the correct number 
     * of nodes, we need to actually iterate over the second list! It seems kind of redundant here,
     * but the goal of the exercise is to implement this inside the linked list, and not on the outside.
     */
    public static void insertAfter(int size_list1) {
        Node first1 = new Node<>();
        Node first2 = new Node<>(); 
        

        Node node = first1;
        for (; node.next != null; node = node.next);

        node.next = first2;
        // Write a loop here that increases the index of counter
        for (; node.next != null; node = node.next){++size_list1;};
    }
}