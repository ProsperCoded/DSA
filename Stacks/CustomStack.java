package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CustomStack {
  String text; 
  public CustomStack(String text){
    this.text = text;
  }
  public StringBuffer reverse(){
    var stack = new Stack<Character>();
    var revered  = new StringBuffer();
    for( int i =0; i< text.length(); i++){
      var c = text.charAt(i);
      stack.push(c);
    }
    while (!stack.empty()){
      revered.append(stack.pop());
    }
    return revered;
  }
  public boolean  checkExpression(){
    var blocks = new ArrayList<List>();
    var squareBrackets = Arrays.asList("[", "]");
    var braces = Arrays.asList("(", ")");
    var triangleBrackets = Arrays.asList("<", ">");
    blocks.add(squareBrackets);
    blocks.add(braces);
    blocks.add(triangleBrackets);

    // * stack to store block that comes up in string 
    var stack = new Stack<Character>();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      for (int j = 0; j < braces.size(); j++) {
        var block = blocks.get(j);
        if (String.valueOf(c) == block.get(0)){
          stack.push(c);
        }
        if (String.valueOf(c) == block.get(1)){
          if (stack.isEmpty() || !stack.peek().toString().equals(block.get(0))) {
            return false;
          }
          stack.pop();
        }
      }
    }
    return true;
  }
}
