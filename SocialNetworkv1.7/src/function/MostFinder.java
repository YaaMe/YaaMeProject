package function;

import java.util.ArrayList;
import java.util.List;

import model.*;
import pojo.*;
public class MostFinder {
	public List<User> getMostPopular(List<Record> records){
		Matrix matrix=new Matrix(records);
		UserDAO udao=new UserDAO();
		List<User> users=matrix.getColumn();
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
	
	public List<User> getMostVitality(List<Record> records){
		Matrix matrix=new Matrix(records);
		UserDAO udao=new UserDAO();
		List<User> users=matrix.getRow();
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
}
