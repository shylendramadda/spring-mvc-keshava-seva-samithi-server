package com.rss.keshava.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rss.keshava.domain.Donor;
import com.rss.keshava.domain.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class StudentView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"student-pdf-file.pdf\"");

        List<Student> students = (List<Student>) model.get("students");
        document.add(new Paragraph("Student List " + LocalDate.now()));

//        PdfPTable table = new PdfPTable(donors.stream().findAny().get().getColumnCount());
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        // write table header
        cell.setPhrase(new Phrase("Admission Number", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("AdharNumber", font));
        table.addCell(cell);

        for (Student user : students) {
            table.addCell(user.getAdmissionNumber());
            table.addCell(user.getSname());
            table.addCell(user.getAdharNumber());
        }

        document.add(table);
    }
}
