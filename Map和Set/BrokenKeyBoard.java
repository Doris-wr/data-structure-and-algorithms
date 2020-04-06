package Map和Set;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//面试题：旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现，现在给出应该输入的一段文字，以及实际被输入的文字，请列出坏掉的那些键
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
