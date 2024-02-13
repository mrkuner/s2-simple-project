package com.farasanz.util;

import java.io.ByteArrayInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CalcularHash {

	private Log logger = LogFactory.getLog(this.getClass());
	private String formatoCodificacion = "SHA-1";
	
	/**
	 * Constructor por defecto, que usar� como formato de codificacion SHA-1
	 */
	public CalcularHash(){
		
	}
	
	/**
	 * Constructor que recibe como parametro un formato de codificacion
	 * 
	 * @param formatoCodificacion
	 */
	public CalcularHash(String formatoCodificacion) {
		this.formatoCodificacion = formatoCodificacion;
	}

	/**
	 * M�todo para calcular el c�digo hash de un fichero
	 * @param codifcar bytes a codificar
	 * @return String literal con el c�digo hash del fichero
	 * @llamadas al m�todo hexCode de esta clase pas�ndole como par�metro un byte[]
	 * @throws Exception devuelve una excepci�n si se produce un error no controlado
	 */
	public String codigoHash(byte[] codificar) throws Exception {
		try{
			MessageDigest md = MessageDigest.getInstance(formatoCodificacion);
			ByteArrayInputStream bais = new ByteArrayInputStream(codificar);
			DigestInputStream dis = new DigestInputStream(bais, md);
	
			int leido = dis.read();
			int tamano = 1;
			while (leido != -1) {
				leido = dis.read();
				tamano++;
			}
			tamano--;
			System.out.println("Tamano: " + tamano);
			byte[] codigo = dis.getMessageDigest().digest();
			String strClaveEncriptada = hexEncode(codigo);
			dis.reset();
			return strClaveEncriptada;
		}
		catch (Exception e) {
			this.logger.error("Error codificando el fichero");
			throw e;
		}
	}
	
	/**
	 * M�todo que calcula el c�digo hexadecimal del fichero para su posterior procesamiento en el c�lculo del hash
	 * @param aInput byte[] array de bytes para el c�lculo del c�digo hexadecimal
	 * @return String devuelve un literal con el c�digo hexasdecimal
	 */
	public String hexEncode(byte[] aInput) {
		StringBuffer result = new StringBuffer();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}
}
