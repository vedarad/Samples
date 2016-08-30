import java.util.Stack;

/**
 * Created by sreenathkodedala on 8/2/16.
 */
public class BST {

    public static void main(String[] args){
        BST bst = new BST();
        System.out.println("Binary Tree is empty: "+bst.isEmpty());
        bst.insert(67);bst.insert(45);bst.insert(39);bst.insert(23);
        bst.insert(73);bst.insert(81);bst.insert(93);bst.insert(59);bst.insert(100);

        System.out.println("Original Tree : ");
        bst.display(bst.root);
        System.out.println();
        System.out.println("Find the id we passed : "+bst.find(39));
        System.out.println("Find the id we passed : "+bst.find(95));
        System.out.println("Size of the Binary Tree: "+bst.size());
        System.out.println("Binary Tree is empty: "+bst.isEmpty());
        System.out.println("Delete node from Binary Tree: "+bst.delete(45));
        bst.display(bst.root);
        bst.clear();
        System.out.println("Binary Tree is empty: "+bst.isEmpty());
    }

    private static class Node{
        int data;
        Node left, right;

        Node(int val){
            this.data = val;
            left = right = null;
        }
    }

    Node root;

    public BST(){
        root = null;
    }

    public Node getRoot(){
        return root;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void clear(){
        root = null;
    }

    public int size(){
        Node current = root;
        int size = 0;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                size++;
                current = stack.pop();
                current = current.right;
            }
        }
        return size;
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.printf("%s ", root.data);
            display(root.right);
        }
    }

    public void insert(int id){
        Node newNode = new Node(id);
        if(root==null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.data){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }

    }

    public boolean find(int id){
        Node current = root;
        while(current!=null) {
            if (current.data == id) {
                return true;
            }else if(current.data>id){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int id){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while(current.data!=id){
            parent = current;
            if(current.data>id){
                isLeftChild = true;
                current = current.left;
            }else{
                current = current.right;
            }
            if(current == null)
                return false;
        }
        //if node has no child nodes //else if node has either a left or right node only // else it has both left and right nodes
        if(current.left == null && current.right == null){
            if(current == root)
                root = null;

            if(isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }else if(current.right == null){
            if(current == root)
                root = current.left;
            else if(isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.right;

        }else if(current.left == null){
            if(current == root)
                root = current.right;
            else if(isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }else if(current.left != null && current.right != null){
            Node nextNode = getNextNode(current);
            if(current == root)
                root = nextNode;
            if(isLeftChild)
                parent.left = nextNode;
            else
                parent.right = nextNode;

            nextNode.left = current.left;
        }
        return true;
    }

    public Node getNextNode(Node c){
        Node successor =null;
        Node successorParent =null;
        Node current = c.right;
        while(current!=null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if(successor!=c.right){
            successorParent.left = successor.right;
            successor.right = c.right;
        }
        return successor;
    }
}
