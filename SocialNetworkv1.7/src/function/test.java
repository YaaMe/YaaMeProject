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

import model.Matrix;
import pojo.*;

public class test {
	public static void main(String[] args){
		UserDAO udao=new UserDAO();
		Dijkstra dij=new Dijkstra(udao.findAll());
		User finder=udao.findById("20010004");
		User g=udao.findById("20010000");
		List<User> d=dij.findTo(finder, g);
		System.out.println(d.size());
//		RecordDAO records=new RecordDAO();
//		Matrix mat=new Matrix(records.findAll());
//		System.out.println(mat.toString());
//		UserDAO users=new UserDAO();
//		List<User> li=users.findAll();
////		
////		
//////		for(int i=0;i<li.size();i++)
//////			System.out.println(li.get(i).getUName());
//		Dijkstra dij=new Dijkstra(li);
////		User G=users.findById("20010006");
//		User C=users.findById("20010002");
////		User E=users.findById("20010004");
////		User A=users.findById("20010000");
//		User H=users.findById("20010007");
////		User J=users.findById("20010009");
//////		dij.pathLength();
//		ArrayList<User> stack=dij.findTo(H,C);
//		System.out.println("==:"+dij.getLength());
//		if(stack!=null){
//			int len=stack.size();
//			System.out.println(stack.size());
//			for(int i=0;i<stack.size();i++){
//				System.out.println(stack.get(i).getUName());
//		}
//		else
//			System.out.println("null");
//		System.out.println(stack.size());
//		Set test=new TreeSet();
//		test.add(1);
//		test.add(6);
//		test.add(7);
//		test.add(3);
//		System.out.println(test.toString());
	}
}
