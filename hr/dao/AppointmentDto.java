package hr.dao;

import java.sql.Timestamp;

public class AppointmentDto extends BaseDto {
    private int appointmentId;
    private int vetId;
    private int petId;
    private int createdByUserId;
    private Timestamp startTime; 
    private Timestamp endTime;

	// use ENUM as string
    private String status; 
    private String notes;

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getVetId() { return vetId; }
    public void setVetId(int vetId) { this.vetId = vetId; }
	

    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; } 

    public int getCreatedByUserId() { return createdByUserId; }
    public void setCreatedByUserId(int createdByUserId) { this.createdByUserId = createdByUserId; }
 

    public Timestamp getStartTime() { return startTime; } 
    public void setStartTime(Timestamp startTime) { this.startTime = startTime; } 
 
    public Timestamp getEndTime() { return endTime; }
    public void setEndTime(Timestamp endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }


    @Override
    public String toString() {
        return "AppointmentDto{" +
                "appointmentId=" + appointmentId +
                ", vetId=" + vetId +
                ", petId=" + petId +
                ", createdByUserId=" + createdByUserId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                '}';

    }
}
