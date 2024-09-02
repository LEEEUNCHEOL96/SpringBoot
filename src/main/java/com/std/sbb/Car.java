package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter // LOMBOK 으로 한방에 정리가능
@Setter // LOMBOK 으로 한방에 정리가능
public class Car {
    private int id;
    private int speed;
    private String name;
    private List<Integer> ids;
}
