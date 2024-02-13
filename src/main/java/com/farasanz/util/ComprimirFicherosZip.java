package com.farasanz.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ComprimirFicherosZip {

	/**
	 * Comprime los datos de un fichero a formato zip
	 * @param losDatos Array de bytes con el contenido del fichero.
	 * @param nombreFichero El nombre que tendr� la entrada del fichero.
	 * @return
	 */
	
//prueba subir fichero	
	public static byte[] comprimirDatos(byte[] losDatos, String nombreFichero) throws Exception {
		
		byte[] buf = new byte[1024];
		
		ZipOutputStream zipOutputStream = null;
		// OutputStream conteniendo la salida comprimida.
		ByteArrayOutputStream osComprimida = new ByteArrayOutputStream();
		ByteArrayInputStream bais = null;
		try{
			// creamos el stream del formato zip
			zipOutputStream = new ZipOutputStream(osComprimida);
			// creamos una entrada dentro del zip
			zipOutputStream.putNextEntry(new ZipEntry( nombreFichero ));
			
			// inputStream con el fichero a comprimir
			bais = new ByteArrayInputStream(losDatos);
			
			// escribimos la salida en el output stream de salida
			int len = 0;
			
			while ( (len = bais.read(buf)) > 0 ){
				zipOutputStream.write(buf, 0 , len);
			}
			
		    bais.close();
		    zipOutputStream.close();
			

		}finally{
			// en cualquier caso intentamos liberar los recursos
			bais = null;
			zipOutputStream = null;
		}
		
		return osComprimida.toByteArray();

	}
	
	public static byte[] descomprimirDatos(byte[] losDatos) throws Exception{
		
		ByteArrayInputStream bais = new ByteArrayInputStream(losDatos);
		ZipInputStream zipInputStream = new ZipInputStream( bais );
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		ZipEntry zipEnty = zipInputStream.getNextEntry();
		
		
		byte[] buf = new byte[1024];
		int len;
		while ( (len = zipInputStream.read(buf)) > 0 ){
			baos.write(buf, 0 , len);
		}
		
		byte[] salida = baos.toByteArray();
		baos.close();
		bais.close();
		zipInputStream.close();
		
		baos = null;
		bais = null;
		zipInputStream = null;
		
		return salida;
	}
	
}
