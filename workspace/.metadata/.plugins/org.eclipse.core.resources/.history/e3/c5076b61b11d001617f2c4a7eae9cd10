/**
 * Created by YFC on 2015/7/9.
 */
function saveStorage(id){
    var data=document.getElementById(id).value;
    var time=new Date().getTime();
    var st=isNull(data);
      if(st){alert("评论内容不能为空哦！");}else{
		   
		    alert("已发表");
 
		    localStorage.setItem(time,data);
		    loadStorage('msg');
      }
/*判断字符串是否为空或者全部都是空格*/		 	
function isNull( str ){
	if ( str == "" ) return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}
/**----------**/
}
function loadStorage(id){
    var rese='<table border="1" style="width:100%;">';
    var name=["骇客帝国","平行天子","德玛西亚","蛮族之王","无敌剑圣","寒冰射手","神枪游侠","大嘴","瑞文","德莱文","熔岩巨兽","恐龙","第六空间"];
    for(var i=0;i<localStorage.length;i++)
    {   
        var keys=localStorage.key(i);
        var value=localStorage.getItem(keys);
        var date=new Date();
        date.setTime(keys);
        var datestr=date.toGMTString();
        var j=Math.ceil(Math.random()*12);
        rese+='<tr><td>'+"<span style='color:#336699'>"+name[j]+"</span>"+'发表评论：</td><td>'+value+'</td><td>'+datestr+'</td></tr>';
    	
     }
    rese+='</table>';
    var target=document.getElementById(id);
    target.innerHTML=rese;
}
/*删除功能待启用*/
			
	//  localStorage.clear();
         //  alert("数据成功删除");
         //  loadStorage('msg');

