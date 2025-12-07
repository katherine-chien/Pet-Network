package hr.dao;

import java.sql.Date;

public class PetDto extends BaseDto {
    private int petId;
    private int ownerUserId;
    private String name;
    private String species; 
    private String breed;
    private Date birthdate;
    private String vaccinationInfo;

	 
    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }

    public int getOwnerUserId() { return ownerUserId; }
    public void setOwnerUserId(int ownerUserId) { this.ownerUserId = ownerUserId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; } 

    public Date getBirthdate() { return birthdate; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }

    public String getVaccinationInfo() { return vaccinationInfo; } 
    public void setVaccinationInfo(String vaccinationInfo) { this.vaccinationInfo = vaccinationInfo; }


    @Override
    public String toString() {
        return "PetDto{" +
                "petId=" + petId +
                ", ownerUserId=" + ownerUserId +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

}

