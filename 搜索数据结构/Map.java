package 搜索数据结构;

/**
 * @Author:wangrui
 * @Date:2020/3/19 19:35
 */
public interface Map<K,V> {
    V get(K key);
    V put(K key,V value);
}
