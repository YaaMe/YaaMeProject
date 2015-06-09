package divhtml;

import java.util.List;

import pojo.User;
import pojo.UserDAO;

public class UserListType {
	public String getUserListHtml(){
		UserDAO udao=new UserDAO();
		List<User> users=udao.findAll();
		String str="<li style=\"display: list-item;\">" +
				"<button class=\"orange\">������������ϴ�ҳ</button>"+
				"<table cellspacing=\"1\" cellpadding=\"2\" width=\"90%\" align=\"center\" border=\"0\">";
		str+="<tr>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">�˺�</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">����</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">����</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">�Ա�</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">����</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">סַ</td>" +
		"</tr>";
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			String sex="��";
			if(user.getUSex().toString().contains("F"))
				sex="Ů";
			str+="<tr>";
			str+="<td class=\"td_bg\">"+user.getUId()+"</td>";
			str+="<td class=\"td_bg\">"+user.getUPassword()+"</td>";
			str+="<td class=\"td_bg\">"+user.getUName()+"</td>";
			str+="<td class=\"td_bg\">"+sex+"</td>";
			str+="<td class=\"td_bg\">"+user.getUAge()+"</td>";
			str+="<td class=\"td_bg\">"+user.getUAdd()+"</td>";
			str+="</tr>";
		}
		str+="</table></li>";
		return str;
	}
}
