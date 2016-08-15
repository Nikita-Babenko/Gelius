package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.FormatDto;
import ua.skillsup.gelius.model.entity.dictionary.Format;

public final class FormatConvert {

    private FormatConvert() {
    }

    public static Format convert(FormatDto formatDto) {
        if (formatDto == null) {
            return null;
        }
        Format format = new Format();
        format.setId(formatDto.getId());
        format.setFormat(formatDto.getFormat());

        return format;
    }

    public static FormatDto convert(Format format) {
        if (format == null) {
            return null;
        }
        FormatDto formatDto = new FormatDto();
        formatDto.setId(format.getId());
        formatDto.setFormat(format.getFormat());

        return formatDto;
    }
}