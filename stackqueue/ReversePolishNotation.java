package stackqueue;
import java.util.*;

public class ReversePolishNotation {
  public int evalRPN(String[] tokens) {
    
    // we need to constantly look back
    Deque<Integer> stack = new ArrayDeque<>();

    for (String token : tokens) {

      if (Character.isDigit(token.charAt(0))) {        
        stack.offerFirst(convertToInt(token));
      } else {
        stack.offerFirst(operation(stack, token));
      }
    }

    return stack.pollFirst();
  }
  public int convertToInt(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      res = res * 10 + (s.charAt(i) - '0');
    }
    return res;
  }

  private int operation(Deque<Integer> stack, String op) {

    int num1 = stack.pollFirst();
    int num2 = stack.pollFirst();
    int res = 0;
    switch(op) {
      case "+":
        res = num2 + num1;
        break;
      case "-":
        res = num2 - num1;
        break;
      case "*":
        res = num2 * num1;
        break;
      case "/":
        res = num2 / num1;              
        break;
    }
    return res;
  }

  public static void main(String[] args) {
    String[] strLs = {"0","12","4","+","-"};

    ReversePolishNotation sol = new ReversePolishNotation();    
    System.out.println(sol.evalRPN(strLs));
  }
}
