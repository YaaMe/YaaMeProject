package divhtml;
import java.util.ArrayList;
import java.util.List;

import model.Matrix;

import pojo.*;
import function.*;
public class Test {
	public static void main(String []args){
		UserDAO udao=new UserDAO();
		User F=udao.findById("20010005");
		User H=udao.findById("20010007");
		MostFinder find=new MostFinder();
		RecordMatrix records=new RecordMatrix();
		List<Record> rec=records.getValueIn(F.getFriendList());
		System.out.println("::"+rec.size());
		Matrix matrix=new Matrix(records.getValueIn(F.getFriendList()));
		System.out.println(matrix.toString());
		System.out.println("==========");
		matrix=new Matrix(records.getAll());
		System.out.println(matrix.toString());
//		List<User> list=find.getMostPopular(records.getValueIn(F.getFriendList()));
//		System.out.println(list.size());
	}
}
