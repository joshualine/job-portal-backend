package com.prooutsourcingng.jobs.payload;

import lombok.Data;

@Data
public class ApplicationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String resume;
}
