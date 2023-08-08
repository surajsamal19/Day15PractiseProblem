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

    public boolean search(TreeNode node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
}

public class BinaryTreeSearchExample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        int keyToSearch = 63;

        boolean found = tree.search(tree.root, keyToSearch);

        if (found) {
            System.out.println(keyToSearch + " is found in the binary tree.");
        } else {
            System.out.println(keyToSearch + " is not found in the binary tree.");
        }
    }
}






