package divhtml;

public class ShortestFindType {
	public String getShortestFindHtml(){
		return "<li style=\"display: none;\"><table>" +
		"<tr>"+
		"<td><input type=\"text\" name=\"starter\" id=\"starter\" placeholder=\"起点\"></td>"+
		"<td><input type=\"text\" name=\"ender\" id=\"ender\" placeholder=\"终点\"></td>"+
		"<td><button class=\"orange\" onclick=\"adminFindSubmit()\">开始寻找</button></td>"+
		"</tr>"+
		"</table>" +
		"<div id=\"adminfindout\"></div></li>"+
		"<script type=\"text/javascript\">"+
		"  function adminFindSubmit () {"+
		"    $.ajax({"+
		"      type:\"post\","+
		"      url:\"adminFind.do\","+
		"      async:\"false\","+
		"      data:{"+
		"      starter:$(\"#starter\").val(),"+
		"      ender:$(\"#ender\").val()"+
		"      },"+
		"      success:function(data){"+
		"        $(\"#adminfindout\").html(data);"+
		"      }"+
		"      });"+
		"    "+
		"  }"+
		"</script>";
	}
	public String getFindHtml(){
		return "<li style=\"display: none;\"><table>" +
		"<tr>"+
		"<td><input type=\"text\" name=\"ufind\" id=\"ufind\" placeholder=\"你想寻找的人是？\"></td>"+
		"<td><button class=\"orange\" onclick=\"adminFindSubmit()\">开始寻找</button></td>"+
		"</tr>"+
		"</table>" +
		"<div id=\"userfindout\"></div></li>"+
		"<script type=\"text/javascript\">"+
		"  function adminFindSubmit () {"+
		"    $.ajax({"+
		"      type:\"post\","+
		"      url:\"userFind.do\","+
		"      async:\"false\","+
		"      data:{"+
		"      ufind:$(\"#ufind\").val()"+
		"      },"+
		"      success:function(data){"+
		"        $(\"#userfindout\").html(data);"+
		"      }"+
		"      });"+
		"    "+
		"  }"+
		"</script>";
	}
}
