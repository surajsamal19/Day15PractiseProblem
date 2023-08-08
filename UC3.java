interface INode<K extends Comparable<K>> {
    K getKey();

    void setKey(K key);

    INode<K> getLeft();

    void setLeft(INode<K> left);

    INode<K> getRight();

    void setRight(INode<K> right);
}


class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
    private K key;
    private INode<K> left;
    private INode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public INode<K> getLeft() {
        return left;
    }

    @Override
    public void setLeft(INode<K> left) {
        this.left = left;
    }

    @Override
    public INode<K> getRight() {
        return right;
    }

    @Override
    public void setRight(INode<K> right) {
        this.right = right;
    }
}

// BinarySearchTree class
class BinarySearchTree<K extends Comparable<K>> {
    private INode<K> root;

    public void add(K key) {
        root = addRec(root, key);
    }

    private INode<K> addRec(INode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        if (key.compareTo(current.getKey()) < 0) {
            current.setLeft(addRec(current.getLeft(), key));
        } else if (key.compareTo(current.getKey()) > 0) {
            current.setRight(addRec(current.getRight(), key));
        }

        return current;
    }

    public void inOrderTraversal(INode<K> current) {
        if (current != null) {
            inOrderTraversal(current.getLeft());
            System.out.print(current.getKey() + " ");
            inOrderTraversal(current.getRight());
        }
    }
}

public class BinarySearchTreeExample {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(56);
        bst.add(30);
        bst.add(70);

        System.out.println("In-order traversal:");
        bst.inOrderTraversal(bst.getRoot());
    }
}






