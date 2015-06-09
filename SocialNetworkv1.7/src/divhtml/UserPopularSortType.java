package divhtml;

import java.util.List;

import pojo.User;
import pojo.UserDAO;

public class UserPopularSortType {
	public String getFriendSortHtml(String id){
		UserDAO users=new UserDAO();
		User user=users.findById(id);
		List<User> friends=user.getFriendListByPopular();
		String str="<li style=\"display: none;\"><table cellspacing=\"1\" cellpadding=\"2\" width=\"90%\" align=\"center\" border=\"0\">";
		str+="<tr>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">排名</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">账号</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">名字</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">性别</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">年龄</td>" +
		"</tr>";
		for(int i=0;i<friends.size();i++){
			User friend=friends.get(i);
			String sex="男";
			if(friend.getUSex().toString().contains("F"))
				sex="女";
			str+="<tr>";
			str+="<td class=\"td_bg\">"+(i+1)+"</td>";
			str+="<td class=\"td_bg\">"+friend.getUId()+"</td>";
			str+="<td class=\"td_bg\">"+friend.getUName()+"</td>";
			str+="<td class=\"td_bg\">"+sex+"</td>";
			str+="<td class=\"td_bg\">"+friend.getUAge()+"</td>";
			str+="</tr>";
		}
		str+="</table></li>";
		return str;
	}
}
