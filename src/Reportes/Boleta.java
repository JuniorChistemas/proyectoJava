package Reportes;

import BussinessObject.ClienteBO;
import BussinessObject.DetalleVentaBO;
import BussinessObject.UsuarioBO;
import DataTransferObject.ClienteDTO;
import DataTransferObject.DetalleVentaDTO;
import DataTransferObject.UsuarioDTO;
import Utilidades.PropiedadesUtil;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 *
 * @author Jesús
 */
public class Boleta {

    public static void BoletaElectronica(String Nombre, ClienteBO cliente,String IdCliente,UsuarioBO Usuario,String IdUsuario
                   ,DetalleVentaBO VentaDBO,String IdVenta,float precioT ) throws FileNotFoundException, IOException {
        String destino = IdVenta + ".pdf";
        PdfWriter pdfWriter = new PdfWriter(destino);
        PdfDocument PDFdocumento = new PdfDocument(pdfWriter);
        Paragraph salto = new Paragraph("\n");
        PDFdocumento.setDefaultPageSize(PageSize.A4);
        
        try ( Document documento = new Document(PDFdocumento)) {
            float ancho = 285f;
            float ancho2 = ancho + 130f;
            float ancho3 = 100f;
            float matriz[] = {ancho2, ancho, ancho3};
            float tamDescription[] = {ancho2, ancho};
            float tamaño[] = {190f * 3};
            float tablaPro[] = {ancho, ancho, ancho, ancho, ancho};
            PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
            PdfFont roman = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            //Imagenes\imagen2.jpg
            String img2 = "ImagenesReporte\\imagen3.jpg";       
            System.out.println(img2);
            Image img = new Image(ImageDataFactory.create(img2));
            Table tabla = new Table(matriz);

            Calendar fecha = new GregorianCalendar();
            int anio = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DATE);
            String fechaC = String.valueOf(dia + "/" + mes + "/" + anio);
            tabla.addCell(new Cell().add(new Paragraph("Inversiones"
                    + " \t       D y E").setFontSize(35f)).setBorder(Border.NO_BORDER).setFont(bold));
            tabla.addCell(new Cell().add(new Paragraph(Datos() + "\nFecha: " + fechaC)).setBorder(Border.NO_BORDER).setFont(roman));
            (tabla.addCell(img).setBorder(Border.NO_BORDER)).setBorder(Border.NO_BORDER);
            documento.add(tabla);
            Color color = new DeviceGray();
            Color color2 = new DeviceRgb(java.awt.Color.DARK_GRAY);
            Border gb = new SolidBorder(color, 0.5f);
            Table divisor = new Table(tamaño);
            divisor.setBorder(gb);
            documento.add(salto);
            documento.add(divisor);
            documento.add(salto);
            Table datos = new Table(tamDescription);
            datos.addCell(Izquierda("Datos del cliente", bold));
            datos.addCell(Izquierda("Datos del empleado", bold));
            ClienteDTO DCliente =  cliente.VentaCliente(IdCliente);
            UsuarioDTO DUsuario = Usuario.BuscarVenta(IdUsuario);
            documento.add(datos.setMarginBottom(12f));
            Table datos2 = new Table(tamDescription);
            datos2.addCell(Izquierda("Cod.Cliente", bold));
            datos2.addCell(Izquierda("Cod.Empleado", bold));
            datos2.addCell(Izquierda(IdCliente, roman));
            datos2.addCell(Izquierda(IdUsuario, roman));
            datos2.addCell(Izquierda("Nombre ", bold));
            datos2.addCell(Izquierda("Nombre", bold));
            datos2.addCell(Izquierda(DCliente.getIdCliente().trim()+" "+DCliente.getIdPersona().trim(), roman));
            datos2.addCell(Izquierda(DUsuario.getIdUsuario().trim()+" "+DUsuario.getIdPersona().trim(), roman));
            datos2.addCell(Izquierda("Direccion ", bold));
            datos2.addCell(Izquierda("Cod.Venta", bold));
            datos2.addCell(Izquierda(DCliente.getObservaciones(), roman));
            datos2.addCell(Izquierda(IdVenta, roman));
            documento.add(datos2.setMarginBottom(12f));
            Border gb2 = new SolidBorder(color, 0.1f);
            Table divisor2 = new Table(tamaño);
            divisor2.setBorder(gb2);
            documento.add(salto);
            documento.add(divisor2);
            documento.add(Derecha("***************    Detalles de los productos    ***************", bold));
            documento.add(divisor2);
            
            Table titulos = new Table(tablaPro);
            titulos.addCell(new Cell().add(new Paragraph("CODIGO").setFont(bold).setFontColor(color2)).setBorder(Border.NO_BORDER));
            titulos.addCell(new Cell().add(new Paragraph("           DESCRIPCION             ").setFont(bold).setFontColor(color2)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            titulos.addCell(new Cell().add(new Paragraph("CANTIDAD").setFont(bold).setFontColor(color2)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            titulos.addCell(new Cell().add(new Paragraph("DESCUENTO").setFont(bold).setFontColor(color2)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            titulos.addCell(new Cell().add(new Paragraph("IMPORTE TOTAL").setFont(bold).setFontColor(color2)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
            documento.add(salto);
            documento.add(titulos.setMarginBottom(20f));
            Table tablaProdc = new Table(tablaPro);
            
            try {
                for (DetalleVentaDTO o : VentaDBO.listar(IdVenta)) {
                    tablaProdc.addCell(new Cell().add(Izquierda(o.getIdVenta().trim(),  roman)));
                    tablaProdc.addCell(new Cell().add(Izquierda(o.getIdProducto(), roman)));
                    tablaProdc.addCell(new Cell().add(Izquierda(String.valueOf(o.getCantidad()), roman)));
                    tablaProdc.addCell(new Cell().add(Izquierda(String.valueOf(o.getPrecioUnitario()), roman)));
                    tablaProdc.addCell(new Cell().add(Izquierda(String.valueOf(o.getDescuento()), roman)));                
                }
            } catch (Exception e) {
                System.out.println("no encuentro nada");
            }
            documento.add(tablaProdc.setMarginBottom(40f));
            documento.add(divisor2);
            documento.add(new Cell().add(Derecha("Total a pagar: "+precioT, bold)));
            documento.add(divisor2);
            documento.add(new Cell().add(Izquierda("Le agradecemos por su preferecia, La empresa DyE es"
                    + " confiable y con productos de calidad"
                    + "\t\t BY: INGENIERIA DE SOFTWARE (CICLO V)", roman)));
            documento.close();
        }
    }
       private static String Datos(){
         String linea = "DatosPropiedades/DatosEmpresa.properties";
         String ruc = "Ruc";
         String direccion = "Direccion";
         String correo = "Correo";     
         String tipo = "Boleta";
         Properties prop = PropiedadesUtil.loadProperty(linea);
         String total = "Ruc: "+prop.getProperty(ruc)+"\nDireccion: "+prop.getProperty(direccion)+"\nCorreo: "+prop.getProperty(correo)+"\nTipo: "+prop.getProperty(tipo);
         return total;
    }
           private static Cell  Derecha(String texto,PdfFont x){
        return new Cell().add(new Paragraph(texto)).setBorder(Border.NO_BORDER).setFont(x).setTextAlignment(TextAlignment.CENTER);
    }
    private static Cell Izquierda(String texto,PdfFont x){
         return new Cell().add(new Paragraph(texto)).setBorder(Border.NO_BORDER).setFont(x).setTextAlignment(TextAlignment.LEFT);
    }
}

