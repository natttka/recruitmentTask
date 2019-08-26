package com.nkrzicuk.recruitmenttask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService implements IMyService {

    private MyRepository repository;

    @Override
    public MyDomainObject addName(MyDomainObjectDTO myObjectDTO) {
        MyDomainObject myObject = new MyDomainObject();
        myObject.setName(myObjectDTO.getName());
        return repository.save(myObject);
    }

    @Override
    public List<MyDomainObject> getAllNames() {
        return repository.findAll();
    }

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
}
