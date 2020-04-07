package ∆ﬂ¥Û≈≈–Ú;

import java.util.ArrayList;
import java.util.List;

interface SortMethod{
	/**
	 * 
	 * @return
	 */
	String getName();
	/**
	 * ≈≈–Úa
	 * @param a
	 */
	void sort(int[] a);
} 
class InsertSortMethod implements SortMethod{
	@Override
	public String getName() {
		return "≤Â»Î≈≈–Ú ";
	}
	
	@Override
	public void sort(int[] a) {
		Sort.insertSort0(a);
	}
}
public class Lab {
	List<Integer>list=new ArrayList<>();
	
	
	
}


