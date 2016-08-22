package ua.skillsup.gelius.util.convert.dictionary;

import ua.skillsup.gelius.dao.entity.dictionary.Profile;
import ua.skillsup.gelius.model.dto.dictionary.ProfileDto;

public final class ProfileConvert {

    private ProfileConvert() {
    }

    public static Profile convert(ProfileDto profileDto) {
        if (profileDto == null) {
            return null;
        }
        Profile profile = new Profile();
        profile.setId(profileDto.getId());
        profile.setProfile(profileDto.getProfile());

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