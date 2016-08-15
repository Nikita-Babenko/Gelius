package ua.skillsup.gelius.model.convert;

import ua.skillsup.gelius.model.dto.PrintDto;
import ua.skillsup.gelius.model.entity.Print;

public final class PrintConvert {

    private PrintConvert() {
    }

    public static Print convert(PrintDto printDto) {
        if (printDto == null) {
            return null;
        }
        Print print = new Print();
        print.setId(printDto.getId());
        print.setProduct(ProductConvert.convert(printDto.getProduct()));
        print.setColor(printDto.getColor());
        print.setName(printDto.getName());
        print.setSquareSeal(printDto.getSquareSeal());

        return print;
    }

    public static PrintDto convert(Print print) {
        if (print == null) {
            return null;
        }
        PrintDto printDto = new PrintDto();
        printDto.setId(print.getId());
        printDto.setProduct(ProductConvert.convert(print.getProduct()));
        printDto.setColor(print.getColor());
        printDto.setName(print.getName());
        printDto.setSquareSeal(print.getSquareSeal());

        return printDto;
    }
}