package com.jcaboclo.model.Response;

import com.jcaboclo.model.entity.Student;
import lombok.Data;

@Data
public class StudentResponse {

    private Long idRegistration;
    private String firstName;
    private String lastName;

    public static StudentResponse fromEntity(Student entity) {
        StudentResponse response = new StudentResponse();
        response.setIdRegistration(entity.getIdRegistration());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        return response;
    }
}
