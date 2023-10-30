import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E>{
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;
    private E key;

    public BinaryTree(BinaryTree<E> leftChild, BinaryTree<E> rightChild, E key) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.key = key;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key=key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<indent;i++){
            stringBuilder.append("  ");
        }
        stringBuilder.append(key.toString()).append("\n");
        if(leftChild!=null){
            stringBuilder.append(leftChild.asIndentedPreOrder(indent+1));
        }
        if(rightChild!=null){
            stringBuilder.append(rightChild.asIndentedPreOrder(indent+1));
        }
        return stringBuilder.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        preOrder(this, result);
        return result;
    }
    private void preOrder(AbstractBinaryTree<E> node, List<AbstractBinaryTree<E>> result) {
        if (node != null) {
            result.add(node);
            preOrder(node.getLeft(), result);
            preOrder(node.getRight(), result);
        }
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        return null;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        return null;
    }

    @Override
    public void forEachInOrder(Consumer consumer) {

    }
}
