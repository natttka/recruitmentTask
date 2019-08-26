package com.nkrzicuk.recruitmenttask;

import javax.validation.constraints.NotBlank;

public class MyDomainObjectDTO {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
