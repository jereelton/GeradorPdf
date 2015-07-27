/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.geradorpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author UserMasters
 */
public class GeraPdf {
    
    private String nomePdf;
    private String localPdf;
    private String conteudoPdf;
    private String formatoPdf;
    private String autorPdf;
    
    Document documentoPdf = new Document();
    
    public void definirNomePdf(String nome_pdf) {
        
        this.nomePdf = nome_pdf;
        
    }
    
    public void definirLocalPdf(String local_pdf) {
        
        this.localPdf = local_pdf;
        
    }
    
    public void definirConteudoPdf(String conteudo_pdf) {
        
        this.conteudoPdf = conteudo_pdf;
        
    }
    
    public void definirFormatoPdf(String formato_pdf) {
        
        this.formatoPdf = formato_pdf;
        
    }
    
    public void definirAutorPdf(String autor_pdf) {
        
        this.autorPdf = autor_pdf;
        
    }
    
    public boolean gerarPdf() {
        
        try {
        
            PdfWriter.getInstance(this.documentoPdf, new FileOutputStream(this.localPdf+"\\"+this.nomePdf+".pdf"));
            this.documentoPdf.open();
            this.documentoPdf.add(new Paragraph(this.conteudoPdf));
            this.documentoPdf.addAuthor(this.autorPdf);
        
        } catch(DocumentException | IOException e) {
            
            System.err.println(e.getMessage());
            return false;
            
        }
        
        this.documentoPdf.close();
    
        return true;
    
    }
    
}
