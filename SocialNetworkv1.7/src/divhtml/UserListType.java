package divhtml;

import java.util.List;

import pojo.User;
import pojo.UserDAO;

public class UserListType {
	public String getUserListHtml(){
		UserDAO udao=new UserDAO();
		List<User> users=udao.findAll();
		String str="<li style=\"display: list-item;\">" +
				"<button class=\"orange\">点击进入批量上传页</button>"+
				"<table cellspacing=\"1\" cellpadding=\"2\" width=\"90%\" align=\"center\" border=\"0\">";
		str+="<tr>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">账号</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">密码</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">名字</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">性别</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">年龄</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">住址</td>" +
		"</tr>";
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			String sex="男";
			if(user.getUSex().toString().contains("F"))
				sex="女";
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
