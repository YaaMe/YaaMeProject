package divhtml;
import java.util.List;

import pojo.*;
public class FriendsListType {
	public String getFriendListHtml(String id){
		UserDAO users=new UserDAO();
		User user=users.findById(id);
		List<User> friends=user.getFriendList();
		String str="<li style=\"display: none;\"><table cellspacing=\"1\" cellpadding=\"2\" width=\"90%\" align=\"center\" border=\"0\">";
		str+="<tr>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">�˺�</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">����</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">�Ա�</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">����</td>" +
		"</tr>";
		for(int i=0;i<friends.size();i++){
			User friend=friends.get(i);
			String sex="��";
			if(friend.getUSex().toString().contains("F"))
				sex="Ů";
			str+="<tr>";
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
