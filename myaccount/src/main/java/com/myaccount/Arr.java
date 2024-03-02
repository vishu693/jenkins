package com.myaccount;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Arr {public static void main(String[] args) {
	
	vishal();
}

public static void sartak()
{
	List<Integer> arr = new ArrayList<>();
	arr.add(1);
	arr.add(2);
	arr.add(3);
	arr.add(4);
	arr.add(5);
    for (int i = 0; i < arr.size(); i++) {
		if(arr.get(i) == 3) {
			arr.remove(i);
		}
	}
    System.out.println(arr);
}


public static void vishal()
{

CopyOnWriteArrayList<String> arr = new CopyOnWriteArrayList<>();
	arr.add("1");
	arr.add("2");
	arr.add("3");
	arr.add("4");
	arr.add("5");
	
	
	Iterator<String> it=arr.iterator();
	while (it.hasNext())
	{
		String val=it.next();
		if(val.equals("3"))
		arr.remove(val);
	}
	

}

}
