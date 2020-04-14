package mps.doorbellsystem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Flag {
    @Id
    private String name;
    private boolean value;
}
