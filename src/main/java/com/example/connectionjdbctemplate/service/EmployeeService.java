package com.example.connectionjdbctemplate.service;

import com.example.connectionjdbctemplate.dao.EmployeeDao;
import com.example.connectionjdbctemplate.ds.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao dao;

    public EmployeeService(EmployeeDao dao){
        this.dao = dao;
    }
    @Transactional
    public void createEmployeeWithTransaction() throws InterruptedException{
        saveEmployee();
        System.out.println(3/0);
    }

    public void createEmployeeWithoutTransaction() throws InterruptedException{
        saveEmployee();
    }

    public List<Employee> listAllEmployee(){
        return dao.listAllEmployee();
    }

    public void deleteAll(){
        dao.removeAll();
    }

    public void saveEmployee() throws InterruptedException{
        dao.createEmployee(16,"Ei","Thandar Aung","eithandar123@gmail.com",5000);
        dao.createEmployee(20,"Phyo","Phyo","phyo123@gmail.com",5000);
        dao.createEmployee(19,"Boat","Boat","boat123@gmail.com",5000);
    }

}
