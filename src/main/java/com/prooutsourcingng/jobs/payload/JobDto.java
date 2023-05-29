package com.prooutsourcingng.jobs.payload;

import lombok.Data;

@Data
public class JobDto {
    private long id;
    private String title;
    private String description;
    private boolean published;
}
