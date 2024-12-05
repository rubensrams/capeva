package mx.com.sistema.cap.constantes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Constantes {
	
	private static final Logger LOGGER = LogManager.getLogger(Constantes.class);
	
	public static final String VALOR_VACIO="";
	
	public static final String ERROR="Error";
	public static final String AVISO="Aviso";
	public static final String ESPACIO=" ";
	
	public static final int ACTIVACION=1;

	
	public static final String EXP_NUMS="^-?\\d+(\\.\\d+)?$";
	public static final String EXP_NUMS_DEC="(^[0-9]{1,3}$|^[0-9]{1,3}\\.[0-9]{1,3}$)";
	
	public static final String PAU_VALIDATION_REGEXP_LETRAS = "^[a-zA-Z]*$";	
	public static final String PAU_VALIDATION_REGEXP_LETRAS_NUMBER = "^[a-zA-Z0-9]+$";
	
	
	public static final String EXP_ANIO="^\\d{4}(,?\\d{4})*(\\.\\d{1,2})?$";
	
	public static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String RFC_REGEX = "[A-Z]{4}[0-9]{6}[A-Z0-9]{3}";
	public static final String CELULAR_REGEX="^\\d{10}(,?\\d{10})*(\\.\\\\d{1,2})?$";
	
	
	
	public static List<String> listaAnios(Date fechaInicio) {

		Calendar calendar = Calendar.getInstance();
		List<String> years = new ArrayList<String>();

		calendar.setTime(fechaInicio);

		for (int i = 0; i < 4; i++) {
			years.add(String.valueOf(calendar.get(Calendar.YEAR)));
			calendar.add(Calendar.YEAR, -1);
		}
		return years;
	}
	

	
	}


