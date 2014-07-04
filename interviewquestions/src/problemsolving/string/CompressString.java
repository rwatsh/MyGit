package problemsolving.string;

/**
 * Compress string such that string aabcccccaaa becomes a2b1c5a3.
 * 
 * @author rushil
 * 
 */
public class CompressString {

	public String compressString(String inStr) {
		char[] arr = inStr.toCharArray();
		char prev = '\0';
		char curr = '\0';

		int count = 1;
		StringBuilder sb = new StringBuilder();

		for (char ch : arr) {
			if (prev == '\0') {
				prev = ch;
			} else {
				curr = ch;
				if (prev == curr) {
					count++;
				} else {
					sb.append(prev).append(count);
					count = 1;
					prev = curr;
				}
			}
		}
		if (curr != '\0') {
			sb.append(curr).append(count);
		}
		return sb.toString();
	}
}
