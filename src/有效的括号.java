import java.util.HashMap;
import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        有效的括号 a = new 有效的括号();
        String s = "()((()))";
        System.out.println(a.isValid(s));

    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();

    }
}
