package com.example.demoProject.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name= "Table-Demo")
public class TableDemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tableId;
    @NotNull
    private String tableName;
}
