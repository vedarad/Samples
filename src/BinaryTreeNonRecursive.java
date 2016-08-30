import java.util.Stack;

/**
 * Created by sreenathkodedala on 8/2/16.
 */
public class BinaryTreeNonRecursive {

    public static void main(String args[]){

        BinaryTree2 bt = BinaryTree2.create();
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

class BinaryTree2{
    static class TreeNode{
        String data;
        TreeNode left, right;

        TreeNode(String val){
            this.data = val;
            left = right = null;
        }
    }
    TreeNode root;

    public void preOrder(){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.empty()){
            TreeNode c = st.pop();
            System.out.printf("%s ", c.data);

            if(c.right!=null)
                st.push(c.right);

            if(c.left!=null)
                st.push(c.left);

        }
    }

    public void inOrder(){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.empty()){
            TreeNode c = st.pop();

            if(c.left!=null)
                st.push(c.left);
            System.out.printf("%s ", c.data);

            if(c.right!=null)
                st.push(c.right);

        }
    }

    public void postOrder(){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.empty()){
            TreeNode c = st.pop();

            if(c.left!=null)
                st.push(c.left);

            if(c.right!=null)
                st.push(c.right);
            System.out.printf("%s ", c.data);
        }
    }

    public static BinaryTree2 create() {
        BinaryTree2 tree = new BinaryTree2();
        TreeNode root = new TreeNode("A");
        tree.root = root;
        tree.root.left = new TreeNode("B");
        tree.root.left.left = new TreeNode("C");
        tree.root.left.right = new TreeNode("D");
        tree.root.right = new TreeNode("E");
        tree.root.right.left = new TreeNode("F");
        tree.root.right.right = new TreeNode("G");
        return tree;
    }

}
