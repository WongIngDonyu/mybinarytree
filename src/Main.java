import java.util.List;

public class Main {
    public static void main(String[] args) {
            BinaryTree<Integer> binaryTree = new BinaryTree<>(4,
                    new BinaryTree<>(2,
                            new BinaryTree<>(1,null, null),
                            new BinaryTree<>(3, null,null)),
                    new BinaryTree<>(6,
                            new BinaryTree<>(5, null,null),
                            new BinaryTree<>(7, null,null)));
        List<AbstractBinaryTree<Integer>> result = binaryTree.postOrder();
        for (AbstractBinaryTree<Integer> node : result){
            System.out.print(node.getKey()+" ");
        }
        System.out.println(" ");
        System.out.println(binaryTree.asIndentedPreOrder(1));
    }
}
