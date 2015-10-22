<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>HTML5 MediaElement</title>	
	
	<script src="/js/common/jquery.js"></script>	
	<script src="/js/media/mediaelement-and-player.min.js"></script>
	<link rel="stylesheet" href="/css/media/mediaelementplayer.min.css" />
</head>
<body>

<h1>MediaElementPlayer.js</h1>

<h2>1. Single MP4 File</h2>
<!-- simple single file method -->
<video width="640" height="360" src="/media/echo-hereweare.mp4" type="video/mp4" 
	id="player1" poster="/images/media/echo-hereweare.jpg" 
	controls="controls" preload="none"></video>
	
<span id="player1-mode"></span>

<h2>2. Multi-Codec with no JavaScript fallback player</h2>
<video width="640" height="360" id="player2" poster="/images/media/echo-hereweare.jpg" controls="controls" preload="none">
	<!-- MP4 source must come first for iOS -->
	<source type="video/mp4" src="/media/echo-hereweare.mp4" />
	<!-- WebM for Firefox 4 and Opera -->
	<source type="video/webm" src="../media/echo-hereweare.webm" />
	<!-- OGG for Firefox 3 -->
	<source type="video/ogg" src="../media/echo-hereweare.ogv" />
	<!-- Fallback flash player for no-HTML5 browsers with JavaScript turned off -->
	<object width="640" height="360" type="application/x-shockwave-flash" data="../build/flashmediaelement.swf"> 		
		<param name="movie" value="../build/flashmediaelement.swf" /> 
		<param name="flashvars" value="controls=true&amp;file=/media/echo-hereweare.mp4" /> 		
		<!-- Image fall back for non-HTML5 browser with JavaScript turned off and no Flash player installed -->
		<img src="/images/media/echo-hereweare.jpg" width="640" height="360" alt="Here we are" 
			title="No video playback capabilities" />
	</object> 	
</video>

<span id="player2-mode"></span>

<script>

$('audio,video').mediaelementplayer({
	//mode: 'shim',
	success: function(player, node) {
		$('#' + node.id + '-mode').html('mode: ' + player.pluginType);
	}
});

</script>

<input type="button" id="stopall" value="Stop all">

<script>
$('#stopall').click(function() {
    $('video, audio').each(function() {
          $(this)[0].player.pause();		  
    });
});
</script>


</body>
</html>