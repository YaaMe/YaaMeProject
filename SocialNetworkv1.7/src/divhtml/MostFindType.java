package divhtml;

import java.util.List;

import pojo.RecordMatrix;
import pojo.User;
import pojo.UserDAO;
import function.*;
public class MostFindType {
	public String getMostPopular(){
		MostFinder finder=new MostFinder();
		RecordMatrix records=new RecordMatrix();
		List<User> users=finder.getMostPopular(records.getAll());
		String str="<li style=\"display: none;\"><p>";
		str+="�����û�������Ӱ������������:";
		if(users.size()>0){
			str+=users.get(0).getUName()+"("+users.get(0).getUId()+")";
			for(int i=0;i<users.size()-1;i++)
				str+="��"+users.get(0).getUName()+"("+users.get(0).getUId()+")";
		}
		str+="</p></li>";
		return str;
	}
	public String getMostPopular(String id){
		UserDAO udao=new UserDAO();
		User user=udao.findById(id);
		List<User> users=user.getMostPopular();
		String str="<li style=\"display: none;\"><p>";
		str+="�����ĺ���Ȧ������Ӱ������������:";
		if(users.size()>0){
			str+=users.get(0).getUName()+"("+users.get(0).getUId()+")";
			for(int i=0;i<users.size()-1;i++)
				str+="��"+users.get(i+1).getUName()+"("+users.get(i+1).getUId()+")";
		}
		str+="</p></li>";
		return str;
	}
	public String getMostVitality(){
		MostFinder finder=new MostFinder();
		RecordMatrix records=new RecordMatrix();
		List<User> users=finder.getMostVitality(records.getAll());
		String str="<li style=\"display: none;\"><p>";
		str+="�����û������Ծ��������:";
		if(users.size()>0){
			str+=users.get(0).getUName()+"("+users.get(0).getUId()+")";
			for(int i=0;i<users.size()-1;i++)
				str+="��"+users.get(0).getUName()+"("+users.get(0).getUId()+")";
		}
		str+="</p></li>";
		return str;
	}
	public String getMostVitality(String id){
		UserDAO udao=new UserDAO();
		User user=udao.findById(id);
		List<User> users=user.getMostVitality();
		String str="<li style=\"display: none;\"><p>";
		str+="�����ĺ���Ȧ�����Ծ��������:";
		if(users.size()>0){
			str+=users.get(0).getUName()+"("+users.get(0).getUId()+")";
			for(int i=0;i<users.size()-1;i++)
				str+="��"+users.get(i+1).getUName()+"("+users.get(i+1).getUId()+")";
		}
		str+="</p></li>";
		return str;
	}
}
