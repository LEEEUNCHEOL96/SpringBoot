package com.std.sbb;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class AddPerson {
    private int count2;
    private String name ;
    private int age ;

    public String toString() {
        return "id:" + count2 + ", name: " + name + ", age: " + age;
    }

}

