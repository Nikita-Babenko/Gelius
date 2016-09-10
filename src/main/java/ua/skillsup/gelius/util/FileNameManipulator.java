package ua.skillsup.gelius.util;

import ua.skillsup.gelius.model.Data;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileNameManipulator {
    public static String addSuffixToFileName(String fileName) {
        Map<PART, String> fileParts = explodeFileName(fileName);
        return fileParts.get(PART.NAME) + Data.FILENAME_SUFFIX + "." + fileParts.get(PART.EXT);
    }

    //Returns EnumMap with PART.NAME and PART.EXT keys.
    public static Map<PART, String> explodeFileName(String fileName) {
        Map<PART, String> data = new EnumMap<>(PART.class);
        data.put(PART.EXT, "");
        List<String> parts = Arrays.asList(fileName.split("\\."));

        if (parts.size() == 1) { //only name, without extension
            data.put(PART.NAME, fileName);
        } else {
            int partsCount = parts.size();
            String name = parts.subList(0, partsCount - 1).
                stream().collect(Collectors.joining("."));
            String extension = parts.get(partsCount - 1);
            data.put(PART.NAME, name);
            data.put(PART.EXT, extension);
        }

        return data;
    }

    public enum PART {
        NAME, EXT;
    }
}
