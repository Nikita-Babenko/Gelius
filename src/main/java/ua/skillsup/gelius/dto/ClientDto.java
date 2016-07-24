package ua.skillsup.gelius.dto;

import java.util.Objects;

public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String phoneNumber;
    private String address;
    private String description;

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
        return Objects.equals(id, clientDto.id) &&
                Objects.equals(firstName, clientDto.firstName) &&
                Objects.equals(lastName, clientDto.lastName) &&
                Objects.equals(companyName, clientDto.companyName) &&
                Objects.equals(phoneNumber, clientDto.phoneNumber) &&
                Objects.equals(address, clientDto.address) &&
                Objects.equals(description, clientDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, companyName, phoneNumber, address, description);
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
