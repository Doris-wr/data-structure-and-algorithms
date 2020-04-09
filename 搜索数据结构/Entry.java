package 搜索数据结构;

/**
 * @Author:wangrui
 * @Date:2020/3/19 19:40
 */
/*
 * 功能描述:
 * @return 
 */
public class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next=null;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
