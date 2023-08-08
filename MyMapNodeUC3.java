import java.util.LinkedList;
class MyMapNodeUC3 {
    String key;
    int value;

    public MyMapNode(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

// HashTable class using LinkedList for collision resolution
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

    public void remove(String key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode> bucket = buckets[index];

        for (MyMapNode node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }
}

public class RemoveWordExample {
    public static void main(String[] args) {
        String paragraph = "Paranoids are not paranoid because they are paranoid but " +
                           "because they keep putting themselves deliberately into " +
                           "paranoid avoidable situations";
        String[] words = paragraph.split(" ");

        HashTable hashTable = new HashTable(words.length);

        for (String word : words) {
            // Remove punctuation and convert to lowercase for accurate counting
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                hashTable.insert(word);
            }
        }
        hashTable.remove("avoidable");

        // Print word frequencies after removal
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                System.out.println("Frequency of '" + word + "': " + hashTable.getFrequency(word));
            }
        }
    }
}




