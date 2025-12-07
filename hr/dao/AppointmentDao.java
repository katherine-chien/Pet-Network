package hr.dao;

import java.util.List;

public interface AppointmentDao {
    AppointmentDto get(int appointmentId); 
    AppointmentDto getRow(String whereClause);  
    List<AppointmentDto> getRows(String whereClause);
    List<AppointmentDto> getAll();
    int save(AppointmentDto appt);
    int update(AppointmentDto appt); 
    int delete(int appointmentId);
}



