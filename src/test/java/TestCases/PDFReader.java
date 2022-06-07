package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class PDFReader extends BaseClass {

	@Test(priority = 1)
	public void pdfReadingFromSystem() throws Exception {
		File file = new File("C:\\Users\\HP\\Downloads\\Proposal_Budget_Summary_668_Smith, Nathaniel.pdf");
		FileInputStream fileInputStream = new FileInputStream(file);
		PDDocument pDDocument = PDDocument.load(fileInputStream);
		System.out.println(pDDocument.getNumberOfPages());

		PDFTextStripper pDFTextStripper = new PDFTextStripper();
		String docText = pDFTextStripper.getText(pDDocument);
		System.out.println(docText);
		Assert.assertTrue(docText.contains("Confidential"), "Failed");		
		pDDocument.close();
		fileInputStream.close();
	}

	@Test(priority = 2, enabled = true)
	public void pdfReadingInternet() throws Exception {
		
		URL url = new URL("https://file-examples.com/storage/fe83f6744b629b798a083a5/2017/10/file-sample_150kB.pdf");
		PDDocument pDDocument = PDDocument.load(url.openStream());
		System.out.println(pDDocument.getNumberOfPages());

		PDFTextStripper pDFTextStripper = new PDFTextStripper();
		pDFTextStripper.setStartPage(1);
		pDFTextStripper.setEndPage(3);		
		String docText = pDFTextStripper.getText(pDDocument);
		System.out.println("second Document");
		System.out.println(docText);
		Assert.assertTrue(docText.contains("Vivamus"), "Failed");
		pDDocument.close();

	}

}
