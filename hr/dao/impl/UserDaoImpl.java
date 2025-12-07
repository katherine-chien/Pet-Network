package hr.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List; 
 
 
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public UserDto get(int userId) {
        String sql = "SELECT user_id, role, password_hash, email, username, created_at FROM `User` WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) return buildUserDto(rs);
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return null;
    }



    @Override
    public UserDto getRow(String whereClause) {
        String sql = "SELECT user_id, role, password_hash, email, username, created_at FROM `User` WHERE " + whereClause + " LIMIT 1";
        try (Connection conn = getConnection();   
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);


            if (rs.next()) return buildUserDto(rs);
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return null;

    }




    @Override
    public List<UserDto> getRows(String whereClause) {
        String sql = "SELECT user_id, role, password_hash, email, username, created_at FROM `User` WHERE " + whereClause;
        List<UserDto> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(buildUserDto(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }





    @Override
    public List<UserDto> getAll() {
        String sql = "SELECT user_id, role, password_hash, email, username, created_at FROM `User`";
        List<UserDto> list = new ArrayList<>();

        try (Connection conn = getConnection(); 
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) list.add(buildUserDto(rs));
        } catch (SQLException e) { 

            e.printStackTrace(); 
        }
        return list;
    }




    @Override

    public int save(UserDto user) {
        String sql = "INSERT INTO `User` (role, password_hash, email, username, created_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getRole());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setTimestamp(5, user.getCreatedAt());

            int affected = ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                user.setUserId(id);
                return id;
            }


            return affected;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;

        }
    }





    @Override
    public int update(UserDto user) {
        String sql = "UPDATE `User` SET role = ?, password_hash = ?, email = ?, username = ? WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getRole());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setInt(5, user.getUserId()); 
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }



    @Override
    public int delete(int userId) {
        String sql = "DELETE FROM `User` WHERE user_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

            return -1;
        }
    }

    private UserDto buildUserDto(ResultSet rs) throws SQLException {
        UserDto d = new UserDto();
        d.setUserId(rs.getInt("user_id"));
        d.setRole(rs.getString("role"));
        d.setPasswordHash(rs.getString("password_hash"));
        d.setEmail(rs.getString("email"));
        d.setUsername(rs.getString("username"));
        d.setCreatedAt(rs.getTimestamp("created_at"));
        return d;
    }



    // example of join the query, get user and their pets which is useful for Actor's Action
    public List<UserWithPet> getUserWithPets(int userId) {
        String sql = "SELECT u.user_id, u.username, p.pet_id, p.name AS pet_name, p.species, p.breed " +
                     "FROM `User` u JOIN Pet p ON u.user_id = p.owner_user_id WHERE u.user_id = ?";

        List<UserWithPet> out = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                UserWithPet r = new UserWithPet();
                r.userId = rs.getInt("user_id");
                r.username = rs.getString("username");
                r.petId = rs.getInt("pet_id");
                r.petName = rs.getString("pet_name");
                r.species = rs.getString("species");
                r.breed = rs.getString("breed");
                out.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }



    // small helper class for join output

    public static class UserWithPet {
        public int userId;
        public String username;
        public int petId;
        public String petName;
        public String species;
        public String breed;




        @Override
        public String toString() {
            return "UserWithPet{" +
                    "userId=" + userId +
                    ", username='" + username + '\'' +
                    ", petId=" + petId +
                    ", petName='" + petName + '\'' + 
                    ", species='" + species + '\'' +
                    ", breed='" + breed + '\'' +
                    '}';

        }

    }

}
