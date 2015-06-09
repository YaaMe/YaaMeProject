package divhtml;

import java.util.List;

import pojo.*;
import function.*;
public class FindOutType {
	public String getFindHtml(String starter,String ender){
		UserDAO udao=new UserDAO();
		Dijkstra dij=new Dijkstra(udao.findAll());
		User finder=udao.findById(starter);
		User goals=udao.findById(ender);
		List<User> list=dij.findTo(finder, goals);
		if(list.size()>0)
			return this.getFindHtml(list);
		else
			return "<p>路径无法建立</p>";
	}
	
	public String getFindHtml(List<User> users){
		String str="<li><table cellspacing=\"1\" cellpadding=\"2\" width=\"90%\" align=\"center\" border=\"0\">";
		str+="<tr>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">账号</td>" +
		"<td class=\"bg_tr\" width=16% height=\"23\">名字</td>" +
		"</tr>";
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			str+="<tr>";
			str+="<td class=\"td_bg\">"+user.getUId()+"</td>";
			str+="<td class=\"td_bg\">"+user.getUName()+"</td>";
			str+="</tr>";
		}
		str+="</table></li>";
		return str;
	}
}
