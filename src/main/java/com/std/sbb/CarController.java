package com.std.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    int lastId;
    List<Car> cars;

    CarController(){
        lastId = 0;
        cars = new ArrayList<>();
    }
}

    @GetMapping("/car/addCar")
    @ResponseBody
    public String addCar (@RequestParam("name") String name ,
                          @RequestParam ("madeBy") String madeBy ){



        return String.format("%d 번 자동차가 추가되었습니다.",carList.getId());
    }
}
