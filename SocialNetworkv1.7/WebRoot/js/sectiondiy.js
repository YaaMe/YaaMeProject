function resetTabs(){
	$(".sectiondiy > div").hide(); //隐藏所有内容
	$("#tabs a").attr("id",""); //重置“id”   
}

var myUrl = window.location.href; //取得超链地址
var myUrlTab = myUrl.substring(myUrl.indexOf("#")); 
var myUrlTabName = myUrlTab.substring(0,4);

(function(){
	$(".sectiondiy > div").hide(); // 最初隐藏所有内容
	$("#tabs li:first a").attr("id","current"); // 激活第一个选项卡
	$(".sectiondiy > div:first").fadeIn(); // 显示第一个选项卡的内容

	$("#tabs a").on("click",function(e) {
		e.preventDefault();
		if ($(this).attr("id") == "current"){ //检测当前选项卡
			return       
		}else{             
			resetTabs();
			$(this).attr("id","current"); // 激活这
			$($(this).attr('name')).fadeIn(); // 显示当前选项卡的内容
		}
	});

	for (i = 1; i <= $("#tabs li").length; i++) {
		if(myUrlTab == myUrlTabName + i){
			resetTabs();
			$("a[name='"+myUrlTab+"']").attr("id","current"); // 激活url选项卡
			$(myUrlTab).fadeIn(); // 显示url选项卡内容      
		}
	}
})()