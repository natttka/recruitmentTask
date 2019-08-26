package com.nkrzicuk.recruitmenttask;

import java.util.List;

public interface IMyService {

    MyDomainObject addName(MyDomainObjectDTO myObjectDTO);
    List<MyDomainObject> getAllNames();


}
