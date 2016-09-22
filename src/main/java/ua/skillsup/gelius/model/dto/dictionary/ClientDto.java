package ua.skillsup.gelius.model.dto.dictionary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class ClientDto {

    private Long id;

    @Size(max = 30)
    private String firstName;

    @Size(max = 30)
    private String lastName;

    @NotNull
    @Size(max = 50)
    private String companyName;

    @Size(max = 20)
    private String phoneNumber;

    @Size(max = 200)
    private String address;

    private String description;

    public ClientDto() {
    }

    public ClientDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(firstName, clientDto.firstName) &&
                Objects.equals(lastName, clientDto.lastName) &&
                Objects.equals(companyName, clientDto.companyName) &&
                Objects.equals(phoneNumber, clientDto.phoneNumber) &&
                Objects.equals(address, clientDto.address) &&
                Objects.equals(description, clientDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, companyName, phoneNumber, address, description);
    }

    @Override
    public String toString() {
        return "ClientDto{" + "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
