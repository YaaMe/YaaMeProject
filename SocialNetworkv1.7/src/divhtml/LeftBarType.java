package divhtml;

public class LeftBarType {
	public String adminHtml(){
		return  "<li><a href=\"#\" id=\"myList\" onclick=\"mainchoice()\">用户列表</a></li>" +
				"<li><a href=\"#\" id=\"myList\" onclick=\"mainchoice()\">我的联系人</a></li>" +
				"<li><a href=\"#\" id=\"findFriend\" onclick=\"mainchoice()\">最短路径</a></li>" +
				"<li><a href=\"#\" id=\"mostPopular\" onclick=\"mainchoice()\">最有影响力人物</a></li>" +
				"<li><a href=\"#\" id=\"myListbyPopular\" onclick=\"mainchoice()\">最活跃人物</a></li>" +
				"<li><a href=\"#\" onclick=\"openWin()\">全局图</a></li>";
	}
	public String userHtml(){
		return "<li><a href=\"#\" id=\"myList\" onclick=\"mainchoice()\">我的联系人</a></li>" +
		"<li><a href=\"#\" id=\"findFriend\" onclick=\"mainchoice()\">搜索用户</a></li>" +
		"<li><a href=\"#\" id=\"mostPopular\" onclick=\"mainchoice()\">我身边最有影响力的人物</a></li>" +
		"<li><a href=\"#\" id=\"myListbyPopular\" onclick=\"mainchoice()\">我身边最活跃的人物</a></li>" +
		"<li><a href=\"#\" id=\"myListbyPopular\" onclick=\"mainchoice()\">好友度排名</a></li>";
	}
}
