    PrimeFaces.locales['es'] = {
        closeText: 'Cerrar',
        prevText: 'Anterior',
        nextText: 'Siguiente',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
        weekHeader: 'Semana',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        timeOnlyTitle: 'Sólo hora',
        timeText: 'Tiempo',
        hourText: 'Hora',
        minuteText: 'Minuto',
        secondText: 'Segundo',
        millisecondText: 'Milisegundo',
        currentText: 'Fecha actual',
        ampm: false,
        month: 'Mes',
        week: 'Semana',
        day: 'Día',
        allDayText: 'Todo el día',
        today: 'Hoy',
        clear: 'Claro'
    };
   
   
   function tuesdaysAndFridaysDisabled(date){
	  	var day = date.getDay();
	  	return [(day != 6 && day != 7), '']
	}
	
	
	
function generaEstiloMenu(){
	
	var idMenu = localStorage.getItem('idMenuoBRA');
	
	switch (idMenu) {
		  case '1':
		  	var idSelCata = localStorage.getItem('idSelSegNiv');
		    $('#ulCata').addClass("collapse in");
		    
		    		switch (idSelCata) {
						  case '11':
						   $('#ulCata11').addClass("collapse in");
						  break;
						  case '12':
						  	$('#ulCata12').addClass("collapse in");
						  break;						  
						  case '13':
						  	$('#ulCata13').addClass("collapse in");
						  break;
						  case '14':
						  	$('#ulCata14').addClass("collapse in");
						  break;
						  case '15':
						  	$('#ulCata15').addClass("collapse in");
						  break;

						  default:
						    console.log(`Sorry, we are out of ${expr}.`);
						}								    		
		   break;
		  case '2':
		  	$('#ulPlane').addClass("collapse in");
		  break;
		  case '3':
			$('#ulLici').addClass("collapse in");
		   break;
		  case '4':
			$('#ulConf').addClass("collapse in");		   
			break;	
		  case '5':
			$('#ulCont').addClass("collapse in");		   
			break;	
		  case '6':
			$('#ulFirm').addClass("collapse in");		   
			break;	
		  case '7':
			$('#ulCons').addClass("collapse in");		   
			break;									   
		  default:
		   console.log('Sorry, we are out of ${idMenu}.');
	}
	
	var idSel = localStorage.getItem('idSelBRA');
	
	switch (idSel) {
		  case '41':
		  	document.getElementById('menuForm:pBconf1').classList.add("subrayado-menu");
		  break;
		  case '42':
		  	document.getElementById('menuForm:pBconf2').classList.add("subrayado-menu");
		  break;
		   case '43':
		  	document.getElementById('menuForm:pBconf3').classList.add("subrayado-menu");
		  break;
		  case '31':
		  	document.getElementById('menuForm:pBLici1').classList.add("subrayado-menu");
		  break;
		  case '32':
		   	document.getElementById('menuForm:pBLici2').classList.add("subrayado-menu");
		  break;		   
		  case '33':
		   	document.getElementById('menuForm:pBLici3').classList.add("subrayado-menu");
		  break;		   
		  case '34':
		   	document.getElementById('menuForm:pBLici4').classList.add("subrayado-menu");
		  break;		   
		  case '35':
		   	document.getElementById('menuForm:pBLici5').classList.add("subrayado-menu");
		  break;		   
		  case '36':
		   	document.getElementById('menuForm:pBLici6').classList.add("subrayado-menu");
		  break;		   
		  case '37':
		   	document.getElementById('menuForm:pBLici7').classList.add("subrayado-menu");
		  break;		   
		  case '21':
		   	document.getElementById('menuForm:pBPlane1').classList.add("subrayado-menu");
		  break;
		  case '22':
		   	document.getElementById('menuForm:pBPlane2').classList.add("subrayado-menu");
		  break;			  
		  case '11':
		   	document.getElementById('menuForm:pBCat11').classList.add("subrayado-menu");
		  break;		  
		  case '12':
		   	document.getElementById('menuForm:pBCat12').classList.add("subrayado-menu");
		  break;	
		  case '13':
		   	document.getElementById('menuForm:pBCat13').classList.add("subrayado-menu");
		  break;		  	  
		  case '14':
		   	document.getElementById('menuForm:pBCat14').classList.add("subrayado-menu");
		  break;		  	  
		  case '15':
		   	document.getElementById('menuForm:pBCat15').classList.add("subrayado-menu");
		  break;		  	  
		  case '16':
		   	document.getElementById('menuForm:pBCat16').classList.add("subrayado-menu");
		  break;		  	  
		  case '17':
		   	document.getElementById('menuForm:pBCat17').classList.add("subrayado-menu");
		  break;		  	  
		  case '18':
		   	document.getElementById('menuForm:pBCat18').classList.add("subrayado-menu");
		  break;		  	  
		  case '19':
		   	document.getElementById('menuForm:pBCat19').classList.add("subrayado-menu");
		  break;		  	  
		  case '20':
		   	document.getElementById('menuForm:pBCat20').classList.add("subrayado-menu");
		  break;	
		  case '51':
		  	document.getElementById('menuForm:pBCont1').classList.add("subrayado-menu");
		  break;	  	  
		  case '61':
		  	document.getElementById('menuForm:pBFirm1').classList.add("subrayado-menu");
		  break;		  	  	  
		  case '62':
		  	document.getElementById('menuForm:pBFirm2').classList.add("subrayado-menu");
		  break;		  	  	  
		  case '63':
		  	document.getElementById('menuForm:pBFirm3').classList.add("subrayado-menu");
		  break;	
		  case '71':
		  	document.getElementById('menuForm:pBCons1').classList.add("subrayado-menu");
		  break;
		  case '72':
		  	document.getElementById('menuForm:pBCons2').classList.add("subrayado-menu");
		  break;
		  case '73':
		  	document.getElementById('menuForm:pBCons3').classList.add("subrayado-menu");
		  break;
		  case '74':
		  	document.getElementById('menuForm:pBCons4').classList.add("subrayado-menu");
		  break;		  
		  default:
		   console.log('Sorry, we are out of ${idSel}.');
	}

}

function asignaIdMenu(id){
	 localStorage.setItem('idMenuoBRA', id);

}

function asignaSeleccionExt(id){
	 asignaIdMenu(3);
	 localStorage.setItem('idSelBRA', id);
}

function asignaSeleccion(id){
	 localStorage.setItem('idSelBRA', id);
}

function asignaSeleccionSegNivel(id){
	 localStorage.setItem('idSelSegNiv', id);
}


function cleanLocalStorage(){
	 localStorage.removeItem("idMenuoBRA");
	 localStorage.removeItem("idSelBRA");
	 localStorage.removeItem("idSelSegNiv");
}


