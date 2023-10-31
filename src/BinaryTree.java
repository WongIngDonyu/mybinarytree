import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E>{
    private E key;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> leftChild, BinaryTree<E> rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        inOrder(this, result);
        return result;
    }
    private void inOrder(AbstractBinaryTree<E> node, List<AbstractBinaryTree<E>> result){
        if (node!=null){
            inOrder(node.getLeft(), result);
            result.add(node);
            inOrder(node.getRight(), result);
        }
    }
    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        postOrder(this, result);
        return result;
    }
    private void postOrder(AbstractBinaryTree<E> node, List<AbstractBinaryTree<E>> result){
        if (node!=null){
            postOrder(node.getLeft(), result);
            postOrder(node.getRight(), result);
            result.add(node);
        }
    }
    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if(leftChild!=null){
            leftChild.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if(rightChild!=null){
            rightChild.forEachInOrder(consumer);
        }
    }
}
