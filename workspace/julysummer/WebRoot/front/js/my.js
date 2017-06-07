var imgArr=["front/img/bg2.jpg","front/img/desert.jpg",
            "front/img/bg.jpg","front/img/rainbow.jpg",
            "front/img/bg3.jpg"];
var arr=[];
arr[0]="This is my first project for you!Don't ask me why,because of you";
arr[1]="出路出路，走出去了，总是会有路的。困难苦难，困在家里就是难。";
arr[2]="坚其志，苦其心，劳其力，事无大小，必有所成。";
arr[3]="路漫漫求修远兮,吾将上下而求索";
arr[4]="自己选择的路，跪着也要把它走完.";
arr[5]="每个人的一生都有许多梦想，但如果其中一个不断搅扰着你，剩下的就仅仅是行动了.";
arr[6]="走得最慢的人，只要他不丧失目标，也比漫无目的地徘徊的人走得快.";
arr[7]="有志者自有千计万计，无志者只感千难万难。";
arr[8]="有人说，世界上最美的是梦，最长的是路；最易做的是梦，最难走的是路。";
arr[9]="你若不离，我便不弃！我的Zone需要你的常来....我...是Forrest！！！一位90后，";
arr[10]="热爱工作，投身事业，在这一过程中，抑制私心，陶冶人格，同时积累经验，提高能力。这样，才能获得周围人们的信任和尊敬。";
arr[11]="我不去想，是否能够成功。既然选择了远方，便只顾风雨兼程。";
arr[13]="保持自身的个性和尊重别人的个性同样重要。";
arr[14]="劝君莫惜金缕衣。劝君惜取少年时。有花堪折直须折，莫待无花空折枝。";
arr[15]="三更灯火五更鸡，正是男儿读书时。黑发不知勤学早，白首方悔读书迟。";
var lightArr=["#32b9b1","#51be38", "#5bc0de"," #ef9544","#f05a5b","#bbbbbb"];

var wordi=-1;
var pageAllCount=0;
$(document).ready(function(){
	setInterval(aboutScroll,500);
	setInterval(changebackround,9000);
	setInterval(changeWords,9000);
	setInterval(showTime,1000);
	$.get("loadMore?pageSize=pagesize",function(load){
		pageAllCount=load;
		//alert(pageAllCount);
	});
});
var pageCount=2;
function loadMore(){
	if(pageCount<=pageAllCount){
	 $.get("loadMore?start="+(6*pageCount),function(loaded){
			$('#getMore').append(loaded);
		});
	 pageCount++;
	}else{
		alert("已加载全部")
	}
}
/*与滚动条相关的动作函数*/
function aboutScroll(){
		var navdft=document.getElementsByClassName('navbar-inverse')[0];
		var nav=document.getElementById('nav1');
		var totopshow=document.getElementById("gotop");
		var offsetHeight=$(document).scrollTop(); //document.body.scrollTop;
	if(offsetHeight>=401){	
			nav.style.position="fixed";
			nav.style.top="0";
			nav.style.zIndex="1000";
			nav.style.width="100%";
			navdft.style.backgroundColor="rgba(0,0,0,0.6)";
			navdft.style.borderBottom="solid 1px white";
		}else{
			nav.style.position="inherit";
			navdft.style.backgroundColor="#555555";
		}
		if(offsetHeight>400){
			totopshow.style.display="block";
			totopshow.style.position="fixed";
		}
		else{
			//totopshow.style.display="none";
			$('#gotop').fadeOut();
			totopshow.style.transition="ease-in-out all 1s";
			totopshow.style.transform="translateY(140px)";
		};
		
}

