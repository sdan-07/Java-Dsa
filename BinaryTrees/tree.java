import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}

public class tree{
    Node root;

    public void insert(int data){
        root = InsertRec(root, data, null, null);
    }

    public Node InsertRec(Node root, int data, Node parent, String pos){
        if(root == null){
            root = new Node(data);
            if(parent == null)
                System.out.println("Node "+data+" inserted as root");
            else
                System.out.println("Node "+data+" inserted at "+pos+" under parent root "+parent.data);
            return root;
        }

        if(data < root.data)
            root.left = InsertRec(root.left, data, root, "left");
        else if(data > root.data)
            root.right = InsertRec(root.right, data, root, "right");

        else System.out.println("Duplicate node ignored "+data);

        return root;
    }

    //traversals
    public void postorder(){
        PostOrderRec(root);
    }

    public void preorder(){
        PreOrderRec(root);
    }

    public void Inorder(){
        InorderRec(root);
    }

    public void InorderRec(Node root){

        if(root != null){
            InorderRec(root.left);

            System.out.print(root.data+" ");
            InorderRec(root.right);
        }
    }

    public void PreOrderRec(Node root){

        if(root != null){

            System.out.print(root.data+" ");
            PreOrderRec(root.left);
            PreOrderRec(root.right);
        }
    }

    public void PostOrderRec(Node root){

        if(root != null){
            PostOrderRec(root.left);
            PostOrderRec(root.right);

            System.out.print(root.data+" ");
        }
    }

    //Level order traversal
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> wraplst = new LinkedList<>();

        if(root == null) System.out.print("Empty tree");

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> sublst = new LinkedList<>();

            int queueLen = queue.size();
            for(int i=0; i<queueLen; i++){
                if(queue.peek().left != null)  queue.offer(queue.peek().left);
                if(queue.peek().right != null)  queue.offer(queue.peek().right);

                sublst.add(queue.poll().data);
            }
            wraplst.add(sublst);
        }

        System.out.println(wraplst);

    }


    public static void main(String[] args) {
        tree tree = new tree();

        tree.insert(21);
        tree.insert(40);
        tree.insert(33);
        tree.insert(12);
        tree.insert(97);

//        tree.Inorder();
//        System.out.println();
//
//        tree.preorder();
//        System.out.println();
//
//        tree.postorder();
        System.out.println();

        tree.levelOrder();
    }
}



