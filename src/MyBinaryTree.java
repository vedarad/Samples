/**
 * Created by sreenathkodedala on 8/1/16.
 */
public class MyBinaryTree {

    public static void main(String args[]){

        BinaryTree1 bt = new BinaryTree1();
        BinaryTree1.TreeNode treeNode = new BinaryTree1.TreeNode("A");

        bt.root = treeNode;
        bt.root.left = new BinaryTree1.TreeNode("B");
        bt.root.left.left = new BinaryTree1.TreeNode("C");
        bt.root.left.right = new BinaryTree1.TreeNode("D");
        bt.root.right = new BinaryTree1.TreeNode("E");
        bt.root.right.right = new BinaryTree1.TreeNode("G");
        bt.root.right.left = new BinaryTree1.TreeNode("F");

        System.out.println("Pre-order: ");
        bt.preOrder();
        System.out.println("\n");
        System.out.println("In-order: ");
        bt.inOrder();
        System.out.println("\n");
        System.out.println("Post-order: ");
        bt.postOrder();
    }

}

class BinaryTree1{

    static class TreeNode{
        String data;
        TreeNode left, right;

        TreeNode(String value){
            this.data = value;
            left = right = null;
        }

        boolean isLeaf(){
            return left == null ? right == null : false;
        }
    }

    TreeNode root;

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(TreeNode t){
        if(t == null)
            return;

        System.out.printf("%s ", t.data);
        preOrder(t.left);
        preOrder(t.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode t){
        if(t == null)
            return;

        inOrder(t.left);
        System.out.printf("%s ", t.data);
        inOrder(t.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode t){
        if(t == null)
            return;

        postOrder(t.left);
        postOrder(t.right);

        System.out.printf("%s ", t.data);
    }

}