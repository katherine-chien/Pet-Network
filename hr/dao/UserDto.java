package hr.dao;

import java.sql.Timestamp;

public class UserDto extends BaseDto {
    private int userId;
    private String role;
    private String passwordHash;
    private String email;
    private String username;
    private Timestamp createdAt;

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; } 


    public String getRole() { return role; }         
    public void setRole(String role) { this.role = role; }


    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
      

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


	  
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
 

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }



	
    @Override
    public String toString() { 
        return "UserDto{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt + 
                '}';

    }

}
