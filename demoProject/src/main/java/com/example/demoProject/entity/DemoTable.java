package com.example.demoProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "demo_table")
public class DemoTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long demoId;
    private String demoName;
    private String demoDescription;
}
