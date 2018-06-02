/**
 * 刷新窗口大小
 */
var winWidth = 0;
var winHeight = 0;
function findDimensions() // 函数：获取尺寸
{
	// 获取窗口宽度
	if (window.innerWidth)
		winWidth = window.innerWidth;
	else if((document.body) && (document.body.clientWidth))
		winWidth = document.body.clientWidth;
	// 获取窗口高度
	if (window.innerHeight)
		winHeight = window.innerHeight;
	else if((document.body) && (document.body.clientHeight))
		winHeight = document.body.clientHeight;
	/*
	// 通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement && document.documentElement.clientHeight
			&& document.documentElement.clientWidth) {
		winHeight = document.documentElement.clientHeight;
		winWidth = document.documentElement.clientWidth;
	}
	*/
}
$(function() {
	findDimensions();
	if ($("#dcRight").height() < (winHeight - 136)) {
		$("#dcRight").css("height", winHeight - 136);
		$("#dcLeft").css("height", $("#dcRight").height());
	} else {
		$("#dcLeft").css("height", $("#dcRight").height());
	}
	if (winWidth < (1050 / 0.84)) {
		$("#dcBody").css("width", 1250);
	} else if($("#dcRight").height() == (winHeight - 136)){
		$("#dcBody").css("width", winWidth);
	}else{
		$("#dcBody").css("width", winWidth-18);
	}
});

$(window).resize(function() {
	findDimensions();
	if (winWidth < (1050 / 0.84)) {
		$("#dcBody").css("width", 1250);
	} else if($("#dcRight").height() == (winHeight - 136)){
		$("#dcBody").css("width", winWidth);
	}else{
		$("#dcBody").css("width", winWidth-18);
	}
});