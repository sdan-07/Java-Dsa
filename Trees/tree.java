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

    public static void main(String[] args) {
        tree tree = new tree();
        tree.insert(21);
        tree.insert(40);
        tree.insert(33);
        tree.insert(12);

        tree.insert(78);
        tree.insert(100);

        tree.Inorder();
        System.out.println();

        tree.preorder();
        System.out.println();

        tree.postorder();
    }
}



