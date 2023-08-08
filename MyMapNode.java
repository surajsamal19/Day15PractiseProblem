import java.util.LinkedList;
class MyMapNode {
    String key;
    int value;

    public MyMapNode(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
class HashTable {
    private LinkedList<MyMapNode>[] buckets;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % size;
    }

    public void insert(String key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode> bucket = buckets[index];

        for (MyMapNode node : bucket) {
            if (node.key.equals(key)) {
                node.value++;
                return;
            }
        }

        bucket.add(new MyMapNode(key, 1));
    }

    public int getFrequency(String key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode> bucket = buckets[index];

        for (MyMapNode node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return 0; // Word not found
    }
}

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String sentence = "To be or not to be";
        String[] words = sentence.split(" ");

        HashTable hashTable = new HashTable(words.length);

        for (String word : words) {
            // Remove punctuation and convert to lowercase for accurate counting
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                hashTable.insert(word);
            }
        }

        // Print word frequencies
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                System.out.println("Frequency of '" + word + "': " + hashTable.getFrequency(word));
            }
        }
    }
}






