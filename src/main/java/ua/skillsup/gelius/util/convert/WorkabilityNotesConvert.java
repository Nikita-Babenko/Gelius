package ua.skillsup.gelius.util.convert;

import ua.skillsup.gelius.dao.entity.WorkabilityNotes;
import ua.skillsup.gelius.model.dto.WorkabilityNotesDto;
import ua.skillsup.gelius.util.convert.dictionary.WorkabilityConvert;

public final class WorkabilityNotesConvert {

    private WorkabilityNotesConvert() {
    }

    public static WorkabilityNotes convert(WorkabilityNotesDto workabilityNotesDto) {
        if (workabilityNotesDto == null) {
            return null;
        }
        WorkabilityNotes workabilityNotes = new WorkabilityNotes();
        workabilityNotes.setId(workabilityNotesDto.getId());
        workabilityNotes.setProduct(ProductConvert.convert(workabilityNotesDto.getProduct()));
        workabilityNotes.setServiceCenter(WorkabilityConvert.convert(workabilityNotesDto.getServiceCenter()));
        workabilityNotes.setNote(workabilityNotesDto.getNote());

        return workabilityNotes;
    }

    public static WorkabilityNotesDto convert(WorkabilityNotes workabilityNotes) {
        if (workabilityNotes == null) {
            return null;
        }
        WorkabilityNotesDto workabilityNotesDto = new WorkabilityNotesDto();
        workabilityNotesDto.setId(workabilityNotes.getId());
        workabilityNotesDto.setProduct(ProductConvert.convert(workabilityNotes.getProduct()));
        workabilityNotesDto.setServiceCenter(WorkabilityConvert.convert(workabilityNotes.getServiceCenter()));
        workabilityNotesDto.setNote(workabilityNotes.getNote());

        return workabilityNotesDto;
    }
}