/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvdw.SortingExample.Controllers;

import com.gvdw.SortingExample.Models.Employee;
import com.gvdw.SortingExample.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepo repository;
    
    @GetMapping("/employees")
    public String getEmployees(@PageableDefault(size = 10, sort = "id")Pageable pageable,
            Model model){
        
        Page<Employee> page = repository.findAll(pageable);
        List<Sort.Order> sortOrders = page.getSort().stream().collect(Collectors.toList());
        if(sortOrders.size() > 0){
            Sort.Order order = sortOrders.get(0);
            model.addAttribute("sortProperty", order.getProperty());
            model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
        }
        model.addAttribute("page", page);
        return "employee-page";
    }
    
    @GetMapping("departments")
     public String getDepartments(@SortDefault(sort="dept",direction = Sort.Direction.ASC)
                                           Sort sort, Model model) {
      List<String> depts = repository.findAllDepartments(sort);
      model.addAttribute("depts", depts);
      return "dept-page";
  }
}
