package 顺序表和链表;

public class TestDemo {
//  输入两个链表，求他们的公共节点
    public static Node getIntersectionNode(Node headA,Node headB){
        if(headA==null||headB==null){
            return null;
        }
        Node pL=headA;//永远指向最长的单链表
        Node pS=headB;//永远指向最短的单链表
        int lenA=0;
        int lenB=0;
        //分别求长度
        while(pL!=null){
            lenA++;
            pL=pL.next;
        }
        while(pS!=null){
            lenB++;
            pS=pS.next;
        }
        pL=headA;
        pS=headB;
        //求长度的差值
        int len=lenA-lenB;
        if(len<0){
            pL=headA;
            pS=headB;
            len=lenB-lenA;
        }
        //只需要让pL走len步就好了
        while(len>0){
            pL=pL.next;
            len--;
        }
        //走完len步之后，两个同时开始走，一直走到next值相同时就是交点
        while(pL!=pS&&pL!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null) {
            return pL;
        }
        return null;
    }
//   创建相交链表
    public static void createCut(Node headA,Node headB){
        headA.next.next=headB.next.next.next;
    }
    public static void main(String[] args) {
        /*MyLinkedList B=new MyLinkedList();
        B.addFirst(1);
        B.addFirst(2);
        B.addFirst(3);
        B.addFirst(3);
        B.remove(3);
        B.addLast(5);
        B.addLast(9);
        B.contains(10);
        B.addLast(9);
        B.display();
        B.addIndex(2,8);
        B.display();
        B.removeAllKey(9);
        B.display();
        B.reverseList();
        //B.display2(newHead);*/
        MyLinkedList A = new MyLinkedList();
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(5);
        A.addLast(6);
        A.display();
        Node node= A.findKthToTail(2);
        System.out.println(node.val);
        A.creatLoop();
        boolean flg=A.hasCycle();
        System.out.println(flg);
      /*  Node e= A.detectCycle();
        System.out.println(e.val);
        int len=A.listLen();
        System.out.println(len);*/
        MyLinkedList C = new MyLinkedList();
        C.addLast(4);
        C.addLast(12);
        C.addLast(13);
        C.addLast(14);
        C.addLast(54);
        C.display();
        /*createCut(A.head, C.head);
        Node node = getIntersectionNode(A.head, C.head);
        System.out.println(node.val);*/
        Node node1=MyLinkedList.mergeTwoLists(A.head,C.head);
        C.display2(node);
        MyLinkedList d=new MyLinkedList();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(2);
        d.addLast(1);
        d.display();
       boolean flg2 =d.chkPalindromde();
        System.out.println(flg);
       /* Node node2=d.partition(4);
        d.display2(node2);*/
    }
}
