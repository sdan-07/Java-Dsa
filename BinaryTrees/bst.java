class treeNode{
    int data;
    treeNode left;
    treeNode right;

    treeNode(int data){
        this.data = data;
    }
}

public class bst {
    treeNode root;

    public void insert(int data){ root = insertRec(root, data, null, null); }

    public treeNode insertRec(treeNode root, int data, treeNode parent, String pos){
        if(root==null){
            root = new treeNode(data);

            if(parent == null)  System.out.println("Node "+data+" inserted as root");
            else    System.out.println("Node "+data+" inserted at "+pos+" under parent root "+parent.data);

            return root;
        }

        if (data > root.data)    root.right = insertRec(root.right, data, root, "right");
        else if (data < root.data)  root.left = insertRec(root.left, data, root, "left");
        else    System.out.println("Duplicate node "+data+" ignored");

        return root;
    }

    public static void main(String[] args) {
        bst tree = new bst();

        tree.insert(45);
        tree.insert(50);
        tree.insert(30);



    }
}
