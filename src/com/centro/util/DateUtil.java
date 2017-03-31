package com.centro.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Clase con utilidades de fecha
 * @author Ane
 *
 */
public class DateUtil {

	public DateUtil(){}
	
	/**
	 * Metodo que formatea fecha Date en String con el formato "dd-MM-YYYY"
	 * @return
	 * @throws ParseException
	 */
	public String fechaBBDD() throws ParseException{
		Date fecha = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(fecha);
	}
	
}
