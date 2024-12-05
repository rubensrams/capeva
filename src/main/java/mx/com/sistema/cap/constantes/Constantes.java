package mx.com.sistema.cap.constantes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Constantes {
	
	private static final Logger LOGGER = LogManager.getLogger(Constantes.class);
	
	public static final String VALOR_VACIO="";
	
	public static final String EXP_NUMS="^-?\\d+(\\.\\d+)?$";
	public static final String EXP_NUMS_DEC="(^[0-9]{1,3}$|^[0-9]{1,3}\\.[0-9]{1,3}$)";
	
	public static final String PAU_VALIDATION_REGEXP_LETRAS = "^[a-zA-Z]*$";	
	public static final String PAU_VALIDATION_REGEXP_LETRAS_NUMBER = "^[a-zA-Z0-9]+$";
	
	public static final String ESPACIO=" ";
	public static final String PUNTO=".";
	public static final String CODIGO_X= "XXXXX";
	
	public static final String ESTILO_NEGRITA_PDF_OPEN="<style isBold='true' fontName='Arial' size='9' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_SUBRAYADO_OPEN="<style isUnderline='true' isBold='true' fontName='Arial' size='9' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_8_SUBRAYADO_OPEN="<style isUnderline='true' isBold='true' fontName='Arial' size='8' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_8_OPEN="<style isBold='true' fontName='Arial' size='8' pdfFontName='tahomabd.ttf'>";
	
	public static final String ESTILO_NEGRITA_PDF_OPEN_BROWN="<style isBold='true' forecolor='#4A000B' fontName='Arial' size='9' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_OPEN_10PX_BROWN="<style isBold='true' forecolor='#4A000B' fontName='Arial' size='10' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_OPEN_6PX="<style isBold='true' fontName='Arial' size='6' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_OPEN_7PX="<style isBold='true' fontName='Arial' size='7' pdfFontName='tahomabd.ttf'>";
	public static final String ESTILO_NEGRITA_PDF_CLOSE="</style>";
	
	public static final String EXP_ANIO="^\\d{4}(,?\\d{4})*(\\.\\d{1,2})?$";
	
	public static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String RFC_REGEX = "[A-Z]{4}[0-9]{6}[A-Z0-9]{3}";
	public static final String CELULAR_REGEX="^\\d{10}(,?\\d{10})*(\\.\\\\d{1,2})?$";
	
	public static final int ACTIVACION_EXP_TECNICO=1;
	public static final String EXCEL_POA="POA_";
	public static final String EXP_TEC="EXPTEC_";
	public static final int ACTIVACION=1;
	public static final int ESTATUS_2=2;
	public static final int ID_GANADOR=1;
	public static final int PADRE_PARTIDA=0;
	public static final int HIJA_PARTIDA=1;
	public static final int DESACTIVACION=0;
	public static final boolean BANDERA_TRUE=true;
	public static final boolean BANDERA_FALSE=false;
	public static final int CERRADA_EN_CONVOCATORIA=2;
	public static final int PRESUPUESTO_BASE_CERRADO=1;
	public static final int PRESUPUESTO_BASE_ABIERTO=0;
	public static final int PRESUPUESTO_BASE_MIN_EMPRESAS=2;
	public static final int PRESUPUESTO_BASE_MAX_EMPRESAS=3;
	public static final int ESTATUS_ACLARACION_FINALIZADO=1;
	public static final int ESTATUS_BASES_ADJ_FINALIZADO=1;
	public static final int ESTATUS_FALLO_FINALIZADO=1;
	public static final int ID_ZERO=0;
	public static final String ID_STRING_ZERO="0";

	public static final String PAU_VALIDATOR_EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[-_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String PAU_VALIDATOR_PATTERN_RFC_13 = "^(([A-Z]|[a-z]|/s){1})(([A-Z]|[a-z]){3})(([0-9]{2})([0]{1}[1-9]{1}|[1]{1}[0,1,2]{1})([0]{1}[1-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-9]{1}|[3]{1}[0,1]{1}))(([A-Z,a-z,0-9,ñ,Ñ]{1})([A-Z,a-z,0-9,ñ,Ñ]{1})([A-Z,a-z,0-9,ñ,Ñ]{1}))$";
	public static final String PAU_MESSAGES_FIELD_INVALID_CORREO = "Correo electrónico inválido";
	public static final String PAU_MESSAGES_FIELD_INVALID_TELEFONO = "Teléfono inválido (Deben ser 10 dígitos)";
	public static final String PAU_MESSAGES_FIELD_INVALID_RFC = "RFC inválido";
	public static final String PAU_MESSAGES_FIELD_NUMEROS_ONLY = "No se admiten letras";
	public static final String PAU_VALIDATION_REGEXP_NUMEROS = "^[0-9]*$";
	
	public static final String ERROR="Error";
	public static final String AVISO="Aviso";
	
	public static final String DEFAUL_MUNICIPIO="TULT";
	public static final String DEPTO_OBRAS_PUB="DOP";
	public static final String LIC_PUB_NAL="LPN";
	public static final String ADJ_DIRECTA="AD";
	
	public static final String LIC_PUB_NAL_DESC="LICITACIÓN PÚBLICA NACIONAL";
	public static final String ADJ_DIRECTA_DESC="ADJUDICACIÓN DIRECTA";
	
	public static final String RECURSO_FISMDF="FISMDF";
	public static final String RECURSO_FEFOM="FEFOM";
	public static final String RECURSO_RP="RP";
	public static final String RECURSO_PAD="PAD";
	
	public static final String RECURSO_FISMDF_DESC="FONDO PARA LA INFRAESTRUCTURA SOCIAL MUNICIPAL Y DE LAS DEMARCACIONES TERRITORIALES DEL DISTRITO FEDERAL, (FISMDF)";
	public static final String RECURSO_FEFOM_DESC="FONDO ESTATAL DE FORTALECIMIENTO MUNICIPAL (FEFOM)";
	public static final String RECURSO_RP_DESC="RECURSOS PROPIOS (RP)";
	public static final String RECURSO_PAD_DESC="PROGRAMA DE ACCIONES PARA EL DESARROLLO (PAD)";
	
	public static final String GION="-";
	public static final String DIAGONAL="/";
	public static final String SALTO_LINEA="\n";
	
	public static final int DIAS_HABILES_FECHA_ADQUIRIR_BASES= 3;
	public static final int DIAS_HABILES_FECHA_VISITA_TRABAJOS= 1;
	public static final int DIAS_HABILES_FECHA_PRESENTACION_APERTURA= 5;
	public static final int DIAS_HABILES_FECHA_COMUNICACION_FALLO= 4;
	public static final int DIAS_60= 60;
	
	public static final int VALUE_100= 100;
	
	public static final String PDF_CONVOCARIA="01";
	public static final String PDF_ACTA="02";
	public static final String PDF_ACTA_REPRE_LEGAL="03";
	public static final String PDF_PB_EMPRESA="04";
	public static final String PDF_ACTA_ACLARACIONES="05";
	public static final String PDF_PB_MUNICIPIO="06";
	public static final String PDF_BASE="07";
	public static final String PDF_ACTA_FALLO="08";
	public static final String PDF_CONTRATO_FISMDF="09";
	public static final String PDF_PRESUPUESTO_BASE_GEST_MUN="10";
	public static final String PDF_PB_EMPRESA_GESTION="11";
	public static final String PDF_PB_EMPRESA_SEGUIMIENTO="12";
	public static final String PDF_PB_EMPRESA_SEGUIMIENTO_FIN="13";
	public static final String PDF_CONVENIO="14";
	public static final String XLS_REPORTE_FINANCIERO="15";
	public static final String XLS_CTROL_ESTIMACION="16";
	public static final String CONVOCATORIA_TITLE="CONVOCATORIA";
	public static final String SPACE=" ";
	public static final String ABRE_PARENTESIS="( ";
	public static final String CIERRA_PARENTESIS=") ";
	public static final String GION_SPACE=" - ";
	public static final String COMA_SPACE=", ";
	
	public static final String STYLE_OVER_PRESUPUESTO="text_font_18_BOLD_RED";
	public static final String STYLE_OK_PRESUPUESTO="text_font_18_BOLD_BLUE_LIGHT";
	
	
	public static final String DOC_FT="FichaTecnica-";
	public static final String DOC_PROYECTO="DocumentoProyecto-";
	public static final String DOC_BASES="DocumentoBases-";
	public static final String DOC_A1="DocumentoA1-";
	public static final String DOC_A2="DocumentoA2-";
	public static final String DOC_A3="DocumentoA3-";
	public static final String DOC_A4="DocumentoA4-";
	
	
	public static final String DOC_FACTURA="Factura-";
	public static final String DOC_XML="XML-";
	public static final String DOC_VALIDACION="Validacion-";
	public static final String DOC_FIANZA1="Fianza1_Anticipo-";
	public static final String DOC_FIANZA2="Fianza2_Cumplimiento-";
	public static final String DOC_FIANZA3="Fianza3_Cumplimiento_endosos-";
	public static final String DOC_FIANZA4="Fianza4_Vicios_ocultos-";
	public static final String DOC_SAT="SAT-";
	public static final String DOC_IMSS="IMSS-";
	public static final String DOC_INFOBAVIR="INFONAVIT-";
	public static final String DOC_CONST_FISC="ConstanciaFiscal-";
	public static final String DOC_SOL_PAGO="SolicitudPago-";
	
	public static final String DOC_AYUNTAMIENTO="DoctoAyuntamiento-";
	public static final String DOC_EXTERNOS="DoctoExternos-";
	
	public static final String DOC_FORMALIZADO="Acta-Visita-";
	public static final String DOC_ACLARACIONES="Acta-Junta-Aclaraciones-";
	public static final String DOC_BASES_ADJ="Bases-Adjudicaciones-";
	public static final String DOC_FALLO="Acta-Fallo-";
	public static final String DOC_CONTRATO="Contrato-";
	public static final String DOC_PREBA_EMP="PresupuestoBase-Empresa";
	public static final String DOC_PREBA_MUN="PresupuestoBase-Municipio";
	
	public static final String NUM_1="1";
	public static final String NUM_2="2";
	public static final String NUM_3="3";
	public static final String NUM_4="4";
	public static final String NUM_5="5";
	public static final String NUM_6="6";
	public static final String NUM_7="7";
	public static final String NUM_8="8";
	public static final String NUM_9="9";
	public static final String NUM_10="10";
	public static final String NUM_11="11";
	public static final String NUM_12="12";
	public static final String NUM_13="13";
	public static final String NUM_14="14";
	public static final String NUM_15="15";
	public static final String NUM_16="16";
	public static final String NUM_17="17";
	public static final String NUM_18="18";
	public static final String NUM_19="19";
	public static final String NUM_20="20";
	

	public static final String EXT_DWG = "dwg";
	public static final String EXT_PDF = "pdf";
	
	public static final String EXT_DWG_PUNTO = ".dwg";
	public static final String EXT_PDF_PUNTO = ".pdf";
	public static final String EXT_PNG_PUNTO = ".png";
	public static final String EXT_EXCEL_PUNTO = ".xls";
	
	public static final String RESOURCE_LOGOS= "/logos/";

	public static final boolean FINALIZAR = false;
	public static final boolean APROBAR = true;

	public static final int APROBAR_PE = 2;
	public static final int FINALIZAR_PE = 1;
	public static final int PROGRAMA_GUARDADO = 2;
	
	public static final int ROL_EMPRESA=3;
	public static final int VISITA_OBRA=1;
	public static final String PORTAL_OBRAS_DOMINIO="@portalobras.com";
	
	public static final String CLIENTE_TULTITLAN="MUNICIPIO DE TULTITLAN, DIRECCIÓN DE OBRAS PUBLICAS, SUBDIRECCION DE PLANEACIÓN, PROGRAMACIÓN, PROYECTOS Y LICITACIONES";
	public static final String LUGAR_TULTITLAN="TULTITLAN, Estado de México";
	
	public static final String RUTA_SUBREPORTE_EMP= Constantes.class.getClassLoader().getResource("jasper/pbempresa/PresupuestoBaseEmpDet.jasper").toString();

	public static final String DIAS_NATURALES = " días naturales";
	
	public static final String SOLVENTE = "SOLVENTE";
	public static final String NO_SOLVENTE = "NO SOLVENTE";
	
	public static final String INSISOA="A";
	public static final String INSISOB="B";
	public static final String INSISOC="C";
	public static final String DIFE_PRE_BASE="DIFERENCIA CON RESPECTO AL PRESUPUESTO BASE";
	public static final String DIFE_PORC_BASE="PORCENTAJE DE INCREMENTO O DECREMENTO CON RESPECTO AL PRESUPUEESTO BASE";
	public static final String ACTA_ADJ_PORCENTAJE=" %";

	public static final String JEFE_LICITACION = "JEFE DE LICITACIONES";
	public static final String JEFE_DEPTO = "JEFE DE DEPARTAMENTO";
	public static final String JEFE_PRE = "JEFE DE PRESUESTACIÓN Y LICITACIÓN";
	public static final String JEFE_COORDIN = "COORDINADOR DE PLANEACIÓN";
	public static final String JEFE_DIRE = "DIRECTOR DE OBRAS PÚBLICAS";

	
	

	
	}


