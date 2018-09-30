//estrutura simplificada da árvore
public class BinaryTree {
    public BinaryTree father;
    public BinaryTree left;
    public BinaryTree right;
    public String element;

    public BinaryTree(String element) {
        father = null;
        left = null;
        right = null;
        this.element = element;
    }
}