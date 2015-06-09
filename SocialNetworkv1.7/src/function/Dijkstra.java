package function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.*;
public class Dijkstra {
	private List<Node> node_users=new ArrayList<Node>();
	private Map<User,Node> map=new HashMap<User,Node>();
	private Map<Node,ArrayList<User>> map_trace=new HashMap<Node,ArrayList<User>>();
	private List<Node> finded=new ArrayList<Node>();
	private List<Node> unfinded=new ArrayList<Node>();
	private int length=0;
	final int MAX=Integer.MAX_VALUE;
	//图形实例化
	public Dijkstra(List<User> users){
		RecordMatrix record_matrix=new RecordMatrix();
		for(int i=0;i<users.size();i++){//先将所有的user实例化成Node，写下映射。（不能使用new，地址不一样）
			User someone=users.get(i);
			Node node_someone=new Node(someone);
			node_users.add(node_someone);
			map.put(someone, node_users.get(node_users.size()-1));
		}
		//根据矩阵建立关系，绘成图。0次统计转为极大值
		for(int i=0;i<node_users.size();i++){//先遍历全部Node对象
			Node node_someone=node_users.get(i);
			User someone=node_someone.getUser();	
			List<User> someone_friend=someone.getFriendList();
			for(int j=0;j<someone_friend.size();j++){//每个Node对象的子节点值录入
				int value=record_matrix.getValue(someone,someone_friend.get(j));
				Node friend=node_users.get(node_users.indexOf(map.get(someone_friend.get(j))));
				node_someone.getChild().put(friend, value==0?MAX:value);
			}
			unfinded.add(node_someone);
		}
		

	}
	//根据头节点和尾节点，以贪心法遍历
	public ArrayList<User> findTo(User finder,User goals){
		ArrayList<User> trace=new ArrayList<User>();
		length=0;
		Node start=map.get(finder);//实例化头节点和尾节点
		Node end=map.get(goals);
		finded.add(start);//加入已遍历
		unfinded.remove(start);
		if(!unfinded.contains(end))
			return trace;
		else{
			Node node_now;
			Node node_find;
			User now=null;
			User nearest=null;
			
			List<User> now_list;
			int deep=0;
			while(!(finded.contains(end)||unfinded.isEmpty())){
				//贪心法的下一个加入点
				int min=MAX;
				for(int i=0;i<finded.size();i++){//从finded遍历friendlist
					trace=new ArrayList<User>();
					trace.add(start.getUser());
					now=finded.get(i).getUser();
					node_now=map.get(now);
					now_list=now.getFriendList();
					if(node_now!=start)
						if(map_trace.get(node_now)==null)
							trace.add(node_now.getUser());
						else{
							trace=new ArrayList<User>();
							trace.addAll(map_trace.get(node_now));//必须用addAll，不能直接传址
						}
					deep=0;
					for(int k=0;k<trace.size()-1;k++){
						deep+=map.get(trace.get(k)).getChild().get(map.get(trace.get(k+1)));
					}
					for(int j=0;j<now_list.size();j++){//从friendlist里遍历最小值
						node_find=map.get(now_list.get(j));
						if(node_now.getChild().get(node_find)!=null&&unfinded.contains(node_find)){
							if((deep+node_now.getChild().get(node_find))<min){

								min=deep+node_now.getChild().get(node_find);
								nearest=node_find.getUser();
								
								trace.add(nearest);
								map_trace.put(map.get(nearest),trace);
							}
						}
					}
				}
				if(!unfinded.contains(map.get(nearest))){
					map_trace.put(end, new ArrayList<User>());
					length=0;
					break;
				}
				finded.add(map.get(nearest));
				unfinded.remove(map.get(nearest));
				length=min;
			}
			return map_trace.get(end);
		}
	}
	public boolean init(){
		finded=new ArrayList<Node>();
		unfinded=new ArrayList<Node>();
		length=0;
		map_trace=new HashMap<Node,ArrayList<User>>();
		return true;
	}
	public int getLength(){
		return length;
	}
}
