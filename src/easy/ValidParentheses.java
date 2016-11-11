package easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by kekai on 16/11/8.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        List<Character> elements = Arrays.asList('(','{','[',')','}',']');
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char z = s.charAt(i);
            int index = elements.indexOf(z);
            if(index < 3) {
                stack.push(z);
            }else {
                if(stack.empty()) {
                    return false;
                }
                char top = stack.peek();
                char expect = elements.get(index-3);
                if(top != expect) {
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        if(stack.empty())
            return true;
        return false;

    }
}
