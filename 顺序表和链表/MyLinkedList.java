package 顺序表和链表;
class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
public class MyLinkedList {
    public Node head;

    public MyLinkedList() {
        this.head = null;
    }

    //    头插法
    public void addFirst(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    //    尾插法
    public void addLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    // 查找是否包含关键字key是否在单链表中
    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //  得到链表的长度
    public int getLength() {
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //  找到index-1的位置
    public Node searchIndex(int index) {
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 在任意位置插入
    public boolean addIndex(int index, int val) {
        if (index < 0 | index > getLength()) {
            System.out.println("index不合法");
            return false;
        }
        if (index == 0) {
            addFirst(val);
            return true;
        }
        //找到index-1的位置
        Node cur = searchIndex(index);
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    // 删除第一次出现的关键字为key的节点
    public void remove(int key) {
        //链表为空
        if (head == null) {
            System.out.println("单链表为空");
            return;
        }
        //删除的节点是头节点
        if (head.val == key) {
            head = head.next;
            return;
        }
//        1.找到key的前驱
        Node prev = searchPrev(key);
        if (prev == null) {
            return;
        }
//        2.删除节点
        Node del = prev.next;
        prev.next = del.next;
    }

    //查找前驱
    private Node searchPrev(int key) {
        Node prev = head;
        while (prev.next != null) {
            if (prev.next.val == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (prev.next.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == key) {
            head = head.next;
        }
    }

    // 打印
    public void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //内存泄漏问题
    public void clear(){
        //一个一个置为空
        while(head!=null){
            Node cur=head.next;
            head.next=null;
            head=null;
        }
    }
    // 反转单链表
    public Node reverseList() {
        Node prev = null;
        Node newHead = null;
        Node cur = head;
        while (head != null) {
            Node curNext = cur, next;
            if (curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //单链表的中间节点
    public Node middleNode() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //    查找倒数第K个节点
    public Node findKthToTail(int k) {
        if (k <= 0) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //    删除重复的节点
    public Node deleteDuplication() {
        Node node = new Node(-1);
        Node cur = head;
        Node tmp = node;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //退出循环，cur要多走一步
                cur = cur.next;
            } else {
                //当前节点不等于下个结点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return node.next;
    }

    //  链表的回文结构（正着和反着都是一样的）
    public boolean chkPalindromde() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转单链表后半部分
        Node p = slow.next;
        while (p != null) {
            Node pNext = p.next;
            p.next = slow;
            slow = p;
            p = pNext;
        }
        //判断是否有回文
        while (head.val == slow.val) {
            head = head.next;
            slow = slow.next;
            if (head == slow) {
                return true;
            }
        }
        return false;
    }

    //    创造环形链表
    public void creatLoop() {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next;
    }

    //  判断是否有环
    public boolean hasCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    //  找环的入口点
    public Node detectCycle() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        //没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 求环的长度
    public int listLen() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        //没有环
        if (fast == null || fast.next == null) {
            return -1;
        }
        //上一步走完，slow等于fast。所以要想直到环的长度。slow必须先走一步，在循环判断slow是否等于fast
        slow = slow.next;//让slow先走一步
        int count = 1;
        while (slow != fast) {
            slow = slow.next;
            count++;
        }
        return count;
    }

    //合并两个有序链表
    public static Node mergeTwoLists(Node headA, Node headB) {
        Node curA = headA;
        Node curB = headB;
        Node node = new Node(-1);
        Node tmp = node;
        while (curA != null && curB != null) {
            if (curA.val <=curB.val) {
                tmp.next = curA;
                curA = curA.next;
                tmp = tmp.next;
            } else {
                tmp.next = curB;
                curB = curB.next;
                tmp = tmp.next;
            }

        }
        if (curA != null) {
            tmp.next = curA;
        }
        if (curB != null) {
            tmp.next = curB;
        }
        return node.next;
    }
    //将链表按照基准值分割为两部分，将小于基准值的放在左边，大于基准值的放在右边
    public Node partition(int x) {
        Node cur = head;
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        while (cur != null) {
            if (cur.val < x) {
                if (beforeStart == null) {//第一次插入
                    beforeStart = cur;
                    beforeEnd = cur;
                } else {
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterStart == null) {//第一次插入
                    afterStart = cur;
                    afterEnd = cur;
                } else {
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur = cur.next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        if (afterStart != null) {
            afterEnd.next = null;
        }
        return beforeStart;
    }
}
