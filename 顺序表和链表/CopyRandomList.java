package 顺序表和链表;
//复杂链表的复制
public class CopyRandomList {
    class Node{
        int val;
        Node next;
        Node random;
        public Node(int val,Node next,Node random){
            this.val=val;
            this.next=next;
            this.random=random;
        }
    }
    public Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        //1.将老新节点，串为一个链表
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val,cur.next,null);
            Node tmp=cur.next;
            cur.next=node;
            cur=tmp;
        }
        //2.开始解决random指针
        cur=head;
        while (cur != null) {
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        //3.拆分拆分链表
        cur=head;
        Node newHead=cur.next;
        while(cur.next!=null){
            Node tmp=cur.next;
            cur.next=tmp.next;
            cur=tmp;
        }
        return newHead;
    }
}
