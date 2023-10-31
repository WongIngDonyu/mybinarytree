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
        List<AbstractBinaryTree<Integer>> result1 = binaryTree.BFS();
        for (AbstractBinaryTree<Integer> node : result1){
            System.out.print(node.getKey()+" ");
        }
        System.out.println(" ");
        List<AbstractBinaryTree<Integer>> result2 = binaryTree.DFS();
        for (AbstractBinaryTree<Integer> node : result2){
            System.out.print(node.getKey()+" ");
        }
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        System.out.println("Элемент 4: " + tree.contains(4));
        System.out.println("Элемент 8: " + tree.contains(8));
        AbstractBinarySearchTree<Integer> searchResult = tree.search(5);
        System.out.println("Поиск значения 5: " + searchResult.getRoot().value);
        AbstractBinarySearchTree.Node<Integer> root = tree.getRoot();
        AbstractBinarySearchTree.Node<Integer> left = tree.getLeft();
        AbstractBinarySearchTree.Node<Integer> right = tree.getRight();

        System.out.println("Корень: " + root.value);
        System.out.println("Левый ребёнок: " + left.value);
        System.out.println("Правый ребёнок: " + right.value);
    }
}
