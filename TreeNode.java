class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public int size(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return size(node.left) + 1 + size(node.right);
    }
}

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);
        int expectedSize = 7;
        int actualSize = tree.size(tree.root);
        
        if (actualSize == expectedSize) {
            System.out.println("All nodes are added to the binary tree.");
        } else {
            System.out.println("Not all nodes are added to the binary tree.");
        }
    }
}





