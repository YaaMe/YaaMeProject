package model;

import java.util.ArrayList;
import java.util.List;

import pojo.*;

//Matrix
public class Matrix {
	private List<Record> record;
	private UserDAO users=new UserDAO();
	private ArrayList<User> row=new ArrayList(),column=new ArrayList();
	private int[][] value;
	public Matrix(){};
	public Matrix(List<Record> record){
		this.record=record;
		User user;
		for(int i=0;i<record.size();i++){
			user=users.findById(record.get(i).getRecOri());
			if(!row.contains(user))
				row.add(user);
			user=users.findById(record.get(i).getRecDes());
			if(!column.contains(user))
				column.add(user);
			
		}
		value=new int[row.size()][column.size()];
		for(int i=0;i<record.size();i++)
			value[row.indexOf(users.findById(record.get(i).getRecOri()))][column.indexOf(users.findById(record.get(i).getRecDes()))]=record.get(i).getRecValue();
		
		
	}
	public List getRow(){
		return row;
	}
	public List getRow(User row){
		List list=new ArrayList();
		if(!this.row.contains(row))
			return null;
		else{
			for(int i=0;i<value[this.row.indexOf(row)].length;i++)
				list.add(value[this.row.indexOf(row)][i]);
			return list;
		}
	}
	public List getColumn(){
		return column;
	}
	public List getColumn(User column){
		List list=new ArrayList();
		if(!this.column.contains(column))
			return null;
		else{
			for(int i=0;i<value[this.column.indexOf(column)].length;i++)
				list.add(value[i][this.column.indexOf(column)]);
			return list;
		}
	}
	public Integer getValue(User row,User column){
		if(!row.equals(column))
			return value[this.row.indexOf(row)][this.column.indexOf(column)];
		else
			return null;
	}
	public String toString(){
		String str="  ";
		for(int i=0;i<column.size();i++){
			str+=column.get(i).getUName()+" ";
		}
		
		for(int i=0;i<row.size();i++){
			str+="\n";
			str+=row.get(i).getUName()+" ";
			for(int j=0;j<column.size();j++){
				str+=value[i][j]+" ";
			}		
		}
		return str;
	}
	public String toHtml(){
		String str="<li style=\"display: none;\"><table cellspacing=\"1\" cellpadding=\"2\" width=\"90%\" align=\"center\" border=\"1\">";
		str+="<caption align=\"top\">矩阵图(行为记录发起人，列为记录接收人)</caption>";
		str+="<tr>";
		str+="<td></td>";
		for(int i=0;i<column.size();i++){
			str+="<td>"+column.get(i).getUName()+"</td>";
		}
		str+="</tr>";
		for(int i=0;i<row.size();i++){
			str+="<tr>";
			str+="<td>"+row.get(i).getUName()+"</td>";
			for(int j=0;j<column.size();j++){
				str+="<td>"+value[i][j]+"</td>";
			}
			str+="</tr>";
		}
		str+="</table></li>";
		return str;
	}
	public Integer countsDes(User row){
		int counts=0;
		if(!this.row.contains(row))
			return 0;
		else{
			for(int i=0;i<value[this.row.indexOf(row)].length;i++)
				if(value[this.row.indexOf(row)][i]!=0)
					counts++;
			return counts;
		}
	}
	public Integer countsOri(User column){
		int counts=0;
		if(!this.column.contains(column))
			return 0;
		else{			
			for(int i=0;i<value.length;i++){
				if(value[i][this.column.indexOf(column)]!=0)
					counts++;
			}
			return counts;
		}
	}
	
}
