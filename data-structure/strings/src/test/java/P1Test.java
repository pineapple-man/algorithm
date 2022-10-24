import com.pineapple.generator.NumericalGenerator;
import com.pineapple.generator.StringGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author pineapple-man
 */
class P1Test {
	@Test
	void solution() {
		for (int i = 0; i < 10; i++) {
			int length = NumericalGenerator.getLittleRandomPositiveInt();
			int maxLength = NumericalGenerator.getLittleRandomPositiveInt();
			
			String[] strings = new String[length];
			for (int j = 0; j < length; j++) {
				strings[j] =
						StringGenerator.getRandomLengthLowerCaseString(maxLength);
			}
			int i1 = P1.solution(strings);
			int i2 = types2(strings);
			Assertions.assertEquals(i1, i2);
		}
	}
	
	public static int types2(String[] arr) {
		HashSet<Integer> types = new HashSet<>();
		for (String str : arr) {
			char[] chs = str.toCharArray();
			int key = 0;
			for (int i = 0; i < chs.length; i++) {
				key |= (1 << (chs[i] - 'a'));
			}
			types.add(key);
		}
		return types.size();
	}
}