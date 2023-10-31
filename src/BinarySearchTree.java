public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree  {
    private Node<E> root;

    @Override
    public void insert(Comparable element) {
        root = insertRecurs(root, (E) element);
    }
    private Node<E> insertRecurs(Node<E> root, E element){
        if(root==null){
            root = new Node<>(element);
            return root;
        }
        if(element.compareTo(root.value)<0){
            root.leftChild = insertRecurs(root.leftChild, element);
        } else if (element.compareTo(root.value)>0) {
            root.rightChild = insertRecurs(root.rightChild, element);
        }
        return root;
    }
    @Override
    public boolean contains(Comparable element) {
        return containsRecurs(root, (E) element);
    }
    private boolean containsRecurs(Node<E> root, E element){
        if (root==null){
            return false;
        }
        if (element.equals(root.value)){
            return true;
        }
        if (element.compareTo(root.value)<0){
            return  containsRecurs(root.leftChild, element);
        }
        return containsRecurs(root.rightChild,element);
    }

    @Override
    public AbstractBinarySearchTree<E> search(Comparable element) {
        Node<E> result = searchRecurs(root, (E) element);
        if(result==null){
            return new BinarySearchTree<>();
        }
        else {
            BinarySearchTree<E> newTree = new BinarySearchTree<>();
            newTree.root=result;
            return newTree;
        }
    }
    private Node<E> searchRecurs(Node<E> root, E element){
        if(root==null || element.equals(root.value)){
            return root;
        }
        if(element.compareTo(root.value)<0){
            return searchRecurs(root.leftChild, element);
        }
        return searchRecurs(root.rightChild, element);
    }
    @Override
    public Node<E> getRoot() {
        return root;
    }

    @Override
    public Node<E> getLeft() {
        if (root!=null){
            return root.leftChild;
        }
        return null;
    }

    @Override
    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        }
        return null;
    }

    @Override
    public Comparable<E> getValue() {
        if (root != null) {
            return root.value;
        }
        return null;
    }
}