/*更换内容*/
function changeWords(){
    wordi++;
    if(wordi==16){
        wordi=-1;
    }
    $('#wordchange').text(arr[wordi]).fadeIn();
}
/*slow up to top*/
function flytotop(){
		var totopshow=document.getElementById("gotop");
	totopshow.style.transition="ease-in-out all 2s";
	totopshow.style.transform="translateY(-300px)";
	$('html,body').animate({scrollTop: '0px'},2000);return false;
} 
/*show log or hid log*/
function showsearch(){//按下 打开搜索表单按钮
	$('#showsearch').css("display","none");			//隐藏 打开搜索表单按钮
	$('#search').css("display","block");		//显示搜索表单
	$('#hidesearch').css("display","block");	//显示 关闭搜索表单按钮
}
function hidesearch(){//按下 关闭搜索表单按钮
	$('#showsearch').css("display","block"); //显示 打开搜索表单按钮
	$('#search').css("display","none");				//隐藏搜索表单
	$('#hidesearch').css("display","none");			//隐藏 关闭搜索表单 按钮
}
/*
 * 改变背景
 */
var c=imgArr.length;
function changebackround(){
    c--;
    if(c==-1){c=imgArr.length;}
    else{
    $('#changeimg').attr("src",imgArr[c]);
    }
}

var d=lightArr.length;
var bc=imgArr.length;
function changebimg(){
	bc--;
	d--;
    if(bc==-1){bc=imgArr.length;}
    else{
     $('#bimg').attr("src",imgArr[bc]);
    }
    if(d==-1){
    	d=lightArr.length;
    }else{$('.mylight').css("backgroundColor",lightArr[d]);}
}
var bgco=-1;
function changebgcolor(){
	bgcolor=new Array();
	bgcolor[0]="#006666";bgcolor[1]="#00CC66";bgcolor[2]="#00FFFF";bgcolor[3]="#333300";bgcolor[4]="#6600CC";
	bgcolor[5]="#990000";bgcolor[6]="#FF00FF";bgcolor[7]="#FFFF66";bgcolor[8]="#99FFFF";bgcolor[9]="#5bbcd5";	
	bgco++;
	if(bgco>=bgcolor.length){bgco=0;}else{
		$('body').css("background-color",bgcolor[bgco]);
	}
}

/*时间*/
function showTime(){
    var date=new Date();
    var year=date.getFullYear();
    var month=date.getMonth()+1;
    var day=date.getDate();
    var hour=date.getHours();
    var minute=date.getMinutes();
    var second=date.getSeconds();
    if(hour>5&&hour<=8){document.getElementById('countTime').innerHTML="早早早安  ^_^！又是崭新的一天."+"<br>";}
    else if(hour>8&&hour<=11){document.getElementById('countTime').innerHTML="Hey  ^_^，上午好！"+"<br>";}
    else if(hour>11&&hour<=13){document.getElementById('countTime').innerHTML="hi ^_^，中午好！奋斗中！"+"<br>";}
    else if(hour>13&&hour<=17){document.getElementById('countTime').innerHTML="^_^ 下午好！为梦想依旧奋斗中！"+"<br>";}
    else{document.getElementById('countTime').innerHTML="天黑了，忙了一天了，放松放松自己吧^_^！"+"<br>";}
    document.getElementById('countTime').innerHTML+=year+"年"+month+"月"+day+"日"+"<br>"+hour+"点"+minute+"分"+second+"秒"; 
}

/*tag切换*/
 function newsType(rd){
 	$('.type').css({"backgroundColor":"#222"});
 	$(rd).css({"backgroundColor":"#00ff7f"});
 }

/*加入收藏*/
 function addFavorite(){
 	var fURL="http://localhost:8080/julysummer/";
 	var fTitle="forrestYuan的个人博客";
 	try{
 		window.external.AddFavorite(fURL,fTitle);
 	}catch(e){
 		try{
 			window.sidebar.addPanel(fTitle,fURL);
 		}catch(error){
 			alert("加入收藏夹失败,请用Crtl+D 或手动收藏");
 		}
 	}
 }

 document.getElementById("addFavorite").onclick=function(){
 	addFavorite();
 }