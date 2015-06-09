package divhtml;

public class LoginType {
	public String loginHtml(String name){
		return " <ul class=\"nav navbar-nav pull-right\">" +
				"<li class=\"dropdown pull-right\">" +
				"<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">" +
				"<i class=\"icon-user\"></i> "+name+" <b class=\"caret\"></b></a>" +
						"<!-- Dropdown menu -->" +
						"<ul class=\"dropdown-menu\">" +
						"<li>" +
						"<a href=\"#\" data-toggle=\"modal\" data-target=\"#mypwdModal\">" +
						"<i class=\"icon-cogs\"></i> Settings</a>" +
						"</li>" +
						"<li><a href=\"index.jsp\"><i class=\"icon-off\"></i> Logout</a>" +
						"</li>" +
						"</ul>" +
						"</li>" +
						"</ul>";

	}
	public String unlogin(){
		return "0";
	}
}
