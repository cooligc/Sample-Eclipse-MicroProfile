package com.skc.labs;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class EmpoloyeeRepository {

    private static final ConcurrentHashMap<String,Employee> EMPLOYE_REPOSITORY = new ConcurrentHashMap<String, Employee>();

    public Employee create(Employee employee){
        employee.setId(employee.hashCode());
        EMPLOYE_REPOSITORY.put(employee.getId()+"",employee);
        LogUtils.log("Employee with id="+employee.getId()+" added successfully");
        return employee;
    }

    public Employee get(String id){
        return EMPLOYE_REPOSITORY.get(id);
    }

    public void delete(String id){
        EMPLOYE_REPOSITORY.remove(id);
    }

    public Employee update(String id , Employee employee){
        Employee oldObject = EMPLOYE_REPOSITORY.get(id);
        if(oldObject == null){
            LogUtils.log("No Employee found for updation with id = "+id);
            //Exception handling is missing here
            return create(employee);
        }
        employee.setId(oldObject.getId());
        EMPLOYE_REPOSITORY.put(id,employee);
        return employee;
    }

    public List<Employee> getAll() {
        return  new ArrayList<Employee>(EMPLOYE_REPOSITORY.values());
    }
}
