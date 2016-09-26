package ua.skillsup.gelius.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ua.skillsup.gelius.model.dto.BigovkiDto;
import ua.skillsup.gelius.model.dto.PerforationDto;
import ua.skillsup.gelius.model.dto.ProducibilityNotesDto;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.util.ProductUtils;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
// not completed
public class PdfBuilder {

    private static final String EMPTY_STRING = "";
    private static final BaseColor COLOR = new BaseColor(182, 215, 168);
    private static final String FONT_PATH = "/fonts/Colibri.ttf";
    private static final Rectangle PAGE_SIZE = PageSize.A4.rotate();

    public static void main(String[] args) throws Exception {
        createPdfFile("someFileName", "full");
    }

    public static Document createPdfFile(String fileName, String version) throws Exception {
        BaseFont baseFont = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Document document = new Document(PAGE_SIZE, 36, 36, 15, 15);

        PdfWriter.getInstance(document, new FileOutputStream("config/HelloWorld.pdf"));

        document.open();

        ProductDto product = createProduct();

        Map<String, PdfPTable[]> header = createHeader(product, version, baseFont);

        for (Map.Entry<String, PdfPTable[]> entry : header.entrySet()) {
            for (PdfPTable pdfPTable : entry.getValue()) {
                document.add(pdfPTable);
            }
        }

        PdfPTable body = createPdfBody(product, version, baseFont);

        document.add(body);
        document.close();

        return document;
    }

    private static Map<String, PdfPTable[]> createHeader(ProductDto product, String version, BaseFont baseFont){
        Map<String, PdfPTable[]> map = new LinkedHashMap<>();

        PdfPTable[] headerTop = createHeaderTop(product, baseFont, version);
        PdfPTable[] headerBottom = createHeaderBottom(product, baseFont, version);

        map.put("headerTop", headerTop);
        map.put("headerBottom", headerBottom);

        return map;
    }

    private static PdfPTable createPdfBody(ProductDto product, String version, BaseFont baseFont){
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

    private static PdfPTable[] createHeaderTop(ProductDto product, BaseFont baseFont, String version){
        String fullProductNumber = ProductUtils.getFullProductNumber(product.getProductNumber(), product.getIsNew());
        String productCreatedDate = product.getProductCreateDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String productUpdatedDate = product.getProductUpdateDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String isUse = product.getIsUse() ? "Тех. карта используется" : "Tex. карта не используется";

        // First table
        float[] columnWidths = {5f, 1.5f};
        PdfPTable titleAndCreatedDateTable = new PdfPTable(columnWidths);
        titleAndCreatedDateTable.setWidthPercentage(100);

        PdfPCell cellTitleCreatedDateTable1 = getCell("Техкарта № " + fullProductNumber, PdfPCell.ALIGN_CENTER, baseFont, 18, Font.BOLD);
        cellTitleCreatedDateTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cellTitleCreatedDateTable1.setPaddingLeft(75);
        titleAndCreatedDateTable.addCell(cellTitleCreatedDateTable1);

        PdfPCell cellTitleCreatedDateTable2 = getCell("Создано: " + productCreatedDate, PdfPCell.ALIGN_LEFT, baseFont, 12, Font.NORMAL);
        cellTitleCreatedDateTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTitleCreatedDateTable2.setPaddingLeft("full".equals(version) ? 35 : 60);
        cellTitleCreatedDateTable2.setPaddingBottom(-5);
        titleAndCreatedDateTable.addCell(cellTitleCreatedDateTable2);

        //Second table
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
                //Third table
                PdfPTable preparedTable = new PdfPTable(columnWidths);
                preparedTable.setWidthPercentage(100);

                PdfPCell cellPreparedTable1 = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 12, Font.NORMAL);
                cellPreparedTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
                preparedTable.addCell(cellPreparedTable1);

                PdfPCell cellPreparedTable2 = getCell("Подготовил: " + product.getPersonPrepared(), PdfPCell.ALIGN_RIGHT, baseFont, 12, Font.NORMAL);
                cellPreparedTable2.setPaddingTop(2);
                cellPreparedTable2.setPaddingRight(-10);
                cellPreparedTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                preparedTable.addCell(cellPreparedTable2);

                //Fourth table
                PdfPTable isUseTable = new PdfPTable(columnWidths);
                isUseTable.setWidthPercentage(100);

                PdfPCell cellIsUseTable1 = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 12, Font.NORMAL);
                cellIsUseTable1.setVerticalAlignment(Element.ALIGN_BOTTOM);
                isUseTable.addCell(cellIsUseTable1);


