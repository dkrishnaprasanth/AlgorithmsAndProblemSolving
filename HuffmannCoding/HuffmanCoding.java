import java.util.*;

public class HuffmanCoding {
	
	static void compress(HuffNode root, String data, HashMap<Character, String> compresser, HashMap<String, Character> decompresser) {
		
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			compresser.put(root.data, data);
			decompresser.put(data, root.data);
		}
		
		compress(root.left, data + "0", compresser, decompresser);
		compress(root.right, data + "1", compresser, decompresser);
	}
	
	static void BuildHuffmanTree(String input) {
		
		HashMap<Character, Integer> freqMap = new HashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			char key = input.charAt(i);
			if (freqMap.containsKey(key)) {
				int value = freqMap.get(key) + 1;
				freqMap.put(key, value);
			} else {
				freqMap.put(key, 1);
			}
		}
		
		Set<Character> set = freqMap.keySet();
		PriorityQueue<HuffNode> pq = new PriorityQueue<>(new Comparator<HuffNode>(){
			@Override
			public int compare(HuffNode t1, HuffNode t2) {
				return t1.frequency - t2.frequency;
			}
		});
		
		for (Character i : set) {
			HuffNode newnode = new HuffNode(i, freqMap.get(i));
			pq.add(newnode);
		}
		
		while(pq.size() > 1) {
			
			HuffNode leftNode = pq.poll();
			HuffNode rightNode = pq.poll();
			
			int frequency = leftNode.frequency + rightNode.frequency;
			char data = '-';
			
			HuffNode newnode = new HuffNode(data, frequency);
			
			newnode.left = leftNode;
			newnode.right = rightNode;
			
			pq.add(newnode);
		}
		
		HuffNode root = pq.peek();
		HashMap<Character, String> compresser = new HashMap<>();
		HashMap<String, Character> decompresser = new HashMap<>();
		
		compress(root, "", compresser, decompresser);
		
		StringBuilder sb = new StringBuilder();
		
		for (char c : input.toCharArray()) {
			sb.append(compresser.get(c));
		}
		
		System.out.println("Compressed String is : " + sb.toString());
		StringBuilder result = new StringBuilder();
		int start = 0;
		
		for (int i = 0; i < sb.length(); i++) {
			if (decompresser.containsKey(sb.substring(start, i + 1))) {
				result.append(decompresser.get(sb.substring(start, i + 1)));
				start = i + 1;
			}
		}
		
		System.out.println("Decoded String is : " + result.toString());
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		BuildHuffmanTree(input);
		in.close();
	}
}
