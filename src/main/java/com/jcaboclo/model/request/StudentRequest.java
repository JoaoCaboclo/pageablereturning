package com.jcaboclo.model.request;

import lombok.Data;

@Data
public class StudentRequest {

    private Long idRegistration;
    private String firstName;
    private String lastName;
}
