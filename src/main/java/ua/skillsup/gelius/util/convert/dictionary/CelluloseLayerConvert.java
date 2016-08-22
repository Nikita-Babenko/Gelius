package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.CelluloseLayer;
import ua.skillsup.gelius.model.dto.dictionary.CelluloseLayerDto;

public final class CelluloseLayerConvert {

    private CelluloseLayerConvert() {
    }

    public static CelluloseLayer convert(CelluloseLayerDto celluloseLayerDto) {
        if (celluloseLayerDto == null) {
            return null;
        }
        CelluloseLayer celluloseLayer = new CelluloseLayer();
        celluloseLayer.setId(celluloseLayerDto.getId());
        celluloseLayer.setCelluloseLayer(celluloseLayerDto.getCelluloseLayer());

        return celluloseLayer;
    }

    public static CelluloseLayerDto convert(CelluloseLayer celluloseLayer) {
        if (celluloseLayer == null) {
            return null;
        }
        CelluloseLayerDto celluloseLayerDto = new CelluloseLayerDto();
        celluloseLayerDto.setId(celluloseLayer.getId());
        celluloseLayerDto.setCelluloseLayer(celluloseLayer.getCelluloseLayer());

        return celluloseLayerDto;
    }
}