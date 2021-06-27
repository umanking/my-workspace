package com.example.basicwebflux.event.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomEvent {

    private String name;
    private LocalDateTime issueDate;

}
