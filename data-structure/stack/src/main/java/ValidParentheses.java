import java.util.ArrayDeque;

/**
 * @author pineapple-man
 */
public class ValidParentheses {
	public static void main(String[] args) {
		String s = "()";
		ValidParentheses t = new ValidParentheses();
		System.out.println(t.isValid(s));
	}
	
	public boolean isValid(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.addLast(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.removeLast();
				if ((c == ')' && last != '(') || (c == ']' && last != '[') || (c == '}' && last != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
