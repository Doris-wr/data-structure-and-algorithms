package Map��Set;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//�����⣺�ɼ����ϻ��˼���������������һ�����ֵ�ʱ�򣬶�Ӧ���ַ��Ͳ�����֣����ڸ���Ӧ�������һ�����֣��Լ�ʵ�ʱ���������֣����г���������Щ��
public class BrokenKeyBoard {
	   public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String right=scanner.nextLine();
		String wrong=scanner.nextLine();
		Set<Character>set=new TreeSet<>();
		for(char c:wrong.toCharArray()) {
			set.add(c);
		}
		Set<Character>written=new TreeSet<>();
		for(char c:right.toCharArray()) {
			if(!set.contains(c)) {
				c=Character.toUpperCase(c);
				if(!written.contains(c)) {
					System.out.println(c);
					written.add(c);
				}
			}
		}
		System.out.println();
	}
}
