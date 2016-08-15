package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.Size;

public class ProfileDto {

    private Long id;

    @Size(max = 50)
    private String profile;

    public ProfileDto() {
    }

    public ProfileDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProfileDto{");
        sb.append("id=").append(id);
        sb.append(", profile='").append(profile).append('\'');
        sb.append('}');
        return sb.toString();
    }
}