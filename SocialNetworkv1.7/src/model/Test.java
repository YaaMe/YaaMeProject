package model;

import pojo.RecordDAO;
import pojo.RecordMatrix;
import pojo.User;
import pojo.UserDAO;

public class Test {
	public static void main(String[] args){
		RecordDAO records=new RecordDAO();
		Matrix matrix=new Matrix(records.findAll());
		System.out.println(matrix.toString());
		UserDAO users=new UserDAO();
	}
}
