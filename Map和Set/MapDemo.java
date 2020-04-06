package Map和Set;

import java.util.Map;
import java.util.TreeMap;

import javax.sql.rowset.FilteredRowSet;

public class MapDemo {
	public static void main(String[] args) {
		Map<String,String>map=new TreeMap<>();
		System.out.println(map.get("汤老师"));
		System.out.println(map.getOrDefault("汤老师","查无此人"));
		String oldValue=map.put("汤老师","12345678");
		System.out.println(oldValue);
		oldValue=map.put("汤老师","999999");
		System.out.println(oldValue);
		map.put("张三","1232121");
		map.put("李四","5454534");
		map.put("王麻子","5676668");
		System.out.println(map.keySet());
		for(String key:map.keySet()) {
			System.out.println(key);
		}
		System.out.println(map.values());
		for(String value:map.values()) {
			System.out.println(value);
		}
		System.out.println(map.entrySet());
		for(Map.Entry<String,String>entry:map.entrySet()) {
			System.out.println(entry.getValue());
			System.out.println(entry.getValue());
		}
		System.out.println(map.containsKey("唐老师"));
		System.out.println("汤老师");
		System.out.println(map.containsValue("2222222"));
	}
}
