package �ߴ�����;

import java.util.ArrayList;
import java.util.List;

interface SortMethod{
	/**
	 * 
	 * @return
	 */
	String getName();
	/**
	 * ����a
	 * @param a
	 */
	void sort(int[] a);
} 
class InsertSortMethod implements SortMethod{
	@Override
	public String getName() {
		return "�������� ";
	}
	
	@Override
	public void sort(int[] a) {
		Sort.insertSort0(a);
	}
}
public class Lab {
	List<Integer>list=new ArrayList<>();
	
	
	
}


