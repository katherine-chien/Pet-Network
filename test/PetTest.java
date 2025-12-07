package test;

import java.sql.Date;
import java.util.List;


public class PetTest {
    public static void main(String[] args) {
        PetDaoImpl dao = new PetDaoImpl();

        System.out.println("=== Insert a test pet ===");
        PetDto p = new PetDto();


        //to check owner user id exists; create a temporary user first using UserDaoImpl if needed


		// change to an existing user_id in your DB
        p.setOwnerUserId(1); 
        p.setName("Fluffy");
        p.setSpecies("dog");
        p.setBreed("Shiba Inu");
        p.setBirthdate(Date.valueOf("2020-05-01"));
        p.setVaccinationInfo("Rabies:2021-01-01; Distemper:2021-01-01");
        int newId = dao.save(p);
        System.out.println("Saved pet id: " + newId);

        System.out.println("\n=== Get pet by id ===");
        PetDto read = dao.get(newId);
        System.out.println(read);

        System.out.println("\n=== Update pet name ===");
        read.setName("Fluffy Jr");
        dao.update(read);
        System.out.println(dao.get(newId));

        System.out.println("\n=== Find dogs with owners ===");
        List<PetDaoImpl.PetWithOwner> dogs = dao.getPetsWithOwnersBySpecies("dog");
        if (dogs.isEmpty()) System.out.println("No dogs found.");
        else dogs.forEach(System.out::println);

        System.out.println("\n=== Delete test pet ===");
        dao.delete(newId);
        System.out.println("Deleted. Confirm get() returns null: " + dao.get(newId));
    }
}
