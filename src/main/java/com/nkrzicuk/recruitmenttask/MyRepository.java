package com.nkrzicuk.recruitmenttask;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyDomainObject, Long> {


}
