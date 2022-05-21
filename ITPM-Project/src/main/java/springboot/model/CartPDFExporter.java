package springboot.model;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.*;

public class CartPDFExporter {
	private List<Cart> getAllCartModels;
	
	public CartPDFExporter (List<Cart> getAllCartModels) {
		this.getAllCartModels = getAllCartModels;
	}
	
	private void writeTableHeader (PdfPTable table) {
		PdfPCell  cell= new PdfPCell();
		cell.setBackgroundColor(Color.GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("ITEM NAME", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("ITEM DESCRIPTION", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("ITEM SIZE", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("ITEM COLOUR", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("ITEM PRICE", font));
		table.addCell(cell);
	}
	private void writeTableData(PdfPTable table) {
		for (Cart cart : getAllCartModels) {
			table.addCell(String.valueOf(cart.getItmeName()));
			table.addCell(String.valueOf(cart.getItemDescription()));
			table.addCell(String.valueOf(cart.getItemSize()));
			table.addCell(String.valueOf(cart.getItemColour()));
			table.addCell(String.valueOf(cart.getItemPrice()));			
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		
		Paragraph p = new Paragraph(" LIST OF THE ITEMS", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {2.0f, 3.5f, 1.5f, 2.2f, 1.8f});
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		document.close();
	}
}
