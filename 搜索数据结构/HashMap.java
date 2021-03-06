package 搜索数据结构;

/**
 * @Author:wangrui
 * @Date:2020/3/19 19:43
 */
public class HashMap<K,V>implements Map<K,V> {
    //要求table.length 必须是2的幂次方
    private Entry<K,V>[]table=new Entry[16];
    //HashMap中已经保存的有效key的个数
    private int size=0;
    private static final double LOADER_FACTOR_THRESHOLD=0.75;
    @Override
    public V get(K key) {
        //1.根据key得到下标
        int index;
        if(key==null){
            index=0;
        }else {
            //1.1  求出key的hashCode();
            //这里使用了HashCode(),如果要用自定义的类作为hashCode()K类型，则必须在类中覆写HashCode()
            //AND  相同的key的hashcode()相等，否则无法根据相同的key找到唯一的下标
            int hash = key.hashCode();
            //这个的作用是让hash中的每一位都参与到找下标中，使得找到的下标尽可能均匀
            hash = (hash >>> 16) ^ hash;
            //1.2. 利用hash得到合法的下标
            index = hash & (table.length - 1);
        }
        //2.使用下标，找到链表的头结点的引用
        Entry<K,V> head=table[index];
        //3.在链表中，找到包含key的节点，返回存在节点中的value，即和key关联的value
        //方法就是遍历链表，去找
        Entry<K,V>node=head;
        while(node!=null){
            /**
             *这里使用了key的equals方法——>如果你使用自定义的类作为HashMap的key
             * 必须覆写类的equals方法，保证你认为相同的key，equals返回true
             * 否则，无法找到value
             */
            if(key.equals(node.key)){
                return node.value;
            }
            node=node.next;
        }
        //链表遍历结束了，没有找到
        return null;
    }
    @Override
    public V put(K key, V value) {
        //1.根据key得到下标
        //1.1  求出key的hashCode();
        //这里使用了HashCode(),如果要用自定义的类作为hashCode()K类型，则必须在类中覆写HashCode()
        //AND  相同的key的hashcode()相等，否则无法根据相同的key找到唯一的下标
        int hash=key.hashCode();
        //这个的作用是让hash中的每一位都参与到找下标中，使得找到的下标尽可能均匀
        hash=(hash>>16)^hash;
        //1.2. 利用hash得到合法的下标
        int index=hash&(table.length-1);
        //2.使用下标，找到链表的头结点的引用
        Entry<K,V> head=table[index];
        //3.在链表中，找到包含key的节点，返回存在节点中的value，即和key关联的value
        //方法就是遍历链表，去找
        Entry<K,V>node=head;
        while(node!=null){
            /**
             *这里使用了key的equals方法——>如果你使用自定义的类作为HashMap的key
             * 必须覆写类的equals方法，保证你认为相同的key，equals返回true
             * 否则，无法找到value
             */
            if(key==null&&node.key==null){
                V oldValue=node.value;
                node.value=value;
                return oldValue;
            }else if(key.equals(node.key)){
                //使用新得value替换原来的value，并且返回原来的value
                V oldValue=node.value;
                node.value=value;
                return oldValue;
            }
            node=node.next;
        }
        //链表遍历结束了，没有找到,使用key-value新建节点，并且把结点插入到链表中
        Entry<K,V>entry=new Entry<>(key,value);
        //要把结点插入到链表中，两种方式：头插or尾插
        //如果不考虑多线程的情况，其实头插比较简单
        //如果考虑多线程情况，头插会产生问题，所以1.8以后使用了尾插，因此我选择尾插
        if(head==null){
            table[index]=entry;
        }else{
            Entry<K,V>last=head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=entry;
        }
        size++;
        //为了减少冲突率，所以通过考虑降低size/table.length的值
        //设置一个阈值，当size/table.length高于某个值时，进行扩容
        //所谓的扩容，就是保证size不变，让table.length变大
        //进而，使得size/table.length降低，进而减少冲突率
        if(size*1.0/table.length>LOADER_FACTOR_THRESHOLD){
            resize();
        }
        return null;
    }
    //扩容，1.需要保证table.length仍然是2的幂次方
    //2.因为table.length变化了，所以key对象的下标一定会变；
    //      所以，需要把所有的key重新计算下标，重新插入


    private void resize() {
        //长度*2，保持了2的幂次方
        Entry[] newTable=new Entry[table.length*2];
        //遍历原来的所有的链表（遍历数组）
        for(int i=0;i<table.length;i++){
            Entry<K,V>head=table[i];
            //head是一条条链表的头结点的引用
            //遍历链表中的每一个结点，把key-value重新插入newTable中
            Entry<K,V>node=head;
            while(node!=null){
                K key=node.key;
                V value=node.value;
                //利用key，求新的下标
                int hash=key.hashCode();
                hash=(hash>>>16)^hash;
                //直接头插
                int index=hash&(newTable.length-1);
                Entry<K,V>entry=newTable[index];
                newTable[index]=entry;
                node=node.next;
            }
        }
        //原来的table不要了，使用newTable替换原来的table
        table=newTable;
    }
}
