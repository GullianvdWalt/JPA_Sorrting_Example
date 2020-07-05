package com.gvdw.SortingExample.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.gvdw.SortingExample.Models.Employee;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee, Long> {
    
    @Query("SELECT DISTINCT e.dept FROM Employee e")
    List<String> findAllDepartments(Sort sort);
}
