package pojo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//The Matrix base on table 'Record'
public class RecordMatrix extends BaseHibernateDAO{
	RecordDAO records;
	UserDAO users;
	public List getRow(User row){
		records=new RecordDAO();
		return records.findByRecOri(row.getUId());
	}
	
	public List getColumn(User column){
		records=new RecordDAO();
		return records.findByRecDes(column.getUId());
	}

	public Integer getValue(User row,User column){
		records=new RecordDAO();
		String[] propertyName={"recOri","recDes"};
		String[] values={row.getUId(),column.getUId()};
		List<Record> value=records.findByPropertys(propertyName, values);
		if(value.size()!=0)
		return value.get(0).getRecValue();
		else
		return 0;
	}
	
	public List getValueIn(User[] users){
		List list=new ArrayList();
		for(int i=0;i<users.length;i++){
			list.add(users[i].getUId());
		}
		records=new RecordDAO();
		return records.findIn(list);
	}
	public List<Record> getValueIn(List<User> users){
		records=new RecordDAO();
		return records.findIn(users);
	}
	public List<Record> getAll(){
		records=new RecordDAO();
		return records.findAll();
	}
}
