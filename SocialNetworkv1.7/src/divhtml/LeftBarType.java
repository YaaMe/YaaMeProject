package divhtml;

public class LeftBarType {
	public String adminHtml(){
		return  "<li><a href=\"#\" id=\"myList\" onclick=\"mainchoice()\">�û��б�</a></li>" +
				"<li><a href=\"#\" id=\"myList\" onclick=\"mainchoice()\">�ҵ���ϵ��</a></li>" +
				"<li><a href=\"#\" id=\"findFriend\" onclick=\"mainchoice()\">���·��</a></li>" +
				"<li><a href=\"#\" id=\"mostPopular\" onclick=\"mainchoice()\">����Ӱ��������</a></li>" +
				"<li><a href=\"#\" id=\"myListbyPopular\" onclick=\"mainchoice()\">���Ծ����</a></li>" +
				"<li><a href=\"#\" onclick=\"openWin()\">ȫ��ͼ</a></li>";
	}
	public String userHtml(){
		return "<li><a href=\"#\" id=\"myList\" onclick=\"mainchoice()\">�ҵ���ϵ��</a></li>" +
		"<li><a href=\"#\" id=\"findFriend\" onclick=\"mainchoice()\">�����û�</a></li>" +
		"<li><a href=\"#\" id=\"mostPopular\" onclick=\"mainchoice()\">���������Ӱ����������</a></li>" +
		"<li><a href=\"#\" id=\"myListbyPopular\" onclick=\"mainchoice()\">��������Ծ������</a></li>" +
		"<li><a href=\"#\" id=\"myListbyPopular\" onclick=\"mainchoice()\">���Ѷ�����</a></li>";
	}
}
