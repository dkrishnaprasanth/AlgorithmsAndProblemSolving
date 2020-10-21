
public class HuffNode {
	char data;
	int frequency;
	HuffNode left, right;
	HuffNode(char data, int frequency) {
		this.data = data;
		this.frequency = frequency;
		left = right = null;
	}
}
