package function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import pojo.*;

public class testDijkstra {
	public static void main(String[] args){

		UserDAO users=new UserDAO();
		List<User> li=users.findAll();
//		for(int i=0;i<li.size();i++)
//			System.out.println(li.get(i).getUName());
		Dijkstra dij=new Dijkstra(li);
		User G=users.findById("20010006");
		User C=users.findById("20010002");
		User E=users.findById("20010004");
		User A=users.findById("20010000");
		User H=users.findById("20010007");
		User J=users.findById("20010009");
		User F=users.findById("20010005");
//		dij.pathLength();
		ArrayList<User> stack=dij.findTo(F,H);
		System.out.println("==:"+dij.getLength());
		if(stack!=null){
			int len=stack.size();
			System.out.println(stack.size());
			for(int i=0;i<len;i++)
				System.out.println(stack.get(i).getUName());
		}
		else
			System.out.println("null");
//		System.out.println(stack.size());
//		Set test=new TreeSet();
//		test.add(1);
//		test.add(6);
//		test.add(7);
//		test.add(3);
//		System.out.println(test.toString());
	}
}
