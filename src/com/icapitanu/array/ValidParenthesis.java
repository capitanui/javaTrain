package com.icapitanu.array;
/*
 * @author ionutcapitanu on 2020-06-17
 */

//Valid paranthesis

    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
     */


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class ValidParenthesis {
    // Declare a map to know correct combinations
    private HashMap<Character,Character> validMapping;
    public ValidParenthesis() {
        validMapping = new HashMap<>();
        validMapping.put(')','(');
        validMapping.put(']','[');
        validMapping.put('}','{');
    }
    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0) return true;
        // Daca s incepe sau se termina cu o paranteza inchisa - returneaza false
        if (validMapping.containsKey(s.charAt(0)) ||  validMapping.containsValue(s.charAt(s.length()-1))) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++){
                char evalChar = s.charAt(i);
                stack.push(evalChar);

                if (stack.contains( validMapping.get(evalChar))) {
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}