package Map��Set;

import java.util.Set;
import java.util.Tree;
import java.util.TreeSet;

public class NumJeweIsInStones {
	 public int numJewelsInStones(String J,String S) {
		 //�����еı�ʯ����Set��
		 Set<Character>jewels=new TreeSet<>();
		 for(char j:J.toCharArray()) {
			 jewels.add(j);
		 }
		 //�������е�ʯͷ
		 int count=0;
		 for(char s:S.toCharArray()) {
			 if(jewels.contains(s)) {
				 count++;
			 }
		 }
		 return count;
	 }
}
