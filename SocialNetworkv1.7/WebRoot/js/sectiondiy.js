function resetTabs(){
	$(".sectiondiy > div").hide(); //������������
	$("#tabs a").attr("id",""); //���á�id��   
}

var myUrl = window.location.href; //ȡ�ó�����ַ
var myUrlTab = myUrl.substring(myUrl.indexOf("#")); 
var myUrlTabName = myUrlTab.substring(0,4);

(function(){
	$(".sectiondiy > div").hide(); // ���������������
	$("#tabs li:first a").attr("id","current"); // �����һ��ѡ�
	$(".sectiondiy > div:first").fadeIn(); // ��ʾ��һ��ѡ�������

	$("#tabs a").on("click",function(e) {
		e.preventDefault();
		if ($(this).attr("id") == "current"){ //��⵱ǰѡ�
			return       
		}else{             
			resetTabs();
			$(this).attr("id","current"); // ������
			$($(this).attr('name')).fadeIn(); // ��ʾ��ǰѡ�������
		}
	});

	for (i = 1; i <= $("#tabs li").length; i++) {
		if(myUrlTab == myUrlTabName + i){
			resetTabs();
			$("a[name='"+myUrlTab+"']").attr("id","current"); // ����urlѡ�
			$(myUrlTab).fadeIn(); // ��ʾurlѡ�����      
		}
	}
})()