package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

class TestArchivos {
	
	 XWPFDocument documentoWord;
	    File archivoWord = new File("C:\\Users\\HP\\Documents\\Examen.docx");
	    File archivoPDF = new File("C:\\Users\\HP\\Documents\\Examen.pdf");
	 
	    @Test
	    void leerDocxTest() {
	        documentoWord = Principal.leerDocx(archivoWord);
	        assertNotNull(documentoWord);
	    }
	     
	    @Test
	    void convertirPDFTest() {
	        leerDocxTest();
	        boolean resultado = Principal.convertirPDF(archivoPDF, documentoWord);
	        assertTrue(resultado);
	    }


}
