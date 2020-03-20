package 双链表;
//    双向链表
class ListNode{
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继
    public ListNode(int data){
        this.data=data;
    }
}
public class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾巴
    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
        public void addLast(int data) {
            ListNode node = new ListNode(data);
            if(this.head == null) {
                this.head = node;
                this.last = node;
            }else {
                this.last.next = node;
                node.prev = last;
                this.last = node;
            }
        }
    //打印
    public void display(){
        if(head==null){
            return;
        }else{
            ListNode cur=head;
            while(cur!=null){
                System.out.print(cur.data+" ");
                cur=cur.next;
            }
        }
    }
    private ListNode searchIndex(int index){
        if(index<0||index>getLength()||head==null){
            return null;
        }
        ListNode cur=head;
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    private int getLength() {
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    //在任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==getLength()){
            addLast(data);
            return;
        }
        ListNode cur=searchIndex(index);
        if(cur==null){
            return;
        }
        ListNode node=new ListNode(data);
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;
    }
    //查找是否包含关键字key在单链表中
    public boolean contains(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
           cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点，返回的值是要删除的节点
    public int remove(int key){
        int oldData=-1;
        ListNode cur=head;
        while(cur!=null){
            if(cur.data==key){
                oldData=cur.data;
                //判断cur是否为头节点
                if(cur==head){
                    head=head.next;
                    head.prev=null;
                    return oldData;
                }else{
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.next;
                    }else{
                        //尾巴节点
                        last=cur.prev;
                    }
                    return oldData;
                }
            }
            cur=cur.next;
        }
        return -1;
    }
    //删除所有值为key的节点
    public void removeAll(int key){
        ListNode cur=head;
        while(cur!=null) {
            if (cur.data == key) {
                //判断cur是否为头节点
                if (cur == head) {
                    head = head.next;
                    head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.next;
                    } else {
                        //尾巴节点
                        last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }
    //防止内存泄漏
    public void clear(){
       while(head!=null){
           ListNode cur=head.next;
           head.next=null;
           head.prev=null;
           head=cur;
       }
       last=null;
    }
    public static void main(String[] args) {
        DoubleList doubleList=new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(5);
        doubleList.addFirst(3);
        doubleList.addFirst(4);
        doubleList.addIndex(0,90);
        doubleList.addFirst(5);
        doubleList.addIndex(2,199);
       /* doubleList.display();
        boolean flg=doubleList.contains(90);
        System.out.println(flg);
        System.out.println("====删除====");
        int ret =doubleList.remove(5);
        doubleList.display();
        System.out.println(ret);
        ret=doubleList.remove(90);
        System.out.println(ret);
        doubleList.display();*/
        doubleList.removeAll(5);
        doubleList.display();
        doubleList.clear();
        System.out.println("sdsdsdcf");
    }
}
