function caratula(){
		var cssNumCover = Math.floor(Math.random() * 3) + 1;
			var urlima= 'url(resources/css/plugins/images/caratulas/caratula'+cssNumCover+'.jpg) no-repeat center center / cover';
			 let classLoginImg = { background : urlima, 
								  height : '100%',
								  position: 'fixed'};
			$('#wrapper').css(classLoginImg);
}
