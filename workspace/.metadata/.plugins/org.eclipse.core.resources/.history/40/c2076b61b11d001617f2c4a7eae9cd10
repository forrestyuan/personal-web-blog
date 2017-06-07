
/*-------------------以下为超大屏内容更换区域-----------------------*/
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


var i=-1;
window.onload=function(){
	$(function(){
		showScroll();
		function showScroll(){
			$(window).scroll( function() { 
				var scrollValue=$(window).scrollTop();
				scrollValue > 100 ? $('div[class=scroll]').fadeIn():$('div[class=scroll]').fadeOut();
			} );	
			$('#scroll').click(function(){
				$("html,body").animate({scrollTop:0},200);	
			});	
		}
	});
    setInterval(changeWords,4000);
    setInterval(showTime,1000);
};
function changeWords(){
    i++;
    if(i==16){
        i=-1;
    }
    $(zuoYouMing).text(arr[i]);
}


function showTime(){
    var date=new Date();
    var year=date.getFullYear();
    var month=date.getMonth()+1;
    var day=date.getDate();
    var hour=date.getHours();
    var minute=date.getMinutes();
    var second=date.getSeconds();
    if(hour>5&&hour<=8){document.getElementById('countTime').innerHTML="早上好！又是崭新的一天."+"<br>";}
    else if(hour>8&&hour<=10){document.getElementById('countTime').innerHTML="上午好！"+"<br>";}
    else if(hour>10&&hour<=13){document.getElementById('countTime').innerHTML="中午好！奋斗中！"+"<br>";}
    else if(hour>13&&hour<=17){document.getElementById('countTime').innerHTML="下午好！为梦依旧奋斗中！"+"<br>";}
    else{document.getElementById('countTime').innerHTML="天黑了休息吧！"+"<br>";}
    document.getElementById('countTime').innerHTML+=year+"年"+month+"月"+day+"日"+"<br>"+hour+"点"+minute+"分"+second+"秒"; 
}

function searchgo(){
   var seatx=document.getElementById('search-tx');
	 var seabt=document.getElementById('search-bt');
	 var sear=document.getElementById('sea');
	 sear.style.display="none";
	seatx.style.display="inline-block";
	seatx.placeholder="输入搜索";
	seabt.style.display="inline-block";
}

/*
 * web添加内容
 */
function addInfomation(){
	/*<div class="content"><a href="#"><img src="img/sec6.jpg"></a></div>添加的div结构*/
	for(var i=0;i<12;i++)
	{
		var parent=document.getElementById('xiangmu');
		
		var fig=document.createElement('figure');
			
			
		var figcap=document.createElement('figcaption');
		
		var img=document.createElement('img')
			img.src="images/z-type-470x240.jpg";
			//img.innerHTML="<img>";
			img.style.display="inline-block";

			
			
		var oa1=document.createElement('a');
			oa1.setAttribute('href','');
			//oa1.innerHTML="<a></a>";
		
		oa1.appendChild(img);
		

		figcap.innerHTML="<a href='http://www.webhek.com/misc/z-type'>HTML5技术精品：盲打高手打飞字</a><br>打飞字(Z-Type)这是有史以来最酷的一款练习盲打的游戏。视觉效果、射击爆破效果和声音效果都非常的刺激。这款游戏是用HTML5做成的，曾经获得Mozilla Game On游戏大赛的Community Choice Award大奖玩家可以选择关闭游戏音效，轻按ESC按键便可以暂停游戏.;";
		

		fig.appendChild(oa1);

		fig.appendChild(figcap);

		fig.style.margin="4px";
		fig.style.height="380px";
		fig.style.position="relative";
		parent.appendChild(fig);

	
	}
	
}

function offadver(){
		var off=document.getElementById('ad');
		off.style.display="none";
}