package org.example.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class WorkerAge {
    private String type;
    private String name;
    private LocalDate date;
}