                PdfPCell cellIsUseTable2 = getCell(isUse, PdfPCell.ALIGN_RIGHT, baseFont, 10, Font.NORMAL);
                cellIsUseTable2.setPaddingTop(2);
                cellIsUseTable2.setPaddingRight(20);
                cellIsUseTable2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                isUseTable.addCell(cellIsUseTable2);
                return new PdfPTable[]{titleAndCreatedDateTable, updatedDateTable, preparedTable, isUseTable};
        }

        return new PdfPTable[]{titleAndCreatedDateTable, updatedDateTable};
    }

    private static PdfPTable[] createHeaderBottom(ProductDto product, BaseFont baseFont, String version){
        String productClient = product.getClient().getLastName();
        String productName = product.getProductName();
        String productType = product.getProductType().getProductType();

        float[] columnWidths = {0.6f, 2f, 1.5f, 1.5f, 1.5f, 1.8f, 2f};
        PdfPTable tableHeader = new PdfPTable(columnWidths);
        tableHeader.setWidthPercentage(100);

        // Customer
        PdfPCell client = getCell("Заказчик", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        client.setVerticalAlignment(Element.ALIGN_MIDDLE);
        client.setPaddingLeft(-20);
        client.setPaddingBottom(15);

        PdfPCell clientProduct = getCell(productClient, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        clientProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
        clientProduct.setPaddingBottom(15);

        // Product Name
        PdfPCell name = getCell("Название", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        name.setVerticalAlignment(Element.ALIGN_MIDDLE);
        name.setPaddingLeft(40);
        name.setPaddingBottom(15);

        PdfPCell nameProduct = getCell(productName, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        nameProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
        nameProduct.setPaddingBottom(15);

        // Product Type
        PdfPCell type = getCell("Тип изделия", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        type.setVerticalAlignment(Element.ALIGN_MIDDLE);
        type.setPaddingLeft(20);
        type.setPaddingBottom(15);

        PdfPCell typeProduct = getCell(productType, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        typeProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
        typeProduct.setPaddingLeft(-5);
        typeProduct.setPaddingBottom(15);

        PdfPCell emptyCell = getCell(EMPTY_STRING, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        emptyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        emptyCell.setPaddingBottom(15);

        switch (version){
            case "full" : {
                client.setPaddingTop(-40);
                nameProduct.setPaddingTop(-40);
                typeProduct.setPaddingTop(-40);
                name.setPaddingTop(-40);
                clientProduct.setPaddingTop(-40);
                type.setPaddingTop(-40);
                emptyCell.setPaddingTop(-40);
                break;
            }
            default:{
                client.setPaddingTop(-7);
                nameProduct.setPaddingTop(-7);
                type.setPaddingTop(-7);
                emptyCell.setPaddingTop(-7);
                name.setPaddingTop(-7);
                typeProduct.setPaddingTop(-7);
                clientProduct.setPaddingTop(-7);
            }
        }

        tableHeader.addCell(client);
        tableHeader.addCell(clientProduct);
        tableHeader.addCell(name);
        tableHeader.addCell(nameProduct);
        tableHeader.addCell(type);
        tableHeader.addCell(typeProduct);
        tableHeader.addCell(emptyCell);

        return new PdfPTable[]{tableHeader};
    }

    private static PdfPCell createMiddleTable(ProductDto product, BaseFont baseFont, int fontSizeForTittle, int fontSizeForColumns, String version){
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

        PdfPCell blankSizes = getCell("Разм. заготовки", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        blankSizes.setMinimumHeight(13);
        blankSizes.setBorder(Rectangle.BOX);
        blankSizes.setPaddingBottom(4);
        middleTableTop.addCell(blankSizes);

        PdfPCell blankSizesLengthValue = getCell(product.getSizeWorkpieceLength().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        blankSizesLengthValue.setMinimumHeight(13);
        blankSizesLengthValue.setBorder(Rectangle.BOX);
        blankSizesLengthValue.setPaddingBottom(4);
        middleTableTop.addCell(blankSizesLengthValue);

        PdfPCell blankSizesWidthValue = getCell(product.getSizeWorkpieceWidth().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        blankSizesWidthValue.setMinimumHeight(13);
        blankSizesWidthValue.setPaddingBottom(4);
        blankSizesWidthValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(blankSizesWidthValue);

        switch (version) {
            case "full":
                PdfPCell numberInBlank = getCell("Кол-во с листа", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                numberInBlank.setMinimumHeight(13);
                numberInBlank.setPaddingBottom(4);
                numberInBlank.setBorder(Rectangle.BOX);
                middleTableTop.addCell(numberInBlank);

                PdfPCell numberInBlankValue = getCell(product.getNumberBlanksOnFormat().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                numberInBlankValue.setColspan(2);
                numberInBlankValue.setMinimumHeight(13);
                numberInBlankValue.setPaddingBottom(4);
                numberInBlankValue.setBorder(Rectangle.BOX);
                middleTableTop.addCell(numberInBlankValue);
                break;
        }


        PdfPCell blankFormat = getCell("Формат заготовки", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        blankFormat.setMinimumHeight(13);
        blankFormat.setPaddingBottom(4);
        blankFormat.setBorder(Rectangle.BOX);
        middleTableTop.addCell(blankFormat);

        PdfPCell blankFormatValue = getCell(product.getBlankFormat().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        blankFormatValue.setColspan(2);
        blankFormatValue.setMinimumHeight(13);
        blankFormatValue.setPaddingBottom(4);
        blankFormatValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(blankFormatValue);

        PdfPCell connectionValve = getCell("Соедин. клапана", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        connectionValve.setMinimumHeight(13);
        connectionValve.setPaddingBottom(4);
        connectionValve.setBorder(Rectangle.BOX);
        connectionValve.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(connectionValve);

        PdfPCell connectionValveValue = getCell(product.getConnectionValve().getConnectionValve(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        connectionValveValue.setColspan(2);
        connectionValveValue.setMinimumHeight(13);
        connectionValveValue.setPaddingBottom(4);
        connectionValveValue.setBorder(Rectangle.BOX);
        connectionValveValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(connectionValveValue);


        PdfPCell stamp = getCell("Штамп", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        stamp.setMinimumHeight(13);
        stamp.setColspan(1);
        stamp.setBorder(Rectangle.BOX);
        stamp.setPaddingLeft(5);
        stamp.setPaddingBottom(4);
        stamp.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(stamp);

        PdfPCell stampValue = getCell(product.getStamp(), PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        stampValue.setColspan(3);
        stampValue.setMinimumHeight(13);
        stampValue.setPaddingLeft(2);
        stampValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(stampValue);

        PdfPCell cliche = getCell("Клише", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        cliche.setMinimumHeight(13);
        cliche.setColspan(1);
        cliche.setPaddingLeft(5);
        cliche.setBorder(Rectangle.BOX);
        cliche.setPaddingBottom(4);
        cliche.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(cliche);

        PdfPCell clicheValue = getCell(product.getCliche(), PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        clicheValue.setColspan(3);
        clicheValue.setPaddingLeft(2);
        clicheValue.setMinimumHeight(13);
        clicheValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(clicheValue);

        PdfPCell middleCellTableBottom = new PdfPCell();
        middleCellTableBottom.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTableBottom = {0.265f, 0.7f, 1.3f, 1f};
        PdfPTable middleTableBottom = new PdfPTable(columnWidthsLeftCellTableBottom);
        middleTableBottom.setWidthPercentage(101);

        PdfPCell verticalTitlePrint = getCell("Печать", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForTittle, Font.BOLD);
        verticalTitlePrint.setRotation(-90);
        verticalTitlePrint.setRowspan(5);
        verticalTitlePrint.setBackgroundColor(COLOR);
        verticalTitlePrint.setBorder(Rectangle.BOX);
        middleTableBottom.addCell(verticalTitlePrint);

        PdfPCell color = getCell("Цвет", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        color.setMinimumHeight(13);
        color.setBorder(Rectangle.BOX);
        color.setPaddingBottom(4);
        middleTableBottom.addCell(color);

        PdfPCell printName = getCell("Название", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        printName.setMinimumHeight(13);
        printName.setBorder(Rectangle.BOX);
        printName.setPaddingBottom(4);
        middleTableBottom.addCell(printName);

        PdfPCell pricePrint = getCell("S запечатки", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        pricePrint.setMinimumHeight(13);
        pricePrint.setBorder(Rectangle.BOX);
        pricePrint.setPaddingBottom(4);
        middleTableBottom.addCell(pricePrint);

        for (int i = 0; i < 12; i++) {
            PdfPCell print = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
            print.setMinimumHeight(13);
            print.setBorder(Rectangle.BOX);
            print.setPaddingBottom(4);
            middleTableBottom.addCell(print);
        }

        PdfPCell producibilityNotes = getCell("Примечания", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.BOLD);
        producibilityNotes.setBorder(Rectangle.BOX);
        producibilityNotes.setColspan(5);
        producibilityNotes.setMinimumHeight(16);
        producibilityNotes.setBackgroundColor(COLOR);
        producibilityNotes.setPaddingLeft(8);
        producibilityNotes.setPaddingBottom(6);

        switch (version) {
            case "full":
                middleTableBottom.addCell(producibilityNotes);
                product.getProducibilityNotes().forEach(productNote -> {
                    String serviceCenter = productNote.getServiceCenter().getServiceCenter();
                    String note = productNote.getNote();

                    PdfPCell productNotesCenter = getCell(serviceCenter, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                    productNotesCenter.setBorder(Rectangle.BOX);
                    productNotesCenter.setColspan(2);
                    productNotesCenter.setPaddingTop(-2);
                    productNotesCenter.setPaddingLeft(2);
                    productNotesCenter.setMinimumHeight(13);
                    productNotesCenter.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    middleTableBottom.addCell(productNotesCenter);

                    PdfPCell prNote = getCell(note, PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                    prNote.setBorder(Rectangle.BOX);
                    prNote.setColspan(3);
                    prNote.setPaddingTop(-2);
                    prNote.setPaddingLeft(2);
                    prNote.setMinimumHeight(13);
                    middleTableBottom.addCell(prNote);
                });
                break;
        }

        middleCellTable.addElement(middleTableTop);
        middleCellTable.addElement(middleTableBottom);

        return middleCellTable;
    }

    private static PdfPCell createRightTable(ProductDto product, BaseFont baseFont, int fontSizeForTittle, int fontSizeForColumns, String version){
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

        PdfPCell productPacking = getCell("Способ упаковки", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productPacking.setColspan(2);
        productPacking.setMinimumHeight(13);
        productPacking.setPaddingBottom(2);
        productPacking.setBorder(Rectangle.BOX);
        productPacking.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(productPacking);

        PdfPCell productPackingValue = getCell(product.getPacking().getPacking(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productPackingValue.setColspan(2);
        productPackingValue.setMinimumHeight(13);
        productPackingValue.setPaddingBottom(2);
        productPackingValue.setBorder(Rectangle.BOX);
        rightTable.addCell(productPackingValue);

        PdfPCell numberInPack = getCell("В пачке, шт", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        numberInPack.setColspan(2);
        numberInPack.setPaddingBottom(2);
        numberInPack.setMinimumHeight(13);
        numberInPack.setBorder(Rectangle.BOX);
        rightTable.addCell(numberInPack);

        PdfPCell numberInPackValue = getCell(product.getNumberInPack().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        numberInPackValue.setMinimumHeight(13);
        numberInPackValue.setPaddingBottom(2);
        numberInPackValue.setColspan(2);
        numberInPackValue.setBorder(Rectangle.BOX);
        rightTable.addCell(numberInPackValue);

        PdfPCell numberInTransportPackage = getCell("В паллета, шт", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        numberInTransportPackage.setMinimumHeight(13);
        numberInTransportPackage.setColspan(2);
        numberInTransportPackage.setPaddingBottom(2);
        numberInTransportPackage.setBorder(Rectangle.BOX);
        rightTable.addCell(numberInTransportPackage);

        PdfPCell numberInTransportPackageValue = getCell(product.getNumberInTransportPackage().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        numberInTransportPackageValue.setMinimumHeight(13);
        numberInTransportPackageValue.setColspan(2);
        numberInTransportPackageValue.setPaddingBottom(2);
        numberInTransportPackageValue.setBorder(Rectangle.BOX);
        rightTable.addCell(numberInTransportPackageValue);

        PdfPCell packageSizes = getCell("Разм. пакета", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        packageSizes.setMinimumHeight(13);
        packageSizes.setPaddingBottom(2);
        packageSizes.setBorder(Rectangle.BOX);
        rightTable.addCell(packageSizes);

        PdfPCell packageLength = getCell(product.getPackageLength().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        packageLength.setMinimumHeight(13);
        packageLength.setBorder(Rectangle.BOX);
        rightTable.addCell(packageLength);

        PdfPCell packageWidth = getCell(product.getPackageWidth().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        packageWidth.setMinimumHeight(13);
        packageWidth.setPaddingBottom(2);
        packageWidth.setBorder(Rectangle.BOX);
        rightTable.addCell(packageWidth);

        PdfPCell packageHeight = getCell(product.getPackageHeight().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        packageHeight.setMinimumHeight(13);
        packageHeight.setPaddingBottom(2);
        packageHeight.setBorder(Rectangle.BOX);
        rightTable.addCell(packageHeight);

        PdfPCell pallet = getCell("Поддон", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        pallet.setMinimumHeight(13);
        pallet.setPaddingBottom(2);
        pallet.setColspan(2);
        pallet.setBorder(Rectangle.BOX);
        rightTable.addCell(pallet);

        PdfPCell palletValue = getCell(product.getPallet().getPallet(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        palletValue.setMinimumHeight(13);
        palletValue.setPaddingBottom(2);
        palletValue.setColspan(2);
        palletValue.setBorder(Rectangle.BOX);
        rightTable.addCell(palletValue);


        PdfPCell palletPlacement = getCell("Раскладка на поддоне", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        palletPlacement.setMinimumHeight(13);
        palletPlacement.setColspan(2);
        palletPlacement.setPaddingBottom(2);
        palletPlacement.setBorder(Rectangle.BOX);
        rightTable.addCell(palletPlacement);

        PdfPCell palletPlacementValue = getCell(product.getPalletPlacement().getPalletPlacement(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        palletPlacementValue.setMinimumHeight(13);
        palletPlacementValue.setPaddingBottom(2);
        palletPlacementValue.setColspan(2);
        palletPlacementValue.setBorder(Rectangle.BOX);
        rightTable.addCell(palletPlacementValue);

        PdfPCell numberRows = getCell("Рядов на поддоне", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        numberRows.setMinimumHeight(13);
        numberRows.setColspan(2);
        numberRows.setPaddingBottom(2);
        numberRows.setBorder(Rectangle.BOX);
        numberRows.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberRows);

        PdfPCell numberRowsValue = getCell(product.getPalletRows().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        numberRowsValue.setMinimumHeight(13);
        numberRowsValue.setPaddingBottom(2);
        numberRowsValue.setColspan(2);
        numberRowsValue.setBorder(Rectangle.BOX);
        rightTable.addCell(numberRowsValue);

        PdfPCell loadCar = getCell("Загрузка авто, шт", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        loadCar.setMinimumHeight(13);
        loadCar.setColspan(2);
        loadCar.setPaddingBottom(2);
        loadCar.setBorder(Rectangle.BOX);
        rightTable.addCell(loadCar);

        PdfPCell loadCarValue = getCell(product.getNumberLoadCar().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        loadCarValue.setMinimumHeight(13);
        loadCarValue.setColspan(2);
        loadCarValue.setPaddingBottom(2);
        loadCarValue.setBorder(Rectangle.BOX);
        rightTable.addCell(loadCarValue);

        switch (version) {
            case "full":
                PdfPCell links = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                links.setMinimumHeight(40);
                links.setColspan(6);
                links.setPaddingLeft(7);
                links.setBorder(Rectangle.BOX);
                rightTable.addCell(links);

                PdfPCell productionFormat = getCell("Производственный формат", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                productionFormat.setMinimumHeight(13);
                productionFormat.setColspan(4);
                productionFormat.setPaddingLeft(7);
                productionFormat.setPaddingBottom(4);
                productionFormat.setBorder(Rectangle.BOX);
                rightTable.addCell(productionFormat);

                PdfPCell productionFormatValue = getCell(product.getProductionFormat().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                productionFormatValue.setMinimumHeight(13);
                productionFormatValue.setColspan(2);
                productionFormatValue.setPaddingBottom(4);
                productionFormatValue.setBorder(Rectangle.BOX);
                rightTable.addCell(productionFormatValue);

                rightCellTable.addElement(rightTable);


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
                String bigovki1 = bigovkiProduct.size() > 0 ? product.getBigovki().get(0).getValue().toString() : EMPTY_STRING;
                String bigovki2 = bigovkiProduct.size() > 1 ? product.getBigovki().get(1).getValue().toString() : EMPTY_STRING;
                String bigovki3 = bigovkiProduct.size() > 2 ? product.getBigovki().get(2).getValue().toString() : EMPTY_STRING;
                String bigovki4 = bigovkiProduct.size() > 3 ? product.getBigovki().get(3).getValue().toString() : EMPTY_STRING;

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

                PdfPCell bigovkiValue4 = getCell(bigovki4, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
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
                String perforation1 = perforationDtos.size() > 0 ? product.getPerforations().get(0).getValue().toString() : EMPTY_STRING;
                String perforation2 = perforationDtos.size() > 1 ? product.getPerforations().get(1).getValue().toString() : EMPTY_STRING;
                String perforation3 = perforationDtos.size() > 2 ? product.getPerforations().get(2).getValue().toString() : EMPTY_STRING;
                String perforation4 = perforationDtos.size() > 3 ? product.getPerforations().get(3).getValue().toString() : EMPTY_STRING;
                String perforation5 = perforationDtos.size() > 4 ? product.getPerforations().get(4).getValue().toString() : EMPTY_STRING;

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
            default:{
                rightCellTable.addElement(rightTable);
            }
        }

        return rightCellTable;
    }

    private static PdfPCell createLeftTable(ProductDto product, BaseFont baseFont, int fontSizeForTitle, int fontSizeForColumns, String version){
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

        PdfPCell innerSizes = getCell("Размеры внутр.", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        innerSizes.setMinimumHeight(13);
        innerSizes.setPaddingBottom(4);
        innerSizes.setBorder(Rectangle.BOX);
        leftTable.addCell(innerSizes);

        PdfPCell productInnerLength = getCell(product.getInnerLength().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productInnerLength.setBorder(Rectangle.BOX);
        productInnerLength.setPaddingBottom(4);
        productInnerLength.setMinimumHeight(13);
        leftTable.addCell(productInnerLength);

        PdfPCell productInnerWidth = getCell(product.getInnerWidth().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productInnerWidth.setBorder(Rectangle.BOX);
        productInnerWidth.setMinimumHeight(13);
        productInnerWidth.setPaddingBottom(4);
        leftTable.addCell(productInnerWidth);

        PdfPCell productInnerHeight = getCell(product.getInnerHeight().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productInnerHeight.setBorder(Rectangle.BOX);
        productInnerHeight.setMinimumHeight(13);
        productInnerHeight.setPaddingBottom(4);
        leftTable.addCell(productInnerHeight);

        PdfPCell productProfile;
        PdfPCell productProfileValue;
        switch (version) {
            case "full":
                PdfPCell theoreticalSquare = getCell("S теор.", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                theoreticalSquare.setBorder(Rectangle.BOX);
                theoreticalSquare.setPaddingBottom(4);
                theoreticalSquare.setMinimumHeight(13);
                leftTable.addCell(theoreticalSquare);

                PdfPCell theoreticalSquareValue = getCell(product.getTheoreticalSquare().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                theoreticalSquareValue.setBorder(Rectangle.BOX);
                theoreticalSquareValue.setPaddingBottom(4);
                theoreticalSquareValue.setMinimumHeight(13);
                leftTable.addCell(theoreticalSquareValue);

                PdfPCell actualSquare = getCell("S факт.", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                actualSquare.setBorder(Rectangle.BOX);
                actualSquare.setPaddingBottom(4);
                actualSquare.setMinimumHeight(13);
                leftTable.addCell(actualSquare);

                PdfPCell actualSquareValue = getCell(product.getActualSquare().toString(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                actualSquareValue.setBorder(Rectangle.BOX);
                actualSquareValue.setPaddingBottom(4);
                actualSquareValue.setMinimumHeight(13);
                leftTable.addCell(actualSquareValue);

                PdfPCell format = getCell("Расч. формат", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                format.setBorder(Rectangle.BOX);
                format.setPaddingBottom(4);
                format.setMinimumHeight(13);
                leftTable.addCell(format);

                PdfPCell formatValue = getCell(product.getFormat().getFormat(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                formatValue.setBorder(Rectangle.BOX);
                formatValue.setPaddingBottom(4);
                formatValue.setMinimumHeight(13);
                leftTable.addCell(formatValue);

                productProfile = getCell("Профиль", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                productProfile.setBorder(Rectangle.BOX);
                productProfile.setPaddingBottom(4);
                productProfile.setMinimumHeight(13);
                leftTable.addCell(productProfile);

                productProfileValue = getCell(product.getProfile().getProfile(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                productProfileValue.setBorder(Rectangle.BOX);
                productProfileValue.setPaddingBottom(4);
                productProfileValue.setMinimumHeight(13);
                leftTable.addCell(productProfileValue);
                break;
            default:{
                productProfile = getCell("Профиль", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
                productProfile.setBorder(Rectangle.BOX);
                productProfile.setPaddingBottom(4);
                productProfile.setMinimumHeight(13);
                leftTable.addCell(productProfile);

                productProfileValue = getCell(product.getProfile().getProfile(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                productProfileValue.setBorder(Rectangle.BOX);
                productProfileValue.setPaddingBottom(4);
                productProfileValue.setMinimumHeight(13);
                leftTable.addCell(productProfileValue);

                PdfPCell emptyColumn = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
                emptyColumn.setBorder(Rectangle.BOX);
                emptyColumn.setColspan(2);
                emptyColumn.setMinimumHeight(13);
                leftTable.addCell(emptyColumn);
            }
        }

        PdfPCell productCardboardBrand = getCell("Марка картона", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productCardboardBrand.setBorder(Rectangle.BOX);
        productCardboardBrand.setPaddingBottom(4);
        productCardboardBrand.setMinimumHeight(13);
        leftTable.addCell(productCardboardBrand);

        PdfPCell productCardboardBrandValue = getCell(product.getCardboardBrand().getCardboardBrand(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productCardboardBrandValue.setBorder(Rectangle.BOX);
        productCardboardBrandValue.setPaddingBottom(4);
        productCardboardBrandValue.setMinimumHeight(13);
        leftTable.addCell(productCardboardBrandValue);


        PdfPCell productCelluloseLayer = getCell("Целюлозный слой", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productCelluloseLayer.setBorder(Rectangle.BOX);
        productCelluloseLayer.setPaddingBottom(4);
        productCelluloseLayer.setMinimumHeight(13);
        leftTable.addCell(productCelluloseLayer);

        PdfPCell productCelluloseLayerValue = getCell(product.getCelluloseLayer().getCelluloseLayer(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productCelluloseLayerValue.setBorder(Rectangle.BOX);
        productCelluloseLayerValue.setPaddingBottom(4);
        productCelluloseLayerValue.setMinimumHeight(13);
        leftTable.addCell(productCelluloseLayerValue);

        PdfPCell productFaceLayer = getCell("Лицевой слой", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productFaceLayer.setMinimumHeight(13);
        productFaceLayer.setPaddingBottom(4);
        productFaceLayer.setBorder(Rectangle.BOX);
        leftTable.addCell(productFaceLayer);

        PdfPCell productFaceLayerValue = getCell(product.getFaceLayer().getFaceLayer(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productFaceLayerValue.setBorder(Rectangle.BOX);
        productFaceLayerValue.setPaddingBottom(4);
        productFaceLayerValue.setMinimumHeight(13);
        leftTable.addCell(productFaceLayerValue);

        PdfPCell productInnerLayer = getCell("Внутренний слой", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productInnerLayer.setBorder(Rectangle.BOX);
        productInnerLayer.setPaddingBottom(4);
        productInnerLayer.setMinimumHeight(13);
        leftTable.addCell(productInnerLayer);

        PdfPCell productInnerLayerValue = getCell(product.getInnerLayer().getInnerLayer(), PdfPCell.ALIGN_CENTER, baseFont, fontSizeForColumns, Font.NORMAL);
        productInnerLayerValue.setBorder(Rectangle.BOX);
        productInnerLayerValue.setPaddingBottom(4);
        productInnerLayerValue.setMinimumHeight(13);
        leftTable.addCell(productInnerLayerValue);


        PdfPCell verticalMaterial = getCell("Материал", PdfPCell.ALIGN_CENTER, baseFont, fontSizeForTitle, Font.BOLD);
        verticalMaterial.setRotation(-90);
        verticalMaterial.setPadding(2);
        verticalMaterial.setBackgroundColor(COLOR);
        verticalMaterial.setBorder(Rectangle.BOX);

        PdfPCell materialValue = getCell(product.getSpecialConditions(), PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        materialValue.setBorder(Rectangle.BOX);
        materialValue.setColspan(4);
        materialValue.setPaddingTop(-2);
        materialValue.setPaddingLeft(2);
        materialValue.setMinimumHeight(50);
        switch (version) {
            case "full":
                leftTable.addCell(verticalMaterial);
                leftTable.addCell(materialValue);
                break;
        }

        PdfPCell productSpecialConditions = getCell("Особые условия", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.BOLD);
        productSpecialConditions.setBorder(Rectangle.BOX);
        productSpecialConditions.setColspan(5);
        productSpecialConditions.setMinimumHeight(16);
        productSpecialConditions.setBackgroundColor(COLOR);
        productSpecialConditions.setPaddingLeft(8);
        productSpecialConditions.setPaddingBottom(6);
        leftTable.addCell(productSpecialConditions);

        PdfPCell productSpecialConditionsValue = getCell(product.getSpecialConditions(), PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        productSpecialConditionsValue.setBorder(Rectangle.BOX);
        productSpecialConditionsValue.setColspan(5);
        productSpecialConditionsValue.setPaddingLeft(2);
        productSpecialConditionsValue.setPaddingTop(-2);
        productSpecialConditionsValue.setMinimumHeight(50);
        leftTable.addCell(productSpecialConditionsValue);

        PdfPCell producibility = getCell("Технологичность", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.BOLD);
        producibility.setBorder(Rectangle.BOX);
        producibility.setColspan(5);
        producibility.setMinimumHeight(16);
        producibility.setBackgroundColor(COLOR);
        producibility.setPaddingLeft(8);
        producibility.setPaddingBottom(6);

        PdfPCell producibilityValue = getCell("Технологичность", PdfPCell.ALIGN_LEFT, baseFont, fontSizeForColumns, Font.NORMAL);
        producibilityValue.setBorder(Rectangle.BOX);
        producibilityValue.setColspan(5);
        producibilityValue.setPaddingLeft(2);
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

    private static PdfPCell getCell(String text, int alignment, BaseFont font, int fontSize, int fontStyle) {
        Phrase phrase = new Phrase();
        phrase.setFont(new Font(font, fontSize, fontStyle));
        phrase.add(text);

        PdfPCell cell = new PdfPCell(phrase);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private static ProductDto createProduct(){
        ProductDto product = new ProductDto();
        product.setProductNumber(23);
        product.setNew(true);
        product.setProductName("Продукт тест");
        product.setProductCreateDate(LocalDate.now());
        product.setProductUpdateDate(LocalDate.now());
        product.setPersonPrepared("Голтвянский А.О.");

        ClientDto client = new ClientDto(1L);
        client.setLastName("Приймаченко В.О.");
        product.setClient(client);

        product.setIsUse(false);

        ProductTypeDto productType = new ProductTypeDto(1L);
        productType.setProductType("Ассорти 4 Продукта");
        product.setProductType(productType);

        product.setInnerLength(111);
        product.setInnerHeight(222);
        product.setInnerWidth(333);
        product.setActualSquare(3.23);
        product.setTheoreticalSquare(3.23);
        product.setNumberBlanksOnFormat(11);

        ProfileDto profile = new ProfileDto(1L);
        profile.setProfile("B");
        product.setProfile(profile);

        FormatDto format = new FormatDto(1L);
        format.setFormat("1400");
        product.setFormat(format);

        CardboardBrandDto cardboardBrand = new CardboardBrandDto(1L);
        cardboardBrand.setCardboardBrand("T-24");
        product.setCardboardBrand(cardboardBrand);

        CelluloseLayerDto celluloseLayer = new CelluloseLayerDto(1L);
        celluloseLayer.setCelluloseLayer("нет");
        product.setCelluloseLayer(celluloseLayer);

        InnerLayerDto innerLayer = new InnerLayerDto(1L);
        innerLayer.setInnerLayer("крашенный");
        product.setInnerLayer(innerLayer);

        FaceLayerDto faceLayer = new FaceLayerDto(1L);
        faceLayer.setFaceLayer("крашенный");
        product.setFaceLayer(faceLayer);

        product.setSpecialConditions("I like programming, very much");
        product.setSizeWorkpieceLength(350);
        product.setSizeWorkpieceWidth(150);
        product.setBlankFormat(777);

        ConnectionValveDto connectionValve = new ConnectionValveDto(1L);
        connectionValve.setConnectionValve("склеенный и сшитый");
        product.setConnectionValve(connectionValve);

        product.setStamp("Здесь мало текста");
        product.setCliche("А здесь, теперь тут 2 строки и спускается вниз");

        PackingDto packing = new PackingDto(1L);
        packing.setPacking("Паллета, лента, стрейч");
        product.setPacking(packing);

        product.setNumberInPack(231);
        product.setNumberInTransportPackage(123);
        product.setPackageWidth(23);
        product.setPackageLength(12);
        product.setPackageHeight(32);

        PalletDto pallet = new PalletDto(1L);
        pallet.setPallet("1200*800");
        product.setPallet(pallet);

        PalletPlacementDto palletPlacement = new PalletPlacementDto(1L);
        palletPlacement.setPlacement("2 пачки в ряду");
        product.setPalletPlacement(palletPlacement);


        ProducibilityDto producibility = new ProducibilityDto(1L);
        producibility.setServiceCenter("Тайванец");
        producibility.setGroupPriority(12);
        producibility.setElementPriority(10);


        ProducibilityNotesDto producibilityNote = new ProducibilityNotesDto(1L);
        producibilityNote.setServiceCenter(producibility);
        producibilityNote.setNote("someNote sdfsdf sdfsdfsdfsdf sdf sdf sdf sdfds sdfsdf sdfsdf");

        java.util.List<ProducibilityNotesDto> producibilityNotes = new ArrayList<>();
        producibilityNotes.add(producibilityNote);
        producibilityNotes.add(producibilityNote);
        producibilityNotes.add(producibilityNote);
        producibilityNotes.add(producibilityNote);
        product.setProducibilityNotes(producibilityNotes);


        product.setPalletRows(2);
        product.setNumberLoadCar(23);
        product.setProductionFormat(23433);

        BigovkiDto bigovki = new BigovkiDto(1L);
        bigovki.setValue(12);

        BigovkiDto bigovki1 = new BigovkiDto(2L);
        bigovki1.setValue(13);

        BigovkiDto bigovki2 = new BigovkiDto(3L);
        bigovki2.setValue(14);

        BigovkiDto bigovki3 = new BigovkiDto(4L);
        bigovki3.setValue(15);

        java.util.List<BigovkiDto> bigovkiDtoList = new ArrayList<>();
        bigovkiDtoList.add(bigovki);
        bigovkiDtoList.add(bigovki1);
        bigovkiDtoList.add(bigovki2);
        bigovkiDtoList.add(bigovki3);
        product.setBigovki(bigovkiDtoList);

        PerforationDto perforation = new PerforationDto(1L);
        perforation.setValue(1);

        PerforationDto perforation1 = new PerforationDto(2L);
        perforation1.setValue(2);

        PerforationDto perforation2 = new PerforationDto(3L);
        perforation2.setValue(3);

        PerforationDto perforation3 = new PerforationDto(4L);
        perforation3.setValue(4);

        PerforationDto perforation4 = new PerforationDto(4L);
        perforation4.setValue(5);

        java.util.List<PerforationDto> perforations = new ArrayList<>();
        perforations.add(perforation);
        perforations.add(perforation1);
        perforations.add(perforation2);
        perforations.add(perforation3);
        perforations.add(perforation4);
        product.setPerforations(perforations);

        return product;
    }

}