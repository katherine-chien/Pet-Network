package hr.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl extends BaseDaoImpl implements AppointmentDao {


    @Override
    public AppointmentDto get(int appointmentId) {
        String sql = "SELECT appointment_id, vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes FROM Appointment WHERE appointment_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return buildAppointment(rs);
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        return null;
    }


    @Override
    public AppointmentDto getRow(String whereClause) {
        String sql = "SELECT appointment_id, vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes FROM Appointment WHERE " + whereClause + " LIMIT 1";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) return buildAppointment(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AppointmentDto> getRows(String whereClause) {
        String sql = "SELECT appointment_id, vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes FROM Appointment WHERE " + whereClause;
        List<AppointmentDto> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(buildAppointment(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<AppointmentDto> getAll() {
        String sql = "SELECT appointment_id, vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes FROM Appointment";
        List<AppointmentDto> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(buildAppointment(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public int save(AppointmentDto appt) {
        String sql = "INSERT INTO Appointment (vet_id, pet_id, created_by_user_id, start_time, end_time, status, notes) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, appt.getVetId());
            ps.setInt(2, appt.getPetId());
            ps.setInt(3, appt.getCreatedByUserId());
            ps.setTimestamp(4, appt.getStartTime());
            ps.setTimestamp(5, appt.getEndTime());
            ps.setString(6, appt.getStatus());
            ps.setString(7, appt.getNotes());
            int affected = ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                appt.setAppointmentId(id);
                return id;
            }
            return affected;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


    @Override
    public int update(AppointmentDto appt) {
        String sql = "UPDATE Appointment SET vet_id=?, pet_id=?, created_by_user_id=?, start_time=?, end_time=?, status=?, notes=? WHERE appointment_id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appt.getVetId());
            ps.setInt(2, appt.getPetId());
            ps.setInt(3, appt.getCreatedByUserId());
            ps.setTimestamp(4, appt.getStartTime());
            ps.setTimestamp(5, appt.getEndTime());
            ps.setString(6, appt.getStatus());
            ps.setString(7, appt.getNotes());
            ps.setInt(8, appt.getAppointmentId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } 
    }


    @Override
    public int delete(int appointmentId) {
        String sql = "DELETE FROM Appointment WHERE appointment_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private AppointmentDto buildAppointment(ResultSet rs) throws SQLException {
        AppointmentDto d = new AppointmentDto();
        d.setAppointmentId(rs.getInt("appointment_id"));
        d.setVetId(rs.getInt("vet_id")); 
        d.setPetId(rs.getInt("pet_id"));
        d.setCreatedByUserId(rs.getInt("created_by_user_id"));
        d.setStartTime(rs.getTimestamp("start_time"));
        d.setEndTime(rs.getTimestamp("end_time"));
        d.setStatus(rs.getString("status"));
        d.setNotes(rs.getString("notes"));
        return d;
    }
	 

    //get appointments with pet and owner and vet details
    public List<AppointmentWithDetails> getAppointmentsForVet(int vetId) {
        String sql = "SELECT a.appointment_id, a.start_time, a.end_time, a.status, " +
                "p.pet_id, p.name AS pet_name, u.user_id AS owner_id, u.username AS owner_name, v.vet_id, v.clinic_name " +
                "FROM Appointment a " +
                "JOIN Pet p ON a.pet_id = p.pet_id " +
                "JOIN `User` u ON a.created_by_user_id = u.user_id " +
                "JOIN Veterinarian v ON a.vet_id = v.vet_id " +
                "WHERE a.vet_id = ? ORDER BY a.start_time"; 

        List<AppointmentWithDetails> out = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, vetId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AppointmentWithDetails d = new AppointmentWithDetails();
                d.appointmentId = rs.getInt("appointment_id");
                d.start = rs.getTimestamp("start_time");
                d.end = rs.getTimestamp("end_time");
                d.status = rs.getString("status");
                d.petId = rs.getInt("pet_id");
                d.petName = rs.getString("pet_name");
                d.ownerId = rs.getInt("owner_id");
                d.ownerName = rs.getString("owner_name");
                d.vetId = rs.getInt("vet_id");
                d.clinicName = rs.getString("clinic_name");
                out.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }


    public static class AppointmentWithDetails {
        public int appointmentId;
        public Timestamp start;
        public Timestamp end;
        public String status;
        public int petId;
        public String petName;
        public int ownerId;
        public String ownerName;
        public int vetId;
        public String clinicName;

		
		 
        @Override
        public String toString() {
            return "AppointmentWithDetails{" +
                    "appointmentId=" + appointmentId +
                    ", start=" + start +
                    ", end=" + end +
                    ", status='" + status + '\'' +
                    ", petId=" + petId +
                    ", petName='" + petName + '\'' +
                    ", ownerId=" + ownerId +
                    ", ownerName='" + ownerName + '\'' +
                    ", vetId=" + vetId +
                    ", clinicName='" + clinicName + '\'' +
                    '}';
        }
    }
}
