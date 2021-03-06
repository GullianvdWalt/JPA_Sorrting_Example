package com.gvdw.SortingExample.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String dept;
    private double salary;
}
