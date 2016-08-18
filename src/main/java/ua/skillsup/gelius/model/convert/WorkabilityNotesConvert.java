package ua.skillsup.gelius.model.convert;

import ua.skillsup.gelius.model.convert.dictionary.WorkabilityConvert;
import ua.skillsup.gelius.model.dto.WorkabilityNotesDto;
import ua.skillsup.gelius.model.entity.WorkabilityNotes;

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
        workabilityNotes.setServiceCenter(WorkabilityConvert.convert(workabilityNotesDto.getSericeCenter()));

        return workabilityNotes;
    }

    public static WorkabilityNotesDto convert(WorkabilityNotes workabilityNotes) {
        if (workabilityNotes == null) {
            return null;
        }
        WorkabilityNotesDto workabilityNotesDto = new WorkabilityNotesDto();
        workabilityNotesDto.setId(workabilityNotes.getId());
        workabilityNotesDto.setProduct(ProductConvert.convert(workabilityNotes.getProduct()));
        workabilityNotesDto.setSericeCenter(WorkabilityConvert.convert(workabilityNotes.getServiceCenter()));

        return workabilityNotesDto;
    }
}