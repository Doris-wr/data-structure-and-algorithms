package Map��Set;

import java.util.Set;
import java.util.TreeSet;
public class SetDemo {
	public static void main(String[] args) {
		Set<String>bucket=new TreeSet<>();
		bucket.add("ƻ��");
		bucket.add("�㽶");
		bucket.add("����");
		bucket.add("ʯ��");
		bucket.add("����");
		System.out.println(bucket);
		System.out.println(bucket.size());
		System.out.println(bucket.add("����"));
		System.out.println(bucket);
		System.out.println(bucket.size());
		System.out.println(bucket.remove("ƻ��"));
		System.out.println(bucket);
		System.out.println(bucket.size());
		System.out.println(bucket.remove("������"));
		System.out.println(bucket);
		System.out.println(bucket.size());
		System.out.println(bucket.contains("�㽶"));
		bucket.clear();
		System.out.println(bucket);
		System.out.println(bucket.size());
	}
}
