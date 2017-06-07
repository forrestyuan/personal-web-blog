
function playmusic(music){
	    //获得放置播放界面的位置容器
		var place=document.getElementById('placeforaudio');
		place.innerHTML="";
		var tips=document.getElementById('tips');
		//获得要播放的歌曲
		var mysong=music.innerHTML; 
		tips.innerHTML="正在播放:"+mysong;
		//创建audio
		var audio=document.createElement('audio');
		//设置audio属性
		audio.setAttribute('preload','auto');
		audio.setAttribute('autoplay','autoplay');
		audio.setAttribute('controls','controls');
		audio.src="music/"+mysong;
		//创建换行
		var br=document.createElement('br');
		alert(mysong);
		place.appendChild(br);
		place.appendChild(audio);	
};

function showSongsList(){
	var show=document.getElementById('songs-list');
	var btnClose=document.getElementById('listClose');
	var btnOpen=document.getElementById('listOpen');
	btnOpen.style.display="none";
	btnClose.style.display="inline";
	show.style.display="inline-block";
};

function closeSongsList(){
	var show=document.getElementById('songs-list');
	var btnClose=document.getElementById('listClose');
	var btnOpen=document.getElementById('listOpen');
	show.style.display="none";
	btnOpen.style.display="inline";
	btnClose.style.display="none";
	
}
