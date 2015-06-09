package divhtml;
import model.Matrix;
import pojo.*;
public class OutputType {
	public String adminHtml(String id){
		String output= "";
		UserListType userList=new UserListType();
		FriendsListType friendList=new FriendsListType();
		ShortestFindType shortest=new ShortestFindType();
		MostFindType mostfind=new MostFindType();
		RecordMatrix records=new RecordMatrix();
		Matrix matrix=new Matrix(records.getAll());
		output+=userList.getUserListHtml();
		output+=friendList.getFriendListHtml(id);
		output+=shortest.getShortestFindHtml();
		output+=mostfind.getMostPopular();
		output+=mostfind.getMostVitality();
		output+=matrix.toHtml();
		output+="<li style=\"display: none;\">基于图结构的社交网络分析系统的设计和实现。</br>最后更新于2015-5-23。</li>";
		return output;
	}
	public String userHtml(String id){
		String output= "";
		FriendsListType friendList=new FriendsListType();
		ShortestFindType shortest=new ShortestFindType();
		MostFindType mostfind=new MostFindType();
		UserPopularSortType sort=new UserPopularSortType();
		output+=friendList.getFriendListHtml(id);
		output+=shortest.getFindHtml();
		output+=mostfind.getMostPopular(id);
		output+=mostfind.getMostVitality(id);
		output+=sort.getFriendSortHtml(id);
		output+="<li style=\"display: none;\">基于图结构的社交网络分析系统的设计和实现。</br>最后更新于2015-5-23。</li>";
		return output;
	}
}
