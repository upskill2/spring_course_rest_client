package com.spring.rest;

import com.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.IDN;
import java.util.List;

@Component
public class Communication {

    private static final String URL = "http://localhost:8080/spring_course_rest/employees";

    @Autowired
    private RestTemplate restTemplate;

    public List<Employee> getAllEmps() {

        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
        });

        return responseEntity.getBody();
    }

    public Employee getEmployee(int id) {

        return restTemplate.getForObject(URL + "/" + id, Employee.class);
    }

    public void saveEmp(Employee employee) {

        int id = employee.getId();

        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New Emp was added into DB with Id + " + id);
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, employee);
            System.out.println("Employee information was updated for Id + " + id);
            System.out.println(employee);
        }


    }

    public void deleteEmp(int id) {

        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with Id was deleted " + id);

    }

}
