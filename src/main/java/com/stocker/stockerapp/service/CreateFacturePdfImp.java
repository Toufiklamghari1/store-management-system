package com.stocker.stockerapp.service;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import com.stocker.stockerapp.dto.LigneAchatDTO;
import com.stocker.stockerapp.utils.AchatFactureRequest;
import com.stocker.stockerapp.utils.Constants;
import com.stocker.stockerapp.utils.TransactionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itextpdf.io.IOException;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

@Service
public class CreateFacturePdfImp implements CreateFacturePdf {

	@Value("${pdf.output.path}")
	private String outputPath;

	@Override
	public void createPDF(AchatFactureRequest achatsFactureRequest, String type) throws java.io.IOException {

		String currencyCode = "MAD";
		String FactTitle = type.equals(Constants.ACHAT_TITLE)
				? Constants.FACTUR_ACHAT_TITLE + " " + TransactionUtils.preparReferenceFacture(achatsFactureRequest.getAchatDate())
				: Constants.FACTUR_VENTE_TITLE + " " + TransactionUtils.preparReferenceFacture(achatsFactureRequest.getAchatDate());
		String forniOrClient = type.equals(Constants.ACHAT_TITLE) ? Constants.FOURNISSEUR :Constants.CLIENT;

		String formatedDate = TransactionUtils.formatDate(achatsFactureRequest.getAchatDate(),"dd/MM/yyyy");
		System.out.println("formatedDate >>>"+formatedDate);
		try {
			PdfWriter writer = new PdfWriter(outputPath + "/monDocument.pdf");
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);

			// Ajout du titre de la facture
			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
			Text title = new Text(FactTitle).setFont(font).setFontSize(18);
			Paragraph paragraph = new Paragraph(title).setTextAlignment(TextAlignment.CENTER);
			document.add(paragraph);

			// Ajout des informations de la facture
			document.add(new Paragraph(forniOrClient + achatsFactureRequest.getFournisseurName()));
			document.add(new Paragraph("Référence : " + achatsFactureRequest.getAchatRef()));
			document.add(new Paragraph("Date : " + formatedDate));
			document.add(new Paragraph("Total : " + formatCurrency(achatsFactureRequest.getTotal(), currencyCode)));

			// Ajout du tableau de lignes d'achat
			Table table = new Table(new float[] { 2, 3, 2, 3 });
			table.setWidth(500);
			table.setMarginTop(20);
			table.setHorizontalAlignment(HorizontalAlignment.CENTER);
			table.addHeaderCell(createHeaderCell("Référence Produit"));
			table.addHeaderCell(createHeaderCell("Catégorie"));
			table.addHeaderCell(createHeaderCell("Quantité"));
			table.addHeaderCell(createHeaderCell("Total Ligne"));

			for (LigneAchatDTO ligne : achatsFactureRequest.getLigneAchat()) {
				table.addCell(createCell(ligne.getProduit().getReference()));
				table.addCell(createCell(ligne.getProduit().getCategorie().getDescription()));
				table.addCell(createCell(String.valueOf(ligne.getQuantite())));
				table.addCell(createCell(
						formatCurrency((ligne.getProduit().getPrixUnitaire() * ligne.getQuantite()), currencyCode)));
			}

			document.add(table);

			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private Cell createHeaderCell(String content) throws java.io.IOException {

		Color myColor = new DeviceRgb(62, 171, 171);// or red, green, blue, alpha
		PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		Paragraph p = new Paragraph(content).setFont(font).setFontSize(12);
		Cell cell = new Cell().add(p);
		cell.setBackgroundColor(myColor);
		cell.setTextAlignment(TextAlignment.CENTER);
		cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
		cell.setBorder(Border.NO_BORDER);
		cell.setWidth(200);
		return cell;
	}

	private Cell createCell(String content) {
		Paragraph p = new Paragraph(content).setFontSize(10);
		Cell cell = new Cell().add(p);
		return cell;

	}

	public String formatCurrency(double amount, String currencyCode) {
		Locale locale = new Locale("fr", "FR");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		currencyFormatter.setCurrency(Currency.getInstance(currencyCode));
		return currencyFormatter.format(amount);
	}
}