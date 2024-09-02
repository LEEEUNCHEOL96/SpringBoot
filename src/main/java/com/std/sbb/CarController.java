package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@GetMapping("/car/addCar")
@ResponseBody
public String addCar(@RequestParam("name") String name,
                     @RequestParam("madeBy") String madeBy) {
    lastId++;
    Car c = new Car(lastId, name, madeBy);

    carList.add(c);

    return String.format("%d 번 자동차가 추가되었습니다.", lastId);
}

@Controller
public class CarController {
    List<Car> carList;
    private final int lastId;

    CarController() {
        lastId = 0;
        carList = new ArrayList<>();
    }

}