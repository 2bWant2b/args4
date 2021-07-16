package com.company.mosh;

import java.util.Stack;

public class Expression {
    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()){
            if (ch=='('||ch=='['||ch=='{') {
                switch (ch){
                    case '(':
                        stack.push(')');
                        break;
                    case '[':
                        stack.push(']');
                        break;
                    case '{':
                        stack.push('}');
                        break;
                }
            }
            if (ch==')'||ch==']'||ch=='}') {
                if (stack.isEmpty()) return false;
                if (ch!=stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
