package ua.skillsup.gelius.model.dictionary;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity       //  Профиль
@Table(name = "PROFILE")
public class Profile {

    @Id
    @Column(name = "PROFILE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    @Column(name = "PROFILE")
    private String profile;

    public Profile(String profile) {
        this.profile = profile;
    }

    public Profile() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile1 = (Profile) o;
        return Objects.equals(getId(), profile1.getId()) &&
                Objects.equals(getProfile(), profile1.getProfile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProfile());
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                '}';
    }
}