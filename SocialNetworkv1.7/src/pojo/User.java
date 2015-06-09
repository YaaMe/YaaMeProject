package pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.Matrix;
import function.Dijkstra;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String UId;
	private String UPassword;
	private String UName;
	private String USex;
	private Integer UAge;
	private String UAdd;

	private Matrix matrix;
	private RecordMatrix record_matrix;
	private UserDAO users;
	
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String UId, String UPassword) {
		this.UId = UId;
		this.UPassword = UPassword;
	}

	/** full constructor */
	public User(String UId, String UPassword, String UName, String USex,
			Integer UAge, String UAdd) {
		this.UId = UId;
		this.UPassword = UPassword;
		this.UName = UName;
		this.USex = USex;
		this.UAge = UAge;
		this.UAdd = UAdd;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUSex() {
		return this.USex;
	}

	public void setUSex(String USex) {
		this.USex = USex;
	}

	public Integer getUAge() {
		return this.UAge;
	}

	public void setUAge(Integer UAge) {
		this.UAge = UAge;
	}

	public String getUAdd() {
		return this.UAdd;
	}

	public void setUAdd(String UAdd) {
		this.UAdd = UAdd;
	}

	// DIY functions
	public List<User> getFriendList(){
		record_matrix=new RecordMatrix();
		List<Record> list=record_matrix.getRow(this);
		users=new UserDAO();
		ArrayList<User> friend_list=new ArrayList<User>();
		
		for(int i=0;i<list.size();i++)
			friend_list.add(users.findById(list.get(i).getRecDes()));
		return friend_list;
	}
	public List<User> getFriendListByPopular(){
		List<User> list=this.getFriendList();
		List<User> ordered=new ArrayList();
		int length=list.size();
		for(int i=0;i<length;i++){
			//order list
			User user=this.getMaxValue(list);
			ordered.add(user);
			list.remove(user);
		}
		return ordered;
	}
	private User getMaxValue(List<User> users){
		RecordMatrix records=new RecordMatrix();
		Matrix matrix=new Matrix(records.getValueIn(this.getFriendList()));
		int counts=0;
		int min=Integer.MIN_VALUE;
		User user=new User();
		for(int i=0;i<users.size();i++){
			User friend=users.get(i);
			counts=matrix.getValue(this, friend)+matrix.getValue(friend, this);
			if(counts>min){
				min=counts;
				user=friend;
			}
		}
		return user;
	}
	
	public List<User> getMostPopular(){
		RecordMatrix records=new RecordMatrix();
		List<User> list=this.getFriendList();
		list.add(this);
		Matrix matrix=new Matrix(records.getValueIn(list));
		List<User> users=matrix.getRow();
		
		ArrayList<User> finded=new ArrayList<User>();
		int min=Integer.MIN_VALUE;
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			int countsOri=matrix.countsOri(user);
			if(countsOri==min)
				finded.add(user);
			else if(countsOri>min){
				finded.clear();
				finded.add(user);
				min=countsOri;
			}
		}
		return finded;
	}
	public List<User> getMostVitality(){
		RecordMatrix records=new RecordMatrix();
		List<User> list=this.getFriendList();
		list.add(this);
		Matrix matrix=new Matrix(records.getValueIn(list));
		List<User> users=matrix.getRow();
		System.out.println(matrix.toString());
		ArrayList<User> finded=new ArrayList<User>();
		int min=Integer.MIN_VALUE;
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			int countsDes=matrix.countsDes(user);
			if(countsDes==min)
				finded.add(user);
			else if(countsDes>min){
				finded.clear();
				finded.add(user);
				min=countsDes;
			}
		}
		return finded;
	}
	
	
	public ArrayList<User> goFind(User user){
		users=new UserDAO();
		Dijkstra find_function=new Dijkstra(users.findAll());
		return find_function.findTo(this, user);
	}
	
	
	//DIY find
//	private Stack<User> findFunction(Stack<User> stack,User user,int deep){
////		Stack<User> stack=new Stack<User>();
//		List<User> list=this.getFriendList();
//		stack.add(this);
//		if(deep==6){
//			stack.pop();
//			return stack;
//		}
//		else{
//			if(this.getFriendList().contains(user)){
//				stack.add(user);
//				return stack;
//			}
//			else{
//				for(int i=0;i<list.size();i++){
//					deep++;
//					stack=list.get(i).findFunction(stack,user,deep);
//					if(stack.contains(user))
//						break;
//				}
//				if(stack.contains(user))
//					return stack;
//				else{
//					stack.pop();
//					return stack;
//				}
//			}
//		}
//	}
}