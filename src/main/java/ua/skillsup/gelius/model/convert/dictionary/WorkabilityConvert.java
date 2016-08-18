package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.WorkabilityDto;
import ua.skillsup.gelius.model.entity.dictionary.Workability;

public final class WorkabilityConvert {

    private WorkabilityConvert() {
    }

    public static Workability convert(WorkabilityDto workabilityDto) {
        if (workabilityDto == null) {
            return null;
        }
        Workability workability = new Workability();
        workability.setId(workabilityDto.getId());
        workability.setServiceCenter(workabilityDto.getServiceCenter());
        workability.setGroupPriority(workabilityDto.getGroupPriority());
        workability.setElementPriority(workabilityDto.getElementPriority());

        return workability;
    }

    public static WorkabilityDto convert(Workability workability) {
        if (workability == null) {
            return null;
        }
        WorkabilityDto workabilityDto = new WorkabilityDto();
        workabilityDto.setId(workability.getId());
        workabilityDto.setServiceCenter(workability.getServiceCenter());
        workabilityDto.setGroupPriority(workability.getGroupPriority());
        workabilityDto.setElementPriority(workability.getElementPriority());

        return workabilityDto;
    }
}