package ua.skillsup.gelius.controller.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ua.skillsup.gelius.model.dto.*;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.util.ProductUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class PdfView extends AbstractPdfView {

    private static final String EMPTY_STRING = "";
    private static final BaseColor COLOR = new BaseColor(182, 215, 168);
    private static final String FONT_PATH = "/pdf/fonts/Colibri.ttf";
    private static final Rectangle PAGE_SIZE = PageSize.A4.rotate();

    @Override
    protected Document newDocument() {
        return new Document(PAGE_SIZE, 36, 36, 15, 15);
    }

    private void addMetaData(Document document, ProductDto product) {
        document.addTitle(ProductUtils.getFullProductNumber(product.getProductNumber(), product.getIsNew()));
        document.addAuthor("Gelius Company");
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductDto product = (ProductDto) model.get("product");
        String version = (String) model.get("version");

        BaseFont baseFont = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Map<String, PdfPTable[]> header = createHeader(product, version, baseFont);
        for (Map.Entry<String, PdfPTable[]> entry : header.entrySet()) {
            for (PdfPTable pdfPTable : entry.getValue()) {
                document.add(pdfPTable);
            }
        }

        PdfPTable body = createPdfBody(product, version, baseFont);
        document.add(body);

        List<String> images = new ArrayList<>(product.getFileImagePaths());
        for (String str : images) {
            Image image = Image.getInstance(str);

            float width = image.getScaledWidth();
            float height = image.getScaledHeight();

            System.out.println(str);

            if (width > 800) {
                width = 800;
            }

            if (height > 400) {
                height = 400;
            }

            image.scaleToFit(width, height);
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
            writer.setStrictImageSequence(true);
        }
        addMetaData(document, product);
    }

    private Map<String, PdfPTable[]> createHeader(ProductDto product, String version, BaseFont baseFont) {
        Map<String, PdfPTable[]> map = new LinkedHashMap<>();

        PdfPTable[] headerTop = createHeaderTop(product, baseFont, version);
        PdfPTable[] headerBottom = createHeaderBottom(product, baseFont, version);

        map.put("headerTop", headerTop);
        map.put("headerBottom", headerBottom);
        return map;
    }

    private PdfPTable createPdfBody(ProductDto product, String version, BaseFont baseFont) {
        float[] columnWidths = {5.2f, 0.05f, 3.7f, 0.05f, 3.7f};
        PdfPTable tableBody = new PdfPTable(columnWidths);
        tableBody.setWidthPercentage(105);

        PdfPCell leftCellTable = createLeftTable(product, baseFont, 14, 12, version);
        tableBody.addCell(leftCellTable);

        PdfPCell marginBetweenTables = new PdfPCell();
        marginBetweenTables.setBorder(Rectangle.NO_BORDER);
        tableBody.addCell(marginBetweenTables);

        PdfPCell middleTable = createMiddleTable(product, baseFont, 14, 12, version);
        tableBody.addCell(middleTable);

        tableBody.addCell(marginBetweenTables);

        PdfPCell rightTable = createRightTable(product, baseFont, 14, 12, version);
        tableBody.addCell(rightTable);

        return tableBody;
    }

    private PdfPTable[] createHeaderTop(ProductDto product, BaseFont baseFont, String version) {
        Boolean isNew = product.getIsNew();
        Integer productNumber = product.getProductNumber();
        String fullProductNumber = (productNumber == null && isNew == null) ?
                EMPTY_STRING : ProductUtils.getFullProductNumber(productNumber, isNew);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate createdDate = product.getProductCreateDate();
        String productCreatedDate = (createdDate == null) ? EMPTY_STRING : createdDate.format(dateTimeFormatter);

        LocalDate updatedDate = product.getProductUpdateDate();
        String productUpdatedDate = (updatedDate == null) ? EMPTY_STRING : updatedDate.format(dateTimeFormatter);

        Boolean isUse = product.getIsUse();
        String productIsUse = (isUse == null) ?
                EMPTY_STRING : (isUse) ? "Тех. карта используется" : "Tex. карта не используется";

        String personPrepared = product.getPersonPrepared();
        String productPersonPrepared = (personPrepared == null) ? EMPTY_STRING : personPrepared;

        // Title and CreatedDate
        float[] columnWidths = {5f, 1.5f};
        PdfPTable titleAndCreatedDateTable = new PdfPTable(columnWidths);
        titleAndCreatedDateTable.setWidthPercentage(100);

        PdfPCell cellTitleCreatedDateTable1 = getCell("Техкарта № " + fullProductNumber, PdfPCell.ALIGN_CENTER, baseFont, 18, Font.BOLD);
        cellTitleCreatedDateTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cellTitleCreatedDateTable1.setPaddingLeft(75);
        cellTitleCreatedDateTable1.setPaddingRight(-60);
        titleAndCreatedDateTable.addCell(cellTitleCreatedDateTable1);

        PdfPCell cellTitleCreatedDateTable2 = getCell("Создано: " + productCreatedDate, PdfPCell.ALIGN_LEFT, baseFont, 12, Font.NORMAL);
        cellTitleCreatedDateTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTitleCreatedDateTable2.setPaddingLeft("full".equals(version) ? 35 : 60);
        cellTitleCreatedDateTable2.setPaddingBottom(-5);
        titleAndCreatedDateTable.addCell(cellTitleCreatedDateTable2);

        // UpdatedDate
        PdfPTable updatedDateTable = new PdfPTable(columnWidths);
        updatedDateTable.setWidthPercentage(100);

        PdfPCell cellUpdatedDateTable1 = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 12, Font.NORMAL);
        cellUpdatedDateTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        updatedDateTable.addCell(cellUpdatedDateTable1);

        PdfPCell cellUpdatedDateTable2 = getCell("Изменено: " + productUpdatedDate, PdfPCell.ALIGN_LEFT, baseFont, 12, Font.NORMAL);
        cellUpdatedDateTable2.setPaddingLeft("full".equals(version) ? 35 : 60);
        cellUpdatedDateTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        updatedDateTable.addCell(cellUpdatedDateTable2);

        switch (version) {
            case "full":
                // Prepared Person
                PdfPTable preparedTable = new PdfPTable(columnWidths);
                preparedTable.setWidthPercentage(100);

                PdfPCell cellPreparedTable1 = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 12, Font.NORMAL);
                cellPreparedTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
                preparedTable.addCell(cellPreparedTable1);

                PdfPCell cellPreparedTable2 = getCell("Подготовил: " + productPersonPrepared, PdfPCell.ALIGN_LEFT, baseFont, 12, Font.NORMAL);
                cellPreparedTable2.setPaddingTop(2);
                cellPreparedTable2.setPaddingLeft("full".equals(version) ? 35 : 60);
                cellPreparedTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                preparedTable.addCell(cellPreparedTable2);

                // is Use
                PdfPTable isUseTable = new PdfPTable(columnWidths);
                isUseTable.setWidthPercentage(100);

                PdfPCell cellIsUseTable1 = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 12, Font.NORMAL);
                cellIsUseTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
                isUseTable.addCell(cellIsUseTable1);

                PdfPCell cellIsUseTable2 = getCell(productIsUse, PdfPCell.ALIGN_LEFT, baseFont, 10, Font.NORMAL);
                cellIsUseTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellIsUseTable2.setPaddingLeft("full".equals(version) ? 35 : 60);
                isUseTable.addCell(cellIsUseTable2);

                return new PdfPTable[]{titleAndCreatedDateTable, updatedDateTable, preparedTable, isUseTable};
        }

        return new PdfPTable[]{titleAndCreatedDateTable, updatedDateTable};
    }

    private PdfPTable[] createHeaderBottom(ProductDto product, BaseFont baseFont, String version) {
        ClientDto client = product.getClient();
        String productClient = (client == null)
                ? EMPTY_STRING : client.getCompanyName() == null ? EMPTY_STRING : client.getCompanyName();

        String productName = product.getProductName();

        ProductTypeDto type = product.getProductType();
        String productType = (type == null)
                ? EMPTY_STRING : type.getProductType() == null ? EMPTY_STRING : type.getProductType();

        float[] columnWidths = {0.8f, 1.8f, 1.5f, 1.5f, 1.5f, 1.8f, 2f};
        PdfPTable tableHeader = new PdfPTable(columnWidths);
        tableHeader.setWidthPercentage(100);

        // Client
        PdfPCell cellClient = getCell("Заказчик", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        cellClient.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellClient.setPaddingLeft(-10);
        cellClient.setPaddingBottom(15);

        PdfPCell cellClientValue = getCell(productClient, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        cellClientValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellClientValue.setPaddingBottom(15);

        // Product Name
        PdfPCell cellProductName = getCell("Название", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        cellProductName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellProductName.setPaddingLeft(40);
        cellProductName.setPaddingBottom(15);

        PdfPCell cellProductNameValue = getCell(productName, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        cellProductNameValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellProductNameValue.setPaddingBottom(15);

        // Product Type
        PdfPCell cellProductType = getCell("Тип изделия", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        cellProductType.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellProductType.setPaddingLeft(20);
        cellProductType.setPaddingBottom(15);

        PdfPCell cellProductTypeValue = getCell(productType, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        cellProductTypeValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellProductTypeValue.setPaddingLeft(-5);
        cellProductTypeValue.setPaddingBottom(15);

        PdfPCell emptyCell = getCell(EMPTY_STRING, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        emptyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        emptyCell.setPaddingBottom(15);

        switch (version) {
            case "full": {
                cellClient.setPaddingTop(-40);
                cellProductNameValue.setPaddingTop(-40);
                cellProductTypeValue.setPaddingTop(-40);
                cellProductName.setPaddingTop(-40);
                cellClientValue.setPaddingTop(-40);
                cellProductType.setPaddingTop(-40);
                emptyCell.setPaddingTop(-40);
                break;
            }
            default: {
                cellClient.setPaddingTop(-7);
                cellProductNameValue.setPaddingTop(-7);
                cellProductType.setPaddingTop(-7);
                emptyCell.setPaddingTop(-7);
                cellProductName.setPaddingTop(-7);
                cellProductTypeValue.setPaddingTop(-7);
                cellClientValue.setPaddingTop(-7);
            }
        }

        tableHeader.addCell(cellClient);
        tableHeader.addCell(cellClientValue);
        tableHeader.addCell(cellProductName);
        tableHeader.addCell(cellProductNameValue);
        tableHeader.addCell(cellProductType);
        tableHeader.addCell(cellProductTypeValue);
        tableHeader.addCell(emptyCell);

        return new PdfPTable[]{tableHeader};
    }

    private PdfPCell createMiddleTable(ProductDto product, BaseFont baseFont, int fontSizeForTittle, int fontSizeForColumns, String version) {
        Integer sizeWorkpieceLength = product.getSizeWorkpieceLength();
        String productSizeWorkpieceLength = (sizeWorkpieceLength == null)
                ? EMPTY_STRING : sizeWorkpieceLength.toString();

        Integer sizeWorkpieceWidth = product.getSizeWorkpieceWidth();
        String productSizeWorkpieceWidth = (sizeWorkpieceWidth == null)
                ? EMPTY_STRING : sizeWorkpieceWidth.toString();

        Integer numberBlankOnFormat = product.getNumberBlanksOnFormat();
        String productNumberBlankOnFormat = (numberBlankOnFormat == null)
                ? EMPTY_STRING : numberBlankOnFormat.toString();

        Integer blankFormat = product.getBlankFormat();
        String productBlankFormat = (blankFormat == null)
                ? EMPTY_STRING : blankFormat.toString();

        ConnectionValveDto connectionValve = product.getConnectionValve();
        String productConnectionValve = (connectionValve == null)
                ? EMPTY_STRING : connectionValve.getConnectionValve() == null ? EMPTY_STRING : connectionValve.getConnectionValve();

        String stamp = product.getStamp();
        String productStamp = (stamp == null) ? EMPTY_STRING : stamp;

        String cliche = product.getCliche();
        String productCliche = (cliche == null) ? EMPTY_STRING : cliche;

        PdfPCell middleCellTable = new PdfPCell();
        middleCellTable.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTableTop = {0.23f, 1.2f, 0.7f, 0.7f};
        PdfPTable middleTableTop = new PdfPTable(columnWidthsLeftCellTableTop);
        middleTableTop.setWidthPercentage(101);

        PdfPCell verticalTitleProducts = getCell("Продукция", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForTittle, Font.BOLD);
        verticalTitleProducts.setRotation(-90);
        verticalTitleProducts.setRowspan(6);
        verticalTitleProducts.setBackgroundColor(COLOR);
        verticalTitleProducts.setBorder(Rectangle.BOX);
        middleTableTop.addCell(verticalTitleProducts);

        PdfPCell cellProductBlankSizes = getCell("Разм. заготовки", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductBlankSizes.setMinimumHeight(13);
        cellProductBlankSizes.setBorder(Rectangle.BOX);
        cellProductBlankSizes.setPaddingBottom(4);
        middleTableTop.addCell(cellProductBlankSizes);

        PdfPCell cellProductBlankSizesLengthValue = getCell(productSizeWorkpieceLength, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductBlankSizesLengthValue.setMinimumHeight(13);
        cellProductBlankSizesLengthValue.setBorder(Rectangle.BOX);
        cellProductBlankSizesLengthValue.setPaddingBottom(4);
        middleTableTop.addCell(cellProductBlankSizesLengthValue);

        PdfPCell cellProductBlankSizesWidthValue = getCell(productSizeWorkpieceWidth, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductBlankSizesWidthValue.setMinimumHeight(13);
        cellProductBlankSizesWidthValue.setPaddingBottom(4);
        cellProductBlankSizesWidthValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(cellProductBlankSizesWidthValue);

        switch (version) {
            case "full":
                PdfPCell cellProductNumberOnBlankFormat = getCell("Кол-во с листа", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductNumberOnBlankFormat.setMinimumHeight(13);
                cellProductNumberOnBlankFormat.setPaddingBottom(4);
                cellProductNumberOnBlankFormat.setBorder(Rectangle.BOX);
                middleTableTop.addCell(cellProductNumberOnBlankFormat);

                PdfPCell cellProductNumberOnBlankFormatValue = getCell(productNumberBlankOnFormat, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductNumberOnBlankFormatValue.setColspan(2);
                cellProductNumberOnBlankFormatValue.setMinimumHeight(13);
                cellProductNumberOnBlankFormatValue.setPaddingBottom(4);
                cellProductNumberOnBlankFormatValue.setBorder(Rectangle.BOX);
                middleTableTop.addCell(cellProductNumberOnBlankFormatValue);
                break;
        }

        PdfPCell cellProductBlankFormat = getCell("Формат заготовки", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductBlankFormat.setMinimumHeight(13);
        cellProductBlankFormat.setPaddingBottom(4);
        cellProductBlankFormat.setBorder(Rectangle.BOX);
        middleTableTop.addCell(cellProductBlankFormat);

        PdfPCell cellProductBlankFormatValue = getCell(productBlankFormat, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductBlankFormatValue.setColspan(2);
        cellProductBlankFormatValue.setMinimumHeight(13);
        cellProductBlankFormatValue.setPaddingBottom(4);
        cellProductBlankFormatValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(cellProductBlankFormatValue);

        PdfPCell cellProductConnectionValve = getCell("Соедин. клапана", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductConnectionValve.setMinimumHeight(13);
        cellProductConnectionValve.setPaddingBottom(4);
        cellProductConnectionValve.setBorder(Rectangle.BOX);
        cellProductConnectionValve.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(cellProductConnectionValve);

        PdfPCell cellProductConnectionValveValue = getCell(productConnectionValve, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductConnectionValveValue.setColspan(2);
        cellProductConnectionValveValue.setMinimumHeight(13);
        cellProductConnectionValveValue.setPaddingBottom(4);
        cellProductConnectionValveValue.setBorder(Rectangle.BOX);
        cellProductConnectionValveValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(cellProductConnectionValveValue);


        PdfPCell cellProductStamp = getCell("Штамп", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductStamp.setMinimumHeight(13);
        cellProductStamp.setColspan(1);
        cellProductStamp.setBorder(Rectangle.BOX);
        cellProductStamp.setPaddingLeft(5);
        cellProductStamp.setPaddingBottom(4);
        cellProductStamp.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(cellProductStamp);

        PdfPCell cellProductStampValue = getCell(productStamp, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductStampValue.setColspan(3);
        cellProductStampValue.setMinimumHeight(13);
        cellProductStampValue.setPaddingLeft(2);
        cellProductStampValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(cellProductStampValue);

        PdfPCell cellProductCliche = getCell("Клише", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductCliche.setMinimumHeight(13);
        cellProductCliche.setColspan(1);
        cellProductCliche.setPaddingLeft(5);
        cellProductCliche.setBorder(Rectangle.BOX);
        cellProductCliche.setPaddingBottom(4);
        cellProductCliche.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(cellProductCliche);

        PdfPCell cellProductClicheValue = getCell(productCliche, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductClicheValue.setColspan(3);
        cellProductClicheValue.setPaddingLeft(2);
        cellProductClicheValue.setMinimumHeight(13);
        cellProductClicheValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(cellProductClicheValue);

        float[] columnWidthsLeftCellTableMiddle = {0.265f, 0.7f, 1.3f, 1f};
        PdfPTable middleTableMiddle = new PdfPTable(columnWidthsLeftCellTableMiddle);
        middleTableMiddle.setWidthPercentage(101);
        java.util.List<PrintDto> listPrint = product.getPrints();

        PdfPCell verticalTitlePrint = getCell("Печать", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForTittle, Font.BOLD);
        verticalTitlePrint.setRotation(-90);
        verticalTitlePrint.setRowspan(5);
        verticalTitlePrint.setBackgroundColor(COLOR);
        verticalTitlePrint.setBorder(Rectangle.BOX);
        middleTableMiddle.addCell(verticalTitlePrint);

        PdfPCell cellProductColor = getCell("Цвет", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductColor.setMinimumHeight(13);
        cellProductColor.setBorder(Rectangle.BOX);
        cellProductColor.setPaddingBottom(4);
        middleTableMiddle.addCell(cellProductColor);

        PdfPCell cellProductPrintName = getCell("Название", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductPrintName.setMinimumHeight(13);
        cellProductPrintName.setBorder(Rectangle.BOX);
        cellProductPrintName.setPaddingBottom(4);
        middleTableMiddle.addCell(cellProductPrintName);

        PdfPCell cellProductPrintPrice = getCell("S запечатки", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductPrintPrice.setMinimumHeight(13);
        cellProductPrintPrice.setBorder(Rectangle.BOX);
        cellProductPrintPrice.setPaddingBottom(4);
        middleTableMiddle.addCell(cellProductPrintPrice);

        if (listPrint != null && listPrint.size() > 0) {
            listPrint.forEach(pr -> {
                String color = pr.getColor() == null ? EMPTY_STRING : pr.getColor();
                PdfPCell printColor = getCell("", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                printColor.setBackgroundColor(hexToBaseColor(color));
                printColor.setMinimumHeight(13);
                printColor.setBorder(Rectangle.BOX);
                printColor.setPaddingBottom(4);
                middleTableMiddle.addCell(printColor);

                String name = (pr.getName() == null) ? EMPTY_STRING : pr.getName() == null ? EMPTY_STRING : pr.getName();
                PdfPCell printName = getCell(name, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                printName.setMinimumHeight(13);
                printName.setBorder(Rectangle.BOX);
                printName.setPaddingBottom(4);
                middleTableMiddle.addCell(printName);

                String price = (pr.getSquareSeal() == null) ? EMPTY_STRING : pr.getSquareSeal().toString();
                PdfPCell printPrice = getCell(price, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                printPrice.setMinimumHeight(13);
                printPrice.setBorder(Rectangle.BOX);
                printPrice.setPaddingBottom(4);
                middleTableMiddle.addCell(printPrice);
            });
        }

        int value = (listPrint == null) ? 4 : 4 - listPrint.size();
        for (int i = 0; i < value; i++) {
            PdfPCell printColor = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
            printColor.setMinimumHeight(13);
            printColor.setBorder(Rectangle.BOX);
            printColor.setPaddingBottom(4);
            middleTableMiddle.addCell(printColor);

            PdfPCell printName = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
            printName.setMinimumHeight(13);
            printName.setBorder(Rectangle.BOX);
            printName.setPaddingBottom(4);
            middleTableMiddle.addCell(printName);

            PdfPCell printPrice = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
            printPrice.setMinimumHeight(13);
            printPrice.setBorder(Rectangle.BOX);
            printPrice.setPaddingBottom(4);
            middleTableMiddle.addCell(printPrice);
        }

        float[] columnWidthsLeftCellTableBottom = {1.5f, 2.5f};
        PdfPTable middleTableBottom = new PdfPTable(columnWidthsLeftCellTableBottom);
        middleTableBottom.setWidthPercentage(101);

        PdfPCell producibilityNotes = getCell("Примечания", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.BOLD);
        producibilityNotes.setBorder(Rectangle.BOX);
        producibilityNotes.setColspan(5);
        producibilityNotes.setMinimumHeight(16);
        producibilityNotes.setBackgroundColor(COLOR);
        producibilityNotes.setPaddingLeft(8);
        producibilityNotes.setPaddingBottom(6);

        switch (version) {
            case "full":
                java.util.List<ProducibilityNotesDto> listNotes = product.getProducibilityNotes();
                if (listNotes != null && listNotes.size() > 0) {
                    middleTableBottom.addCell(producibilityNotes);

                    Map<String, String> notes = createProducibilityNotes(listNotes);

                    notes.forEach((center, note) -> {
                        PdfPCell cellProductNotesCenter = getCell(center, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                        cellProductNotesCenter.setBorder(Rectangle.BOX);
                        cellProductNotesCenter.setPaddingTop(-2);
                        cellProductNotesCenter.setPaddingLeft(2);
                        cellProductNotesCenter.setMinimumHeight(13);
                        cellProductNotesCenter.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        middleTableBottom.addCell(cellProductNotesCenter);

                        PdfPCell cellProductNote = getCell(note, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                        cellProductNote.setBorder(Rectangle.BOX);
                        cellProductNote.setPaddingTop(-1);
                        cellProductNote.setPaddingLeft(2);
                        cellProductNote.setMinimumHeight(13);
                        middleTableBottom.addCell(cellProductNote);
                    });
                }
                break;

        }

        middleCellTable.addElement(middleTableTop);
        middleCellTable.addElement(middleTableMiddle);
        middleCellTable.addElement(middleTableBottom);

        return middleCellTable;
    }

    private PdfPCell createRightTable(ProductDto product, BaseFont baseFont, int fontSizeForTittle, int fontSizeForColumns, String version) {
        PackingDto packing = product.getPacking();
        String productPacking = (packing == null)
                ? EMPTY_STRING : packing.getPacking() == null ? EMPTY_STRING : packing.getPacking();

        Integer numberInPack = product.getNumberInPack();
        String productNumberInPack = (numberInPack == null) ? EMPTY_STRING : numberInPack.toString();

        Integer numberInTransportPackage = product.getNumberInTransportPackage();
        String productTransportPackage = (numberInTransportPackage == null)
                ? EMPTY_STRING : numberInTransportPackage.toString();

        Integer packageLength = product.getPackageLength();
        String productPackageLength = (packageLength == null) ? EMPTY_STRING : packageLength.toString();

        Integer packageWidth = product.getPackageWidth();
        String productPackageWidth = (packageWidth == null) ? EMPTY_STRING : packageWidth.toString();

        Integer packageHeight = product.getPackageHeight();
        String productPackageHeight = (packageHeight == null) ? EMPTY_STRING : packageHeight.toString();

        PalletDto pallet = product.getPallet();
        String productPallet = (pallet == null)
                ? EMPTY_STRING : pallet.getPallet() == null ? EMPTY_STRING : pallet.getPallet();

        PalletPlacementDto palletPlacement = product.getPalletPlacement();
        String productPalletPlacement = (palletPlacement == null)
                ? EMPTY_STRING : palletPlacement.getPalletPlacement() == null ? EMPTY_STRING : palletPlacement.getPalletPlacement();

        Integer palletRows = product.getPalletRows();
        String productPalletRows = (palletRows == null) ? EMPTY_STRING : palletRows.toString();

        Integer loadCar = product.getNumberLoadCar();
        String productLoadCar = (loadCar == null) ? EMPTY_STRING : loadCar.toString();

        Integer productionFormat = product.getProductionFormat();
        String productProductionFormat = (productionFormat == null) ? EMPTY_STRING : productionFormat.toString();

        PdfPCell rightCellTable = new PdfPCell();
        rightCellTable.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTable = {0.35f, 1.6f, 0.5f, 0.9f, 0.7f};
        PdfPTable rightTable = new PdfPTable(columnWidthsLeftCellTable);
        rightTable.setWidthPercentage(101);

        PdfPCell verticalRightTitle = getCell("Авто", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForTittle, Font.BOLD);
        verticalRightTitle.setRotation(-90);
        verticalRightTitle.setRowspan(8);
        verticalRightTitle.setBackgroundColor(COLOR);
        verticalRightTitle.setBorder(Rectangle.BOX);
        rightTable.addCell(verticalRightTitle);

        PdfPCell cellProductPacking = getCell("Способ упаковки", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductPacking.setColspan(2);
        cellProductPacking.setMinimumHeight(13);
        cellProductPacking.setPaddingBottom(2);
        cellProductPacking.setBorder(Rectangle.BOX);
        cellProductPacking.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(cellProductPacking);

        PdfPCell cellProductPackingValue = getCell(productPacking, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductPackingValue.setColspan(2);
        cellProductPackingValue.setMinimumHeight(13);
        cellProductPackingValue.setPaddingBottom(2);
        cellProductPackingValue.setBorder(Rectangle.BOX);
        rightTable.addCell(cellProductPackingValue);

        PdfPCell cellNumberInPack = getCell("В пачке, шт", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellNumberInPack.setColspan(2);
        cellNumberInPack.setPaddingBottom(2);
        cellNumberInPack.setMinimumHeight(13);
        cellNumberInPack.setBorder(Rectangle.BOX);
        rightTable.addCell(cellNumberInPack);

        PdfPCell cellNumberInPackValue = getCell(productNumberInPack, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellNumberInPackValue.setMinimumHeight(13);
        cellNumberInPackValue.setPaddingBottom(2);
        cellNumberInPackValue.setColspan(2);
        cellNumberInPackValue.setBorder(Rectangle.BOX);
        rightTable.addCell(cellNumberInPackValue);

        PdfPCell cellNumberInTransportPackage = getCell("В паллета, шт", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellNumberInTransportPackage.setMinimumHeight(13);
        cellNumberInTransportPackage.setColspan(2);
        cellNumberInTransportPackage.setPaddingBottom(2);
        cellNumberInTransportPackage.setBorder(Rectangle.BOX);
        rightTable.addCell(cellNumberInTransportPackage);

        PdfPCell cellNumberInTransportPackageValue = getCell(productTransportPackage, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellNumberInTransportPackageValue.setMinimumHeight(13);
        cellNumberInTransportPackageValue.setColspan(2);
        cellNumberInTransportPackageValue.setPaddingBottom(2);
        cellNumberInTransportPackageValue.setBorder(Rectangle.BOX);
        rightTable.addCell(cellNumberInTransportPackageValue);

        PdfPCell packageSizes = getCell("Разм. пакета", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        packageSizes.setMinimumHeight(13);
        packageSizes.setPaddingBottom(2);
        packageSizes.setBorder(Rectangle.BOX);
        rightTable.addCell(packageSizes);

        PdfPCell cellPackageLength = getCell(productPackageLength, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellPackageLength.setMinimumHeight(13);
        cellPackageLength.setBorder(Rectangle.BOX);
        rightTable.addCell(cellPackageLength);

        PdfPCell cellPackageWidth = getCell(productPackageWidth, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellPackageWidth.setMinimumHeight(13);
        cellPackageWidth.setPaddingBottom(2);
        cellPackageWidth.setBorder(Rectangle.BOX);
        rightTable.addCell(cellPackageWidth);

        PdfPCell cellPackageHeight = getCell(productPackageHeight, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellPackageHeight.setMinimumHeight(13);
        cellPackageHeight.setPaddingBottom(2);
        cellPackageHeight.setBorder(Rectangle.BOX);
        rightTable.addCell(cellPackageHeight);

        PdfPCell cellProductPallet = getCell("Поддон", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductPallet.setMinimumHeight(13);
        cellProductPallet.setPaddingBottom(2);
        cellProductPallet.setColspan(2);
        cellProductPallet.setBorder(Rectangle.BOX);
        rightTable.addCell(cellProductPallet);

        PdfPCell cellProductPalletValue = getCell(productPallet, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductPalletValue.setMinimumHeight(13);
        cellProductPalletValue.setPaddingBottom(2);
        cellProductPalletValue.setColspan(2);
        cellProductPalletValue.setBorder(Rectangle.BOX);
        rightTable.addCell(cellProductPalletValue);


        PdfPCell cellPalletPlacement = getCell("Раскладка на поддоне", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellPalletPlacement.setMinimumHeight(13);
        cellPalletPlacement.setColspan(2);
        cellPalletPlacement.setPaddingBottom(2);
        cellPalletPlacement.setBorder(Rectangle.BOX);
        rightTable.addCell(cellPalletPlacement);

        PdfPCell palletPlacementValue = getCell(productPalletPlacement, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        palletPlacementValue.setMinimumHeight(13);
        palletPlacementValue.setPaddingBottom(2);
        palletPlacementValue.setColspan(2);
        palletPlacementValue.setBorder(Rectangle.BOX);
        rightTable.addCell(palletPlacementValue);

        PdfPCell cellNumberRows = getCell("Рядов на поддоне", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellNumberRows.setMinimumHeight(13);
        cellNumberRows.setColspan(2);
        cellNumberRows.setPaddingBottom(2);
        cellNumberRows.setBorder(Rectangle.BOX);
        cellNumberRows.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(cellNumberRows);

        PdfPCell cellNumberRowsValue = getCell(productPalletRows, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellNumberRowsValue.setMinimumHeight(13);
        cellNumberRowsValue.setPaddingBottom(2);
        cellNumberRowsValue.setColspan(2);
        cellNumberRowsValue.setBorder(Rectangle.BOX);
        rightTable.addCell(cellNumberRowsValue);

        PdfPCell cellLoadCar = getCell("Загрузка авто, шт", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellLoadCar.setMinimumHeight(13);
        cellLoadCar.setColspan(2);
        cellLoadCar.setPaddingBottom(2);
        cellLoadCar.setBorder(Rectangle.BOX);
        rightTable.addCell(cellLoadCar);

        PdfPCell loadCarValue = getCell(productLoadCar, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        loadCarValue.setMinimumHeight(13);
        loadCarValue.setColspan(2);
        loadCarValue.setPaddingBottom(2);
        loadCarValue.setBorder(Rectangle.BOX);
        rightTable.addCell(loadCarValue);

        switch (version) {
            case "full":
                rightCellTable.addElement(rightTable);

                float[] columnWidthLinks = new float[]{4f};
                PdfPTable linksTable = new PdfPTable(columnWidthLinks);
                linksTable.setWidthPercentage(101);

                java.util.List<String> productLinks = product.getFilePaths();
                java.util.List<String> productNames = new ArrayList<>(product.getMapFilePathNames().values());
                Boolean isNew = product.getIsNew();
                Integer productNumber = product.getProductNumber();
                String fullProductNumber = (productNumber == null && isNew == null) ?
                        EMPTY_STRING : ProductUtils.getFullProductNumber(productNumber, isNew);

                if (productLinks != null && productLinks.size() > 0 && !fullProductNumber.equals(EMPTY_STRING)) {
                    for (int i = 0; i < productLinks.size(); i++) {
                        Anchor anchor = new Anchor(productNames.get(i));
                        anchor.setReference(productLinks.get(i));

                        Phrase phrase = new Phrase();
                        phrase.add(anchor);
                        phrase.setFont(new Font(baseFont, 12, Font.NORMAL));
                        PdfPCell cellLink = new PdfPCell(phrase);
                        cellLink.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

                        cellLink.setMinimumHeight(11);
                        cellLink.setPaddingLeft(7);
                        cellLink.setPaddingTop(4);
                        cellLink.setPaddingBottom(4);
                        cellLink.setBorder(PdfPCell.LEFT + PdfPCell.RIGHT);
                        linksTable.addCell(cellLink);
                    }
                }

                rightCellTable.addElement(linksTable);

                float[] columnWidthFormat = new float[]{3f, 1f};
                PdfPTable formatTable = new PdfPTable(columnWidthFormat);
                formatTable.setWidthPercentage(101);
                PdfPCell cellProductionFormat = getCell("Производственный формат", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductionFormat.setMinimumHeight(13);
                cellProductionFormat.setPaddingLeft(7);
                cellProductionFormat.setBorder(Rectangle.BOX);
                formatTable.addCell(cellProductionFormat);

                PdfPCell cellProductionFormatValue = getCell(productProductionFormat, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductionFormatValue.setMinimumHeight(13);
                cellProductionFormatValue.setBorder(Rectangle.BOX);
                formatTable.addCell(cellProductionFormatValue);

                rightCellTable.addElement(formatTable);

                float[] bigovkiWidth = {0.5f, 0.2f, 0.5f, 0.2f, 0.5f, 0.5f};
                PdfPTable bigovkiTable = new PdfPTable(bigovkiWidth);
                bigovkiTable.setWidthPercentage(101);

                PdfPCell bigovki = getCell("Биговки", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.BOLD);
                bigovki.setMinimumHeight(16);
                bigovki.setColspan(6);
                bigovki.setPaddingBottom(4);
                bigovki.setBackgroundColor(COLOR);
                bigovki.setBorder(Rectangle.BOX);
                bigovkiTable.addCell(bigovki);

                java.util.List<BigovkiDto> bigovkiProduct = product.getBigovki();
                String bigovki1 = bigovkiProduct.size() > 0 && bigovkiProduct != null
                        ? (bigovkiProduct.get(0).getValue() != null ? bigovkiProduct.get(0).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;
                String bigovki2 = bigovkiProduct.size() > 1 && bigovkiProduct != null
                        ? (bigovkiProduct.get(1).getValue() != null ? bigovkiProduct.get(1).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;
                String bigovki3 = bigovkiProduct.size() > 2 && bigovkiProduct != null
                        ? (bigovkiProduct.get(2).getValue() != null ? bigovkiProduct.get(2).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;

                Integer numberBlanksOnFormat = product.getNumberBlanksOnFormat();
                String productNumberBlanksOnFormat = (numberBlanksOnFormat == null)
                        ? EMPTY_STRING : numberBlanksOnFormat.toString();

                PdfPCell bigovkiValue1 = getCell(bigovki1, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                bigovkiValue1.setMinimumHeight(13);
                bigovkiValue1.setPaddingTop(-1);
                bigovkiValue1.setBorder(Rectangle.BOX);
                bigovkiTable.addCell(bigovkiValue1);

                PdfPCell plusBigovki = getCell("+", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                plusBigovki.setMinimumHeight(13);
                plusBigovki.setPaddingTop(-1);
                plusBigovki.setBorder(Rectangle.BOX);
                bigovkiTable.addCell(plusBigovki);

                PdfPCell bigovkiValue2 = getCell(bigovki2, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                bigovkiValue2.setMinimumHeight(13);
                bigovkiValue2.setPaddingTop(-1);
                bigovkiValue2.setBorder(Rectangle.BOX);
                bigovkiTable.addCell(bigovkiValue2);

                bigovkiTable.addCell(plusBigovki);

                PdfPCell bigovkiValue3 = getCell(bigovki3, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                bigovkiValue3.setMinimumHeight(13);
                bigovkiValue3.setPaddingTop(-1);
                bigovkiValue3.setBorder(Rectangle.BOX);
                bigovkiTable.addCell(bigovkiValue3);

                PdfPCell bigovkiValue4 = getCell(productNumberBlanksOnFormat, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                bigovkiValue4.setMinimumHeight(13);
                bigovkiValue4.setPaddingTop(-1);
                bigovkiValue4.setBorder(Rectangle.BOX);
                bigovkiTable.addCell(bigovkiValue4);

                rightCellTable.addElement(bigovkiTable);

                float[] perforationsWidth = {0.5f, 0.5f, 0.5f, 0.5f, 0.5f};
                PdfPTable perforationsTable = new PdfPTable(perforationsWidth);
                perforationsTable.setWidthPercentage(101);

                PdfPCell perforations = getCell("Просечки", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.BOLD);
                perforations.setMinimumHeight(16);
                perforations.setColspan(6);
                perforations.setPaddingBottom(4);
                perforations.setBackgroundColor(COLOR);
                perforations.setBorder(Rectangle.BOX);
                perforationsTable.addCell(perforations);

                java.util.List<PerforationDto> perforationDtos = product.getPerforations();
                String perforation1 = perforationDtos.size() > 0 && perforationDtos != null
                        ? (perforationDtos.get(0).getValue() != null
                        ? perforationDtos.get(0).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;

                String perforation2 = perforationDtos.size() > 1 && perforationDtos != null
                        ? (perforationDtos.get(1).getValue() != null
                        ? perforationDtos.get(1).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;

                String perforation3 = perforationDtos.size() > 2 && perforationDtos != null
                        ? (perforationDtos.get(2).getValue() != null
                        ? perforationDtos.get(2).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;

                String perforation4 = perforationDtos.size() > 3 && perforationDtos != null
                        ? (perforationDtos.get(3).getValue() != null
                        ? perforationDtos.get(3).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;

                String perforation5 = perforationDtos.size() > 4 && perforationDtos != null
                        ? (perforationDtos.get(4).getValue() != null
                        ? perforationDtos.get(4).getValue().toString() : EMPTY_STRING) : EMPTY_STRING;

                PdfPCell perforationsValue1 = getCell(perforation1, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                perforationsValue1.setMinimumHeight(13);
                perforationsValue1.setPaddingTop(-1);
                perforationsValue1.setBorder(Rectangle.BOX);
                perforationsTable.addCell(perforationsValue1);

                PdfPCell perforationsValue2 = getCell(perforation2, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                perforationsValue2.setMinimumHeight(13);
                perforationsValue2.setPaddingTop(-1);
                perforationsValue2.setBorder(Rectangle.BOX);
                perforationsTable.addCell(perforationsValue2);

                PdfPCell perforationsValue3 = getCell(perforation3, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                perforationsValue3.setMinimumHeight(13);
                perforationsValue3.setPaddingTop(-1);
                perforationsValue3.setBorder(Rectangle.BOX);
                perforationsTable.addCell(perforationsValue3);

                PdfPCell perforationsValue4 = getCell(perforation4, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                perforationsValue4.setMinimumHeight(13);
                perforationsValue4.setPaddingTop(-1);
                perforationsValue4.setBorder(Rectangle.BOX);
                perforationsTable.addCell(perforationsValue4);

                PdfPCell perforationsValue5 = getCell(perforation5, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                perforationsValue5.setMinimumHeight(13);
                perforationsValue5.setPaddingTop(-1);
                perforationsValue5.setBorder(Rectangle.BOX);
                perforationsTable.addCell(perforationsValue5);

                rightCellTable.addElement(perforationsTable);

                break;
            default: {
                rightCellTable.addElement(rightTable);
            }
        }

        return rightCellTable;
    }

    private PdfPCell createLeftTable(ProductDto product, BaseFont baseFont, int fontSizeForTitle, int fontSizeForColumns, String version) {
        Integer innerLength = product.getInnerLength();
        String productInnerLength = (innerLength == null) ? EMPTY_STRING : innerLength.toString();

        Integer innerWidth = product.getInnerWidth();
        String productInnerWidth = (innerWidth == null) ? EMPTY_STRING : innerWidth.toString();

        Integer innerHeight = product.getInnerHeight();
        String productInnerHeight = (innerHeight == null) ? EMPTY_STRING : innerHeight.toString();

        Double theoreticalSquare = product.getTheoreticalSquare();
        String productTheoreticalSquare = (theoreticalSquare == null) ? EMPTY_STRING : theoreticalSquare.toString();

        Double actualSquare = product.getActualSquare();
        String productActualSquare = (actualSquare == null) ? EMPTY_STRING : actualSquare.toString();

        FormatDto format = product.getFormat();
        String productFormat = (format == null)
                ? EMPTY_STRING : format.getFormat() == null ? EMPTY_STRING : format.getFormat();

        ProfileDto profile = product.getProfile();
        String productProfile = (profile == null)
                ? EMPTY_STRING : profile.getProfile() == null ? EMPTY_STRING : profile.getProfile();

        CardboardBrandDto cardboardBrand = product.getCardboardBrand();
        String productCardboardBrand = (cardboardBrand == null)
                ? EMPTY_STRING : cardboardBrand.getCardboardBrand() == null ? EMPTY_STRING : cardboardBrand.getCardboardBrand();

        CelluloseLayerDto celluloseLayer = product.getCelluloseLayer();
        String productCelluloseLayer = (celluloseLayer == null)
                ? EMPTY_STRING : celluloseLayer.getCelluloseLayer() == null ? EMPTY_STRING : celluloseLayer.getCelluloseLayer();

        FaceLayerDto faceLayer = product.getFaceLayer();
        String productFaceLayer = (faceLayer == null)
                ? EMPTY_STRING : faceLayer.getFaceLayer() == null ? EMPTY_STRING : faceLayer.getFaceLayer();

        InnerLayerDto innerLayer = product.getInnerLayer();
        String productInnerLayer = (innerLayer == null)
                ? EMPTY_STRING : innerLayer.getInnerLayer() == null ? EMPTY_STRING : innerLayer.getInnerLayer();

        String material = product.getMaterial();
        String productMaterial = (material == null) ? EMPTY_STRING : material;

        String specialConditions = product.getSpecialConditions();
        String productSpecialConditions = (specialConditions == null) ? EMPTY_STRING : specialConditions;

        PdfPCell leftCellTable = new PdfPCell();
        leftCellTable.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTable = {0.28f, 1.25f, 0.95f, 1.45f, 0.95f};
        PdfPTable leftTable = new PdfPTable(columnWidthsLeftCellTable);
        leftTable.setWidthPercentage(101);

        PdfPCell verticalTitle = getCell("Продукция", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForTitle, Font.BOLD);
        verticalTitle.setRotation(-90);
        int rowSpanForTitle = "full".equals(version) ? 5 : 4;
        verticalTitle.setRowspan(rowSpanForTitle);
        verticalTitle.setBackgroundColor(COLOR);
        verticalTitle.setBorder(Rectangle.BOX);
        leftTable.addCell(verticalTitle);

        PdfPCell productInnerSizes = getCell("Размеры внутр.", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productInnerSizes.setMinimumHeight(13);
        productInnerSizes.setPaddingBottom(4);
        productInnerSizes.setBorder(Rectangle.BOX);
        leftTable.addCell(productInnerSizes);

        PdfPCell cellProductInnerLength = getCell(productInnerLength, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductInnerLength.setBorder(Rectangle.BOX);
        cellProductInnerLength.setPaddingBottom(4);
        cellProductInnerLength.setMinimumHeight(13);
        leftTable.addCell(cellProductInnerLength);

        PdfPCell cellProductInnerWidth = getCell(productInnerWidth, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductInnerWidth.setBorder(Rectangle.BOX);
        cellProductInnerWidth.setMinimumHeight(13);
        cellProductInnerWidth.setPaddingBottom(4);
        leftTable.addCell(cellProductInnerWidth);

        PdfPCell cellProductInnerHeight = getCell(productInnerHeight, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductInnerHeight.setBorder(Rectangle.BOX);
        cellProductInnerHeight.setMinimumHeight(13);
        cellProductInnerHeight.setPaddingBottom(4);
        leftTable.addCell(cellProductInnerHeight);

        PdfPCell cellProductProfile;
        PdfPCell cellProductProfileValue;
        switch (version) {
            case "full":
                PdfPCell cellTheoreticalSquare = getCell("S теор.", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellTheoreticalSquare.setBorder(Rectangle.BOX);
                cellTheoreticalSquare.setPaddingBottom(4);
                cellTheoreticalSquare.setMinimumHeight(13);
                leftTable.addCell(cellTheoreticalSquare);

                PdfPCell cellTheoreticalSquareValue = getCell(productTheoreticalSquare, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellTheoreticalSquareValue.setBorder(Rectangle.BOX);
                cellTheoreticalSquareValue.setPaddingBottom(4);
                cellTheoreticalSquareValue.setMinimumHeight(13);
                leftTable.addCell(cellTheoreticalSquareValue);

                PdfPCell cellActualSquare = getCell("S факт.", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellActualSquare.setBorder(Rectangle.BOX);
                cellActualSquare.setPaddingBottom(4);
                cellActualSquare.setMinimumHeight(13);
                leftTable.addCell(cellActualSquare);

                PdfPCell cellActualSquareValue = getCell(productActualSquare, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellActualSquareValue.setBorder(Rectangle.BOX);
                cellActualSquareValue.setPaddingBottom(4);
                cellActualSquareValue.setMinimumHeight(13);
                leftTable.addCell(cellActualSquareValue);

                PdfPCell cellProductFormat = getCell("Расч. формат", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductFormat.setBorder(Rectangle.BOX);
                cellProductFormat.setPaddingBottom(4);
                cellProductFormat.setMinimumHeight(13);
                leftTable.addCell(cellProductFormat);

                PdfPCell cellProductFormatValue = getCell(productFormat, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductFormatValue.setBorder(Rectangle.BOX);
                cellProductFormatValue.setPaddingBottom(4);
                cellProductFormatValue.setMinimumHeight(13);
                leftTable.addCell(cellProductFormatValue);

                cellProductProfile = getCell("Профиль", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductProfile.setBorder(Rectangle.BOX);
                cellProductProfile.setPaddingBottom(4);
                cellProductProfile.setMinimumHeight(13);
                leftTable.addCell(cellProductProfile);

                cellProductProfileValue = getCell(productProfile, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductProfileValue.setBorder(Rectangle.BOX);
                cellProductProfileValue.setPaddingBottom(4);
                cellProductProfileValue.setMinimumHeight(13);
                leftTable.addCell(cellProductProfileValue);
                break;
            default: {
                cellProductProfile = getCell("Профиль", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductProfile.setBorder(Rectangle.BOX);
                cellProductProfile.setPaddingBottom(4);
                cellProductProfile.setMinimumHeight(13);
                leftTable.addCell(cellProductProfile);

                cellProductProfileValue = getCell(productProfile, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                cellProductProfileValue.setBorder(Rectangle.BOX);
                cellProductProfileValue.setPaddingBottom(4);
                cellProductProfileValue.setMinimumHeight(13);
                leftTable.addCell(cellProductProfileValue);

                PdfPCell emptyCell = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                emptyCell.setBorder(Rectangle.BOX);
                emptyCell.setColspan(2);
                emptyCell.setMinimumHeight(13);
                leftTable.addCell(emptyCell);
            }
        }

        PdfPCell cellProductCardboardBrand = getCell("Марка картона", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductCardboardBrand.setBorder(Rectangle.BOX);
        cellProductCardboardBrand.setPaddingBottom(4);
        cellProductCardboardBrand.setMinimumHeight(13);
        leftTable.addCell(cellProductCardboardBrand);

        PdfPCell cellProductCardboardBrandValue = getCell(productCardboardBrand, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductCardboardBrandValue.setBorder(Rectangle.BOX);
        cellProductCardboardBrandValue.setPaddingBottom(4);
        cellProductCardboardBrandValue.setMinimumHeight(13);
        leftTable.addCell(cellProductCardboardBrandValue);


        PdfPCell cellProductCelluloseLayer = getCell("Целюлозный слой", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductCelluloseLayer.setBorder(Rectangle.BOX);
        cellProductCelluloseLayer.setPaddingBottom(4);
        cellProductCelluloseLayer.setMinimumHeight(13);
        leftTable.addCell(cellProductCelluloseLayer);

        PdfPCell cellProductCelluloseLayerValue = getCell(productCelluloseLayer, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductCelluloseLayerValue.setBorder(Rectangle.BOX);
        cellProductCelluloseLayerValue.setPaddingBottom(4);
        cellProductCelluloseLayerValue.setMinimumHeight(13);
        leftTable.addCell(cellProductCelluloseLayerValue);

        PdfPCell cellProductFaceLayer = getCell("Лицевой слой", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductFaceLayer.setMinimumHeight(13);
        cellProductFaceLayer.setPaddingBottom(4);
        cellProductFaceLayer.setBorder(Rectangle.BOX);
        leftTable.addCell(cellProductFaceLayer);

        PdfPCell cellProductFaceLayerValue = getCell(productFaceLayer, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductFaceLayerValue.setBorder(Rectangle.BOX);
        cellProductFaceLayerValue.setPaddingBottom(4);
        cellProductFaceLayerValue.setMinimumHeight(13);
        leftTable.addCell(cellProductFaceLayerValue);

        PdfPCell cellProductInnerLayer = getCell("Внутренний слой", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductInnerLayer.setBorder(Rectangle.BOX);
        cellProductInnerLayer.setPaddingBottom(4);
        cellProductInnerLayer.setMinimumHeight(13);
        leftTable.addCell(cellProductInnerLayer);

        PdfPCell cellProductInnerLayerValue = getCell(productInnerLayer, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductInnerLayerValue.setBorder(Rectangle.BOX);
        cellProductInnerLayerValue.setPaddingBottom(4);
        cellProductInnerLayerValue.setMinimumHeight(13);
        leftTable.addCell(cellProductInnerLayerValue);


        PdfPCell verticalMaterial = getCell("Материал", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForTitle, Font.BOLD);
        verticalMaterial.setRotation(-90);
        verticalMaterial.setPadding(2);
        verticalMaterial.setBackgroundColor(COLOR);
        verticalMaterial.setBorder(Rectangle.BOX);

        PdfPCell verticalMaterialValue = getCell(productMaterial, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        verticalMaterialValue.setBorder(Rectangle.BOX);
        verticalMaterialValue.setColspan(4);
        verticalMaterialValue.setPaddingTop(-2);
        verticalMaterialValue.setPaddingLeft(2);
        verticalMaterialValue.setMinimumHeight(50);
        switch (version) {
            case "full":
                leftTable.addCell(verticalMaterial);
                leftTable.addCell(verticalMaterialValue);
                break;
        }

        PdfPCell cellProductSpecialConditions = getCell("Особые условия", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.BOLD);
        cellProductSpecialConditions.setBorder(Rectangle.BOX);
        cellProductSpecialConditions.setColspan(5);
        cellProductSpecialConditions.setMinimumHeight(16);
        cellProductSpecialConditions.setBackgroundColor(COLOR);
        cellProductSpecialConditions.setPaddingLeft(8);
        cellProductSpecialConditions.setPaddingBottom(6);
        leftTable.addCell(cellProductSpecialConditions);

        PdfPCell cellProductSpecialConditionsValue = getCell(productSpecialConditions, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cellProductSpecialConditionsValue.setBorder(Rectangle.BOX);
        cellProductSpecialConditionsValue.setColspan(5);
        cellProductSpecialConditionsValue.setPaddingLeft(2);
        cellProductSpecialConditionsValue.setPaddingTop(-2);
        cellProductSpecialConditionsValue.setMinimumHeight(50);
        leftTable.addCell(cellProductSpecialConditionsValue);

        PdfPCell producibility = getCell("Технологичность", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.BOLD);
        producibility.setBorder(Rectangle.BOX);
        producibility.setColspan(5);
        producibility.setMinimumHeight(16);
        producibility.setBackgroundColor(COLOR);
        producibility.setPaddingLeft(8);
        producibility.setPaddingBottom(6);

        java.util.List<ProducibilityNotesDto> listNotes = product.getProducibilityNotes();
        PdfPCell producibilityValue;
        if (listNotes != null && listNotes.size() > 0) {
            Map<String, String> notes = createProducibilityNotes(listNotes);

            final String[] resultProducibility = {""};
            notes.forEach((center, note) -> resultProducibility[0] += center + "   ");

            producibilityValue = getCell(resultProducibility[0], PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        } else {
            producibilityValue = getCell(EMPTY_STRING, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        }

        producibilityValue.setBorder(Rectangle.BOX);
        producibilityValue.setColspan(5);
        producibilityValue.setPaddingLeft(7);
        producibilityValue.setPaddingTop(-2);
        producibilityValue.setMinimumHeight(50);


        switch (version) {
            case "full":
                leftTable.addCell(producibility);
                leftTable.addCell(producibilityValue);
                break;
        }

        leftCellTable.addElement(leftTable);

        return leftCellTable;
    }

    private PdfPCell getCell(String text, int alignment, BaseFont font, int fontSize, int fontStyle) {
        Phrase phrase = new Phrase();
        phrase.setFont(new Font(font, fontSize, fontStyle));
        phrase.add(text);

        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private Map<String, String> createProducibilityNotes(List<ProducibilityNotesDto> listNotes) {
        Map<ProducibilityDto, String> producibilityCenters = new LinkedHashMap<>();
        listNotes.forEach(note -> producibilityCenters.put(note.getServiceCenter(), note.getNote()));

        Set<Integer> valuesPriority = new TreeSet<>();
        listNotes.forEach(productNote -> valuesPriority.add(productNote.getServiceCenter().getGroupPriority()));

        Map<Integer, List<String>> result = new LinkedHashMap<>();
        valuesPriority.forEach(integer -> {
            List<String> list = new ArrayList<>();
            producibilityCenters.forEach((producibility, note) -> {
                if (producibility.getGroupPriority().equals(integer))
                    list.add(producibility.getServiceCenter());
            });
            result.put(integer, list);
        });

        Map<String, String> finalMap = new LinkedHashMap<>();
        result.forEach((integer, notes) -> {
            String resultString = "";
            final String[] note = {""};
            for (int i = 0; i < notes.size(); i++) {
                if (i != notes.size() - 1) {
                    resultString += notes.get(i) + "/";
                } else {
                    resultString += notes.get(i);
                }

                int finalI = i;
                producibilityCenters.forEach((producibilityDto, s) -> {
                    if (producibilityDto.getServiceCenter().equals(notes.get(finalI))) {
                        note[0] += s;
                    }
                });
            }
            finalMap.put(resultString, note[0]);
            resultString = "";
            note[0] = "";
        });

        return finalMap;
    }

    private BaseColor hexToBaseColor(String hexColor) {
        final int[] rgb = new int[3];
        if (hexColor.length() == 6) {
            for (int i = 0; i < 3; i++)
                rgb[i] = Integer.parseInt(hexColor.substring(i * 2, i * 2 + 2), 16);
            return new BaseColor(rgb[0], rgb[1], rgb[2]);
        } else
            return new BaseColor(255, 255, 255);
    }
}