package Map和Set;
//面试题：给一非空的单词列表，返回前k个出现次数最多的单词，返回的答案应该按单词出现频率由高到低，如果不同的单词有相同的出现频率， 按字母顺序排序 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Topk {
	public static Map<String,Integer>calcCount(String[] words){
		Map<String,Integer>map=new HashMap<>();
		for(String w:words) {
			int count=map.getOrDefault(w,0);
			map.put(w,count+1);
		}
		return map;
	}
	public static Map<Integer,List<String>>calcCountOfWords(Map<String,Integer>map){
		Map<Integer,List<String>>ret=new HashMap<>();
		for(Map.Entry<String,Integer>e:map.entrySet()) {
			String word=e.getKey();
			int count=e.getValue();
			if(!ret.containsKey(count)) {
				ret.put(count,new ArrayList<>());
			}
			ret.get(count).add(word);
		}
		return ret;
	}
	private static class IntegerComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO 自动生成的方法存根
			return o2-o2;
		}
		
	}
	public static void main(String[] args) {
		String[] words= {"the","day","is","sunny","the","is","the","the","is","sunny","is"};
		int k=3;
		Map<String,Integer>wordCount=calcCount(words);
		System.out.println(wordCount);
		Map<Integer,List<String>>countToWordList=calcCountOfWords(wordCount);
		System.out.println(countToWordList);
		Set<Integer>counts=countToWordList.keySet();
		System.out.println(counts);
		List<Integer> countsList=new ArrayList<>(counts);
		Collections.sort(countsList,new IntegerComparator());
		System.out.println(countsList);
		List<String>result=new ArrayList<>();
		int n=0;
		int i=0;
		while(n<k) {
			int count=countsList.get(i);
			i++;
			List<String>ws=countToWordList.get(count);
			Collections.sort(ws);
			if(ws.size()<=k-n) {
				//如果候选人数量小于要需要人数，全部录取
				result.addAll(ws);
				n+=ws.size();
			}else {
				//否则，只录取需要人数，
				result.addAll(ws.subList(0,k-n));
				k+=(k-n);
			}
		}
		System.out.println(result);
	}
}
