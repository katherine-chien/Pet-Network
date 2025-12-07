package hr.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PetDaoImpl extends BaseDaoImpl implements PetDao {


    @Override
    public PetDto get(int petId) {
        String sql = "SELECT pet_id, owner_user_id, name, species, breed, birthdate, vaccination_info FROM Pet WHERE pet_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, petId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return buildPetDto(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public PetDto getRow(String whereClause) {
        String sql = "SELECT pet_id, owner_user_id, name, species, breed, birthdate, vaccination_info FROM Pet WHERE " + whereClause + " LIMIT 1";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) return buildPetDto(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public List<PetDto> getRows(String whereClause) {
        String sql = "SELECT pet_id, owner_user_id, name, species, breed, birthdate, vaccination_info FROM Pet WHERE " + whereClause;
        List<PetDto> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(buildPetDto(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    @Override
    public List<PetDto> getAll() {
        String sql = "SELECT pet_id, owner_user_id, name, species, breed, birthdate, vaccination_info FROM Pet";
        List<PetDto> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(buildPetDto(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    @Override
    public int save(PetDto pet) {
        String sql = "INSERT INTO Pet (owner_user_id, name, species, breed, birthdate, vaccination_info) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, pet.getOwnerUserId());
            ps.setString(2, pet.getName());
            ps.setString(3, pet.getSpecies());
            ps.setString(4, pet.getBreed());
            ps.setDate(5, pet.getBirthdate());
            ps.setString(6, pet.getVaccinationInfo());
            int affected = ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                pet.setPetId(id);
                return id;
            }

            return affected;

        } catch (SQLException e) {
            e.printStackTrace(); 
            return -1;
        }
    }



    @Override
    public int update(PetDto pet) {
        String sql = "UPDATE Pet SET owner_user_id = ?, name = ?, species = ?, breed = ?, birthdate = ?, vaccination_info = ? WHERE pet_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pet.getOwnerUserId());
            ps.setString(2, pet.getName());
            ps.setString(3, pet.getSpecies());
            ps.setString(4, pet.getBreed());
            ps.setDate(5, pet.getBirthdate());
            ps.setString(6, pet.getVaccinationInfo());
            ps.setInt(7, pet.getPetId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


    @Override
    public int delete(int petId) {
        String sql = "DELETE FROM Pet WHERE pet_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, petId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private PetDto buildPetDto(ResultSet rs) throws SQLException {
        PetDto p = new PetDto();
        p.setPetId(rs.getInt("pet_id"));
        p.setOwnerUserId(rs.getInt("owner_user_id"));
        p.setName(rs.getString("name"));
        p.setSpecies(rs.getString("species"));
        p.setBreed(rs.getString("breed"));
        p.setBirthdate(rs.getDate("birthdate"));
        p.setVaccinationInfo(rs.getString("vaccination_info"));
		
        return p;
    }

    // get pets with owner username
    public List<PetWithOwner> getPetsWithOwnersBySpecies(String species) {
        String sql = "SELECT p.pet_id, p.name AS pet_name, p.species, p.breed, u.user_id, u.username " +
                     "FROM Pet p JOIN `User` u ON p.owner_user_id = u.user_id WHERE p.species = ?";
        List<PetWithOwner> out = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, species);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PetWithOwner r = new PetWithOwner();
                r.petId = rs.getInt("pet_id");
                r.petName = rs.getString("pet_name");
                r.species = rs.getString("species");
                r.breed = rs.getString("breed");
                r.ownerId = rs.getInt("user_id");
                r.ownerUsername = rs.getString("username");
                out.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }



    public static class PetWithOwner {
        public int petId;
        public String petName;
        public String species;
        public String breed;
        public int ownerId;
        public String ownerUsername;



        @Override
        public String toString() {
            return "PetWithOwner{" +
                    "petId=" + petId +
                    ", petName='" + petName + '\'' +
                    ", species='" + species + '\'' +
                    ", breed='" + breed + '\'' +
                    ", ownerId=" + ownerId +
                    ", ownerUsername='" + ownerUsername + '\'' +
                    '}';
        }

    }

}
