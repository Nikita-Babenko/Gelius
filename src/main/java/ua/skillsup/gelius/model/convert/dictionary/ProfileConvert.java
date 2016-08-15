package ua.skillsup.gelius.model.convert.dictionary;

import ua.skillsup.gelius.model.dto.dictionary.ProfileDto;
import ua.skillsup.gelius.model.entity.dictionary.Profile;

public final class ProfileConvert {

    private ProfileConvert() {
    }

    public static Profile convert(ProfileDto profileDto) {
        if (profileDto == null) {
            return null;
        }
        Profile profile = new Profile();
        profile.setId(profile.getId());
        profile.setProfile(profile.getProfile());

        return profile;
    }

    public static ProfileDto convert(Profile profile) {
        if (profile == null) {
            return null;
        }
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setProfile(profile.getProfile());

        return profileDto;
    }
}