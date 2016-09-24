package ua.skillsup.gelius.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ua.skillsup.gelius.model.dto.ProductDto;
import ua.skillsup.gelius.model.dto.dictionary.*;
import ua.skillsup.gelius.util.ProductUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerPdfCreator {

    private static final String EMPTY_STRING = "";
    private static final BaseColor COLOR = WebColors.getRGBColor("#B6D7A8");
    private static final String FONT_PATH = "/fonts/Colibri.ttf";
    private static final Rectangle PAGE_SIZE = PageSize.A4.rotate();

    public static void main(String[] args) throws IOException, DocumentException {

        BaseFont baseFont = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        Document document = new Document();
        document.setPageSize(PAGE_SIZE);

        PdfWriter.getInstance(document, new FileOutputStream("config/HelloWorld.pdf"));

        document.open();

        CustomerPdfCreator starter = new CustomerPdfCreator();

        ProductDto product = starter.createProduct();

        PdfPTable[] headerTop = starter.createHeaderTop(product, baseFont);
        PdfPTable[] headerBottom = starter.createHeaderBottom(product, baseFont);

        for (PdfPTable element : headerTop) {
            document.add(element);
        }

        for (PdfPTable element : headerBottom) {
            document.add(element);
        }


        float[] columnWidths = {5.3f, 0.05f, 3.7f, 0.05f, 3.7f};
        PdfPTable tableBody = new PdfPTable(columnWidths);
        tableBody.setWidthPercentage(105);

        PdfPCell leftCellTable = starter.createLeftTable(product, baseFont);
        tableBody.addCell(leftCellTable);

        PdfPCell marginBetweenTables = new PdfPCell();
        marginBetweenTables.setBorder(Rectangle.NO_BORDER);
        tableBody.addCell(marginBetweenTables);

        PdfPCell middleTable = starter.createMiddleTable(product, baseFont);
        tableBody.addCell(middleTable);


        tableBody.addCell(marginBetweenTables);

        PdfPCell rightTable = starter.createRightTable(product, baseFont);
        tableBody.addCell(rightTable);

        document.add(tableBody);
        document.close();
    }

    private PdfPCell getCell(String text, int alignment, BaseFont font, int fontSize, int fontStyle) {
        Phrase phrase = new Phrase();
        phrase.setFont(new Font(font, fontSize, fontStyle));
        phrase.add(text);

        PdfPCell cell = new PdfPCell(phrase);
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }

    private PdfPTable[] createHeaderTop(ProductDto product, BaseFont baseFont){
        String fullProductNumber = ProductUtils.getFullProductNumber(product.getProductNumber(), product.getIsNew());
        String productCreatedDate = product.getProductCreateDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String productUpdatedDate = product.getProductUpdateDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        // First table
        float[] columnWidths = {5.5f, 1f};
        PdfPTable tableHeaderTop = new PdfPTable(columnWidths);
        tableHeaderTop.setPaddingTop(-40);
        tableHeaderTop.setWidthPercentage(100);

        PdfPCell cellFirstTableTop = getCell("Техкарта № " + fullProductNumber, PdfPCell.ALIGN_CENTER, baseFont, 18, Font.BOLD);
        cellFirstTableTop.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cellFirstTableTop.setPaddingLeft(75);
        tableHeaderTop.addCell(cellFirstTableTop);

        PdfPCell cellSecondTableTop = getCell("Создано  " + productCreatedDate, PdfPCell.ALIGN_RIGHT, baseFont, 12, Font.NORMAL);
        cellSecondTableTop.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeaderTop.addCell(cellSecondTableTop);


        // Second table
        PdfPTable tableHeaderBottom = new PdfPTable(columnWidths);
        tableHeaderBottom.setWidthPercentage(100);

        PdfPCell cellFirstTableBottom = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 12, Font.NORMAL);
        cellFirstTableBottom.setVerticalAlignment(Element.ALIGN_BOTTOM);
        tableHeaderBottom.addCell(cellFirstTableBottom);

        PdfPCell cellSecondTableBottom = getCell("Изменено  " + productUpdatedDate, PdfPCell.ALIGN_RIGHT, baseFont, 12, Font.NORMAL);
        cellSecondTableBottom.setPaddingTop(2);
        cellSecondTableBottom.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeaderBottom.addCell(cellSecondTableBottom);

        return new PdfPTable[]{tableHeaderTop, tableHeaderBottom};
    }

    private PdfPTable[] createHeaderBottom(ProductDto product, BaseFont baseFont){
        String productClient = product.getClient().getLastName();
        String productName = product.getProductName();
        String productType = product.getProductType().getProductType();

        float[] columnWidths = {0.6f, 2f, 1.5f, 1.5f, 1.5f, 1.8f, 1.5f};
        PdfPTable tableHeader = new PdfPTable(columnWidths);
        tableHeader.setWidthPercentage(100);

        // Customer
        PdfPCell client = getCell("Заказчик", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        client.setVerticalAlignment(Element.ALIGN_MIDDLE);
        client.setPaddingLeft(-20);
        client.setPaddingTop(15);
        client.setPaddingBottom(15);
        tableHeader.addCell(client);

        PdfPCell clientProduct = getCell(productClient, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        clientProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
        clientProduct.setPaddingLeft(5);
        clientProduct.setPaddingBottom(15);
        clientProduct.setPaddingTop(15);
        tableHeader.addCell(clientProduct);

        // Product Name
        PdfPCell name = getCell("Название", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        name.setVerticalAlignment(Element.ALIGN_MIDDLE);
        name.setPaddingLeft(40);
        name.setPaddingTop(15);
        name.setPaddingBottom(15);
        tableHeader.addCell(name);

        PdfPCell nameProduct = getCell(productName, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        nameProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
        nameProduct.setPaddingTop(15);
        nameProduct.setPaddingBottom(15);
        tableHeader.addCell(nameProduct);

        // Product Type
        PdfPCell type = getCell("Тип изделия", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        type.setVerticalAlignment(Element.ALIGN_MIDDLE);
        type.setPaddingLeft(20);
        type.setPaddingTop(15);
        type.setPaddingBottom(15);
        tableHeader.addCell(type);

        PdfPCell typeProduct = getCell(productType, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        typeProduct.setVerticalAlignment(Element.ALIGN_MIDDLE);
        typeProduct.setPaddingLeft(-5);
        typeProduct.setPaddingBottom(15);
        typeProduct.setPaddingTop(15);

        tableHeader.addCell(typeProduct);


        PdfPCell emptyCell = getCell(EMPTY_STRING, PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        emptyCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        emptyCell.setPaddingTop(15);
        emptyCell.setPaddingBottom(15);
        tableHeader.addCell(emptyCell);


        return new PdfPTable[]{tableHeader};
    }

    private PdfPCell createMiddleTable(ProductDto product, BaseFont baseFont){
        PdfPCell middleCellTable = new PdfPCell();
        middleCellTable.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTableTop = {0.2f, 1.3f, 0.5f, 0.5f};
        PdfPTable middleTableTop = new PdfPTable(columnWidthsLeftCellTableTop);
        middleTableTop.setWidthPercentage(101);

        PdfPCell verticalTitleProducts = getCell("Продукция", PdfPCell.ALIGN_CENTER, baseFont, 15, Font.BOLD);
        verticalTitleProducts.setRotation(-90);
        verticalTitleProducts.setRowspan(3);
        verticalTitleProducts.setPaddingLeft(2.3f);
        verticalTitleProducts.setBackgroundColor(COLOR);
        verticalTitleProducts.setBorder(Rectangle.BOX);
        middleTableTop.addCell(verticalTitleProducts);

        PdfPCell blankSizes = getCell("Размеры заготовки", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        blankSizes.setMinimumHeight(20);
        blankSizes.setBorder(Rectangle.BOX);
        blankSizes.setPaddingBottom(4);
        middleTableTop.addCell(blankSizes);

        PdfPCell blankSizesLengthValue = getCell(product.getSizeWorkpieceLength().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        blankSizesLengthValue.setMinimumHeight(20);
        blankSizesLengthValue.setBorder(Rectangle.BOX);
        blankSizesLengthValue.setPaddingBottom(4);
        blankSizesLengthValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(blankSizesLengthValue);

        PdfPCell blankSizesWidthValue = getCell(product.getSizeWorkpieceWidth().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        blankSizesWidthValue.setMinimumHeight(20);
        blankSizesWidthValue.setPaddingBottom(4);
        blankSizesWidthValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        blankSizesWidthValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(blankSizesWidthValue);

        PdfPCell blankFormat = getCell("Формат заготовки", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        blankFormat.setMinimumHeight(20);
        blankFormat.setPaddingBottom(4);
        blankFormat.setBorder(Rectangle.BOX);
        middleTableTop.addCell(blankFormat);

        PdfPCell blankFormatValue = getCell(product.getBlankFormat().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        blankFormatValue.setColspan(2);
        blankFormatValue.setMinimumHeight(20);
        blankFormatValue.setPaddingBottom(4);
        blankFormatValue.setBorder(Rectangle.BOX);
        blankFormatValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableTop.addCell(blankFormatValue);

        PdfPCell connectionValve = getCell("Соединение клапана", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        connectionValve.setMinimumHeight(20);
        connectionValve.setPaddingBottom(4);
        connectionValve.setBorder(Rectangle.BOX);
        middleTableTop.addCell(connectionValve);

        PdfPCell connectionValveValue = getCell(product.getConnectionValve().getConnectionValve(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        connectionValveValue.setColspan(2);
        connectionValveValue.setMinimumHeight(20);
        connectionValveValue.setBorder(Rectangle.BOX);
        middleTableTop.addCell(connectionValveValue);

        float[] columnWidthsLeftCellTableMiddle= {0.8f, 3.2f};
        PdfPTable middleTableMiddle = new PdfPTable(columnWidthsLeftCellTableMiddle);
        middleTableMiddle.setWidthPercentage(101);

        PdfPCell stamp = getCell("Штамп", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        stamp.setMinimumHeight(38);
        stamp.setBorder(Rectangle.BOX);
        stamp.setPaddingBottom(4);
        stamp.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableMiddle.addCell(stamp);

        PdfPCell stampValue = getCell(product.getStamp(), PdfPCell.ALIGN_LEFT, baseFont, 12, Font.NORMAL);
        stampValue.setColspan(2);
        stampValue.setMinimumHeight(38);
        stampValue.setPaddingLeft(2);
        stampValue.setBorder(Rectangle.BOX);
        middleTableMiddle.addCell(stampValue);

        PdfPCell cliche = getCell("Клише", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        cliche.setMinimumHeight(40);
        cliche.setBorder(Rectangle.BOX);
        cliche.setPaddingBottom(4);
        cliche.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableMiddle.addCell(cliche);

        PdfPCell clicheValue = getCell(product.getCliche(), PdfPCell.ALIGN_LEFT, baseFont, 12, Font.NORMAL);
        clicheValue.setColspan(2);
        clicheValue.setPaddingLeft(2);
        clicheValue.setMinimumHeight(40);
        clicheValue.setBorder(Rectangle.BOX);
        middleTableMiddle.addCell(clicheValue);

        PdfPCell middleCellTableBottom = new PdfPCell();
        middleCellTableBottom.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTableBottom = {0.25f, 0.7f, 1.3f, 1f};
        PdfPTable middleTableBottom = new PdfPTable(columnWidthsLeftCellTableBottom);
        middleTableBottom.setWidthPercentage(101);

        PdfPCell verticalTitlePrint = getCell("Печать", PdfPCell.ALIGN_CENTER, baseFont, 15, Font.BOLD);
        verticalTitlePrint.setRotation(-90);
        verticalTitlePrint.setRowspan(5);
        verticalTitlePrint.setBackgroundColor(COLOR);
        verticalTitlePrint.setBorder(Rectangle.BOX);
        middleTableBottom.addCell(verticalTitlePrint);

        PdfPCell color = getCell("Цвет", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        color.setMinimumHeight(20);
        color.setBorder(Rectangle.BOX);
        color.setPaddingBottom(4);
        color.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(color);

        PdfPCell printName = getCell("Название", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        printName.setMinimumHeight(20);
        printName.setBorder(Rectangle.BOX);
        printName.setPaddingBottom(4);
        printName.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(printName);

        PdfPCell pricePrint = getCell("S запечатки", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        pricePrint.setMinimumHeight(20);
        pricePrint.setBorder(Rectangle.BOX);
        pricePrint.setPaddingBottom(4);
        pricePrint.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(pricePrint);

        PdfPCell colorFirst = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        colorFirst.setMinimumHeight(20);
        colorFirst.setBorder(Rectangle.BOX);
        colorFirst.setPaddingBottom(4);
        colorFirst.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(colorFirst);

        PdfPCell printNameFirst = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        printNameFirst.setMinimumHeight(20);
        printNameFirst.setBorder(Rectangle.BOX);
        printNameFirst.setPaddingBottom(4);
        printNameFirst.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(printNameFirst);

        PdfPCell pricePrintFirst = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        pricePrintFirst.setMinimumHeight(20);
        pricePrintFirst.setBorder(Rectangle.BOX);
        pricePrintFirst.setPaddingBottom(4);
        pricePrintFirst.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(pricePrintFirst);

        PdfPCell colorSecond = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        colorSecond.setMinimumHeight(20);
        colorSecond.setBorder(Rectangle.BOX);
        colorSecond.setPaddingBottom(4);
        colorSecond.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(colorSecond);

        PdfPCell printNameSecond = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        printNameSecond.setMinimumHeight(20);
        printNameSecond.setBorder(Rectangle.BOX);
        printNameSecond.setPaddingBottom(4);
        printNameSecond.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(printNameSecond);

        PdfPCell pricePrintSecond = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        pricePrintSecond.setMinimumHeight(20);
        pricePrintSecond.setBorder(Rectangle.BOX);
        pricePrintSecond.setPaddingBottom(4);
        pricePrintSecond.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(pricePrintSecond);

        PdfPCell colorThird = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        colorThird.setMinimumHeight(20);
        colorThird.setBorder(Rectangle.BOX);
        colorThird.setPaddingBottom(4);
        colorThird.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(colorThird);

        PdfPCell printNameThird = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        printNameThird.setMinimumHeight(20);
        printNameThird.setBorder(Rectangle.BOX);
        printNameThird.setPaddingBottom(4);
        printNameThird.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(printNameThird);

        PdfPCell pricePrintThird = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        pricePrintThird.setMinimumHeight(20);
        pricePrintThird.setBorder(Rectangle.BOX);
        pricePrintThird.setPaddingBottom(4);
        pricePrintThird.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(pricePrintThird);

        PdfPCell colorFourth = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        colorFourth.setMinimumHeight(20);
        colorFourth.setBorder(Rectangle.BOX);
        colorFourth.setPaddingBottom(4);
        colorFourth.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(colorFourth);

        PdfPCell printNameFourth = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        printNameFourth.setMinimumHeight(20);
        printNameFourth.setBorder(Rectangle.BOX);
        printNameFourth.setPaddingBottom(4);
        printNameFourth.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(printNameFourth);

        PdfPCell pricePrintFourth = getCell("", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        pricePrintFourth.setMinimumHeight(20);
        pricePrintFourth.setBorder(Rectangle.BOX);
        pricePrintFourth.setPaddingBottom(4);
        pricePrintFourth.setVerticalAlignment(Element.ALIGN_MIDDLE);
        middleTableBottom.addCell(pricePrintFourth);

        middleCellTable.addElement(middleTableTop);
        middleCellTable.addElement(middleTableMiddle);
        middleCellTable.addElement(middleTableBottom);

        return middleCellTable;
    }

    private PdfPCell createRightTable(ProductDto product, BaseFont baseFont){
        PdfPCell rightCellTable = new PdfPCell();
        rightCellTable.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTable = {0.3f, 1.4f, 0.8f, 0.8f, 0.8f};
        PdfPTable rightTable = new PdfPTable(columnWidthsLeftCellTable);
        rightTable.setWidthPercentage(101);

        PdfPCell verticalRightTitle = getCell("Авто", PdfPCell.ALIGN_CENTER, baseFont, 15, Font.BOLD);
        verticalRightTitle.setRotation(-90);
        verticalRightTitle.setRowspan(8);
        verticalRightTitle.setBackgroundColor(COLOR);
        verticalRightTitle.setBorder(Rectangle.BOX);
        rightTable.addCell(verticalRightTitle);

        PdfPCell productPacking = getCell("Способ упаковки", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productPacking.setColspan(2);
        productPacking.setMinimumHeight(30);
        productPacking.setBorder(Rectangle.BOX);
        productPacking.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(productPacking);

        PdfPCell productPackingValue = getCell(product.getPacking().getPacking(), PdfPCell.ALIGN_CENTER, baseFont, 15, Font.NORMAL);
        productPackingValue.setColspan(2);
        productPackingValue.setMinimumHeight(30);
        productPackingValue.setPaddingBottom(2);
        productPackingValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        productPackingValue.setBorder(Rectangle.BOX);
        rightTable.addCell(productPackingValue);

        PdfPCell numberInPack = getCell("В пачке, шт", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        numberInPack.setColspan(2);
        numberInPack.setMinimumHeight(30);
        numberInPack.setBorder(Rectangle.BOX);
        numberInPack.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberInPack);

        PdfPCell numberInPackValue = getCell(product.getNumberInPack().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        numberInPackValue.setMinimumHeight(30);
        numberInPackValue.setColspan(2);
        numberInPackValue.setBorder(Rectangle.BOX);
        numberInPackValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberInPackValue);

        PdfPCell numberInTransportPackage = getCell("В транспортном пакете, шт", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        numberInTransportPackage.setMinimumHeight(30);
        numberInTransportPackage.setColspan(2);
        numberInTransportPackage.setPaddingBottom(2);
        numberInTransportPackage.setBorder(Rectangle.BOX);
        numberInTransportPackage.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberInTransportPackage);

        PdfPCell numberInTransportPackageValue = getCell(product.getNumberInTransportPackage().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        numberInTransportPackageValue.setMinimumHeight(30);
        numberInTransportPackageValue.setColspan(2);
        numberInTransportPackageValue.setBorder(Rectangle.BOX);
        numberInTransportPackageValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberInTransportPackageValue);

        PdfPCell packageSizes = getCell("Размеры пакета", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        packageSizes.setMinimumHeight(30);
        packageSizes.setBorder(Rectangle.BOX);
        packageSizes.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(packageSizes);

        PdfPCell packageLength = getCell(product.getPackageLength().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        packageLength.setMinimumHeight(30);
        packageLength.setBorder(Rectangle.BOX);
        packageLength.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(packageLength);

        PdfPCell packageWidth = getCell(product.getPackageWidth().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        packageWidth.setMinimumHeight(30);
        packageWidth.setBorder(Rectangle.BOX);
        packageWidth.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(packageWidth);

        PdfPCell packageHeight = getCell(product.getPackageHeight().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        packageHeight.setMinimumHeight(30);
        packageHeight.setBorder(Rectangle.BOX);
        packageHeight.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(packageHeight);

        PdfPCell pallet = getCell("Поддон", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        pallet.setMinimumHeight(30);
        pallet.setColspan(2);
        pallet.setBorder(Rectangle.BOX);
        pallet.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(pallet);

        PdfPCell palletValue = getCell(product.getPallet().getPallet(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        palletValue.setMinimumHeight(30);
        palletValue.setColspan(2);
        palletValue.setBorder(Rectangle.BOX);
        palletValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(palletValue);


        PdfPCell palletPlacement = getCell("Размещение на поддоне", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        palletPlacement.setMinimumHeight(30);
        palletPlacement.setColspan(2);
        palletPlacement.setPaddingBottom(2);
        palletPlacement.setBorder(Rectangle.BOX);
        palletPlacement.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(palletPlacement);

        PdfPCell palletPlacementValue = getCell(product.getPalletPlacement().getPalletPlacement(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        palletPlacementValue.setMinimumHeight(30);
        palletPlacementValue.setColspan(2);
        palletPlacementValue.setBorder(Rectangle.BOX);
        palletPlacementValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(palletPlacementValue);

        PdfPCell numberRows = getCell("Рядов на поддоне", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        numberRows.setMinimumHeight(30);
        numberRows.setColspan(2);
        numberRows.setBorder(Rectangle.BOX);
        numberRows.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberRows);

        PdfPCell numberRowsValue = getCell(product.getPalletRows().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        numberRowsValue.setMinimumHeight(30);
        numberRowsValue.setColspan(2);
        numberRowsValue.setBorder(Rectangle.BOX);
        numberRowsValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(numberRowsValue);

        PdfPCell loadCar = getCell("Загрузка автомобиля, шт", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        loadCar.setMinimumHeight(30);
        loadCar.setColspan(2);
        loadCar.setPaddingBottom(2);
        loadCar.setBorder(Rectangle.BOX);
        loadCar.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(loadCar);

        PdfPCell loadCarValue = getCell(product.getNumberLoadCar().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        loadCarValue.setMinimumHeight(30);
        loadCarValue.setColspan(2);
        loadCarValue.setBorder(Rectangle.BOX);
        loadCarValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        rightTable.addCell(loadCarValue);

        rightCellTable.addElement(rightTable);

        return rightCellTable;
    }

    private PdfPCell createLeftTable(ProductDto product, BaseFont baseFont){
        PdfPCell leftCellTable = new PdfPCell();
        leftCellTable.setBorder(Rectangle.NO_BORDER);

        float[] columnWidthsLeftCellTable = {0.3f, 1f, 1.2f, 1.4f, 1.2f};
        PdfPTable leftTable = new PdfPTable(columnWidthsLeftCellTable);
        leftTable.setWidthPercentage(101);

        PdfPCell verticalTitle = getCell("Продукция", PdfPCell.ALIGN_CENTER, baseFont, 15, Font.BOLD);
        verticalTitle.setRotation(-90);
        verticalTitle.setRowspan(4);
        verticalTitle.setBackgroundColor(COLOR);
        verticalTitle.setBorder(Rectangle.BOX);
        leftTable.addCell(verticalTitle);

        PdfPCell innerSizes = getCell("Размеры внутренние", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        innerSizes.setMinimumHeight(30);
        innerSizes.setPaddingBottom(4);
        innerSizes.setBorder(Rectangle.BOX);
        leftTable.addCell(innerSizes);

        PdfPCell productInnerLength = getCell(product.getInnerLength().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productInnerLength.setBorder(Rectangle.BOX);
        productInnerLength.setMinimumHeight(30);
        productInnerLength.setPaddingBottom(4);
        productInnerLength.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productInnerLength);

        PdfPCell productInnerWidth = getCell(product.getInnerWidth().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productInnerWidth.setBorder(Rectangle.BOX);
        productInnerWidth.setMinimumHeight(30);
        productInnerWidth.setPaddingBottom(4);
        productInnerWidth.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productInnerWidth);

        PdfPCell productInnerHeight = getCell(product.getInnerHeight().toString(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productInnerHeight.setBorder(Rectangle.BOX);
        productInnerHeight.setMinimumHeight(30);
        productInnerHeight.setPaddingBottom(4);
        productInnerHeight.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productInnerHeight);

        PdfPCell productProfile = getCell("Профиль", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productProfile.setBorder(Rectangle.BOX);
        productProfile.setPaddingBottom(4);
        productProfile.setMinimumHeight(30);
        productProfile.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productProfile);

        PdfPCell productProfileValue = getCell(product.getProfile().getProfile(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productProfileValue.setBorder(Rectangle.BOX);
        productProfileValue.setPaddingBottom(4);
        productProfileValue.setMinimumHeight(30);
        productProfileValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productProfileValue);

        PdfPCell emptyColumn = getCell(EMPTY_STRING, PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        emptyColumn.setBorder(Rectangle.BOX);
        emptyColumn.setColspan(2);
        emptyColumn.setMinimumHeight(30);
        leftTable.addCell(emptyColumn);

        PdfPCell productCardboardBrand = getCell("Марка картона", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productCardboardBrand.setBorder(Rectangle.BOX);
        productCardboardBrand.setPaddingBottom(4);
        productCardboardBrand.setMinimumHeight(30);
        leftTable.addCell(productCardboardBrand);

        PdfPCell productCardboardBrandValue = getCell(product.getCardboardBrand().getCardboardBrand(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productCardboardBrandValue.setBorder(Rectangle.BOX);
        productCardboardBrandValue.setPaddingBottom(4);
        productCardboardBrandValue.setMinimumHeight(30);
        productCardboardBrandValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productCardboardBrandValue);


        PdfPCell productCelluloseLayer = getCell("Целюлозный слой", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productCelluloseLayer.setBorder(Rectangle.BOX);
        productCelluloseLayer.setPaddingBottom(4);
        productCelluloseLayer.setMinimumHeight(30);
        leftTable.addCell(productCelluloseLayer);

        PdfPCell productCelluloseLayerValue = getCell(product.getCelluloseLayer().getCelluloseLayer(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productCelluloseLayerValue.setBorder(Rectangle.BOX);
        productCelluloseLayerValue.setPaddingBottom(4);
        productCelluloseLayerValue.setMinimumHeight(30);
        productCelluloseLayerValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productCelluloseLayerValue);

        PdfPCell productFaceLayer = getCell("Лицевой слой", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productFaceLayer.setMinimumHeight(30);
        productFaceLayer.setPaddingBottom(2);
        productFaceLayer.setBorder(Rectangle.BOX);
        leftTable.addCell(productFaceLayer);

        PdfPCell productFaceLayerValue = getCell(product.getFaceLayer().getFaceLayer(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productFaceLayerValue.setBorder(Rectangle.BOX);
        productFaceLayerValue.setPaddingBottom(4);
        productFaceLayerValue.setMinimumHeight(30);
        productFaceLayerValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productFaceLayerValue);

        PdfPCell productInnerLayer = getCell("Внутренний слой", PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productInnerLayer.setBorder(Rectangle.BOX);
        productInnerLayer.setPaddingBottom(4);
        productInnerLayer.setMinimumHeight(30);
        productInnerLayer.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productInnerLayer);

        PdfPCell productInnerLayerValue = getCell(product.getInnerLayer().getInnerLayer(), PdfPCell.ALIGN_CENTER, baseFont, 14, Font.NORMAL);
        productInnerLayerValue.setBorder(Rectangle.BOX);
        productInnerLayerValue.setPaddingBottom(4);
        productInnerLayerValue.setMinimumHeight(30);
        productInnerLayerValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productInnerLayerValue);


        PdfPCell productSpecialConditions = getCell("Особые условия", PdfPCell.ALIGN_LEFT, baseFont, 14, Font.BOLD);
        productSpecialConditions.setBorder(Rectangle.BOX);
        productSpecialConditions.setColspan(5);
        productSpecialConditions.setMinimumHeight(20);
        productSpecialConditions.setBackgroundColor(COLOR);
        productSpecialConditions.setPaddingLeft(8);
        productSpecialConditions.setPaddingBottom(4);
        productSpecialConditions.setVerticalAlignment(Element.ALIGN_MIDDLE);
        leftTable.addCell(productSpecialConditions);

        PdfPCell productSpecialConditionsValue = getCell(product.getSpecialConditions(), PdfPCell.ALIGN_LEFT, baseFont, 14, Font.NORMAL);
        productSpecialConditionsValue.setBorder(Rectangle.BOX);
        productSpecialConditionsValue.setColspan(5);
        productSpecialConditionsValue.setPaddingLeft(2);
        productSpecialConditionsValue.setMinimumHeight(90);
        leftTable.addCell(productSpecialConditionsValue);

        leftCellTable.addElement(leftTable);

        return leftCellTable;
    }

    private ProductDto createProduct(){
        ProductDto product = new ProductDto();
        product.setProductNumber(23);
        product.setNew(true);
        product.setProductName("Продукт тест");
        product.setProductCreateDate(LocalDate.now());
        product.setProductUpdateDate(LocalDate.now());

        ClientDto client = new ClientDto(1L);
        client.setLastName("Приймаченко В.О.");
        product.setClient(client);

        ProductTypeDto productType = new ProductTypeDto(1L);
        productType.setProductType("Ассорти 4 Продукта");
        product.setProductType(productType);

        product.setInnerLength(111);
        product.setInnerHeight(222);
        product.setInnerWidth(333);

        ProfileDto profile = new ProfileDto(1L);
        profile.setProfile("B");
        product.setProfile(profile);


        CardboardBrandDto cardboardBrand = new CardboardBrandDto(1L);
        cardboardBrand.setCardboardBrand("T-24");
        product.setCardboardBrand(cardboardBrand);

        CelluloseLayerDto celluloseLayer = new CelluloseLayerDto(1L);
        celluloseLayer.setCelluloseLayer("нет");
        product.setCelluloseLayer(celluloseLayer);

        InnerLayerDto innerLayer = new InnerLayerDto(1L);
        innerLayer.setInnerLayer("бурый");
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

        product.setStamp("One two my you their, them to go out figure, after that, do dsfds sdf dsfsd dsfdsf");

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

        product.setPalletRows(2);
        product.setNumberLoadCar(23);


        return product;
    }

}
