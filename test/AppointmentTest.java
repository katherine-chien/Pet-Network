package test;

import java.sql.Timestamp;
import java.util.List; 

public class AppointmentTest {
    public static void main(String[] args) {
        AppointmentDaoImpl dao = new AppointmentDaoImpl();

        System.out.println("=== Insert a test appointment ===");
        AppointmentDto a = new AppointmentDto();

        // Make sure vet_id, pet_id, created_by_user_id exist the DB
        a.setVetId(1);
        a.setPetId(1);
        a.setCreatedByUserId(1);

        a.setStartTime(new Timestamp(System.currentTimeMillis() + 3600_000)); // 1 hour from now

        a.setEndTime(new Timestamp(System.currentTimeMillis() + 7200_000));   // 2 hours from now

        a.setStatus("scheduled");
        a.setNotes("Test appointment");
        int id = dao.save(a);
        System.out.println("Saved appointment id: " + id);


        System.out.println("\n=== Get appointment by id ===");
        System.out.println(dao.get(id));

        System.out.println("\n=== Update appointment status ==="); 
        a.setStatus("completed"); 
        dao.update(a);
        System.out.println(dao.get(id));

        System.out.println("\n=== Get appointments for vet 1 (join) ===");
        List<AppointmentDaoImpl.AppointmentWithDetails> list = dao.getAppointmentsForVet(1);
        if (list.isEmpty()) System.out.println("No appointments found.");
        else list.forEach(System.out::println);

        System.out.println("\n=== Delete appointment ===");
        dao.delete(id);
        System.out.println("Deleted. Confirm get() returns null: " + dao.get(id));
    }
}
