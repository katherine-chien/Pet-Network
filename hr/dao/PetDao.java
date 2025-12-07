package hr.dao;

import java.util.List;

public interface PetDao {
    PetDto get(int petId);
    PetDto getRow(String whereClause);
    List<PetDto> getRows(String whereClause);
    List<PetDto> getAll();
    int save(PetDto pet);
    int update(PetDto pet);
    int delete(int petId);
    
}

