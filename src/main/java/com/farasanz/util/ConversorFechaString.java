/**
 *
 */
package com.farasanz.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author francisco.lojo
 *
 */
public class ConversorFechaString {
    protected static final Logger logger = LogManager.getLogger();


	private String formatoFecha = "dd/MM/yyyy";
	private String formatoFechaSinDias = "MM/yyyy";

	/**
	 * Constructor por defecto, que usar� como formato de fecha 'dd/MM/yyyy'
	 */
	public ConversorFechaString() {}

	/**
	 * Constructor que recibe como parametro un formato de fecha
	 *
	 * @param formatoFecha
	 */
	public ConversorFechaString(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}

	/**
	 * Convierte una fecha en formato texto a formato Date.
	 * @param fechaString La fecha en formato texto
	 * @return La fecha en formato Date.
	 */
	public synchronized Date convertirStringADate(String fechaString) throws Exception {
		Date fechaDate = null;
		try {
			if (fechaString == null || fechaString.equals("")) {
				return null;
			} else {
				DateFormat df = new SimpleDateFormat(this.formatoFecha);
				fechaDate = df.parse(fechaString);
			}
		} catch (Exception e) {
			logger.error("Error convirtiendo fecha " + fechaString + " en convertirStringADate");
			throw e;
		}
		return fechaDate;
	}

	/**
	 * Convierte una fecha en formato java.util.Date a formato texto
	 * @param fechaDate La fecha en formato Date
	 * @return La fecha en formato texto.
	 */
	public synchronized String convertirDateAString(Date fechaDate) throws Exception {
		String fechaString = "";
		try{
			if (fechaDate == null) {
				return null;
			} else {
				DateFormat df = new SimpleDateFormat(this.formatoFecha);
				fechaString = df.format(fechaDate);
			}
		} catch (Exception e) {
			logger.equals("Error formateando fecha en convertirDateAString" );
			throw e;
		}
		return fechaString;
	}

	/**
	 * Convierte una fecha en formato texto a formato Date.
	 * @param fechaString La fecha en formato texto
	 * @return La fecha en formato Date.
	 */
	public synchronized Date convertirStringADateSinDias(String fechaString) throws Exception {
		Date fechaDate = null;
		try {
			if (fechaString == null || fechaString.equals("")) {
				return null;
			} else {
				DateFormat df = new SimpleDateFormat(this.formatoFechaSinDias);
				fechaDate = df.parse(fechaString);
			}
		} catch (Exception e) {
			logger.error("Error convirtiendo fecha " + fechaString + " en convertirStringADateSinDias");
			throw e;
		}
		return fechaDate;
	}

	/**
	 * Convierte una fecha en formato java.util.Date a formato texto
	 * @param fechaDate La fecha en formato Date
	 * @return La fecha en formato texto.
	 */
	public synchronized String convertirDateAStringSinDias(Date fechaDate) throws Exception {
		String fechaString = "";
		try{
			if (fechaDate == null) {
				return null;
			} else {
				DateFormat df = new SimpleDateFormat(this.formatoFechaSinDias);
				fechaString = df.format(fechaDate);
			}
		} catch (Exception e) {
			logger.equals("Error formateando fecha en convertirDateAStringSinDias" );
			throw e;
		}
		return fechaString;
	}
}