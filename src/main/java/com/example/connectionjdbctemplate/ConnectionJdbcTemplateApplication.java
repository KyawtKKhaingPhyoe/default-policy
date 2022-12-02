package com.example.connectionjdbctemplate;

import com.example.connectionjdbctemplate.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionJdbcTemplateApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public ConnectionJdbcTemplateApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {

        SpringApplication.run(ConnectionJdbcTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeService.deleteAll();

        try{
            employeeService.createEmployeeWithoutTransaction();
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName()+" :: has been caught.");
        }

        employeeService.listAllEmployee().forEach(System.out::println);

        employeeService.deleteAll();

    }
}
