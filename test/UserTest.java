package test;

import java.sql.Timestamp;
import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();

        System.out.println("=== Insert a test user ===");
        UserDto u = new UserDto();

        u.setRole("normal"); 
        u.setPasswordHash("hash123");
        u.setEmail("testuser@example.com");
        u.setUsername("testuser123");
        u.setCreatedAt(new Timestamp(System.currentTimeMillis()));

		
        int newId = dao.save(u);
        System.out.println("Saved user id: " + newId);


        System.out.println("\n=== Get user by id ===");
        UserDto read = dao.get(newId);
        System.out.println(read);


        System.out.println("\n=== Update user username ===");
        read.setUsername("testuser_updated");
        dao.update(read);
        System.out.println(dao.get(newId));

        System.out.println("\n=== All users (first 10) ===");
        List<UserDto> all = dao.getAll();
        for (int i = 0; i < Math.min(all.size(), 10); i++) System.out.println(all.get(i));



        System.out.println("\n=== Join: user with pets (if any) ===");
        List<UserDaoImpl.UserWithPet> ups = dao.getUserWithPets(newId);
        if (ups.isEmpty()) System.out.println("No pets for this user.");
        else ups.forEach(System.out::println);


        System.out.println("\n=== Delete test user ===");
        dao.delete(newId);
        System.out.println("Deleted. Confirm get() returns null: " + dao.get(newId));


    }
}
