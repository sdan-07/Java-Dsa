package questions;

class listNode {
    int data;
    listNode next;

    listNode(int data){ this.data=data; }
}

public class reverseLL {
    listNode head=null, tail=null;

    public void insert_end(int data){
        listNode nn = new listNode(data);
        if(head == null)
            head=tail=nn;
        else{
            tail.next = nn;
            tail = nn;
        }
    }

    public void print(){
        listNode t = head;
        while(t!=null){
            System.out.print(t.data+" -> ");
            t=t.next;
        }
        System.out.print("null");
    }

    //reverse function
    public listNode reverse(){
        listNode prevptr = null, curr = head;

        while(curr != null){
            listNode nextptr = curr.next;
            curr.next = prevptr;
            prevptr = curr;
            curr = nextptr;
        }
        return prevptr;
    }


    public static void main(String[] args) {
        reverseLL ll = new reverseLL();

        ll.insert_end(42);
        ll.insert_end(78);
        ll.insert_end(89);

        System.out.println("Original list:");
        ll.print();

        System.out.println("\nAfter reversing list:");
        ll.head = ll.reverse();
        ll.print();

    }
}





