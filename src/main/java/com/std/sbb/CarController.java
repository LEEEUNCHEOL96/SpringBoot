package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    int lastId;
    List<Cars> cars;

    CarController() {
        lastId = 0;
        cars = new ArrayList<>();
    }

    @GetMapping("/car/addCar")
    @ResponseBody
    public String addCar(@RequestParam("name") String name,
                         @RequestParam("madeBy") String madeBy) {
        lastId++;
        Cars c = new Cars(lastId, name, madeBy);

        cars.add(c);

        return c.getId() + "번 자동차가 추가되었습니다.";
    }


    @GetMapping("/car/remove")
    @ResponseBody
    public String removeCar(@RequestParam("id") int id) {

        Cars removeCar = findCarById(id);

        if (removeCar == null) {
            return id + "번 자동차는 존재하지 않습니다.";
        } else {
            cars.remove(removeCar);
        }

        return id + "번 자동차가 삭제되었습니다.";
    }

    @GetMapping("/car/modify")
    @ResponseBody
    public String modifyCar(@RequestParam("id") int id,
                            @RequestParam("name") String name,
                            @RequestParam("madeBy") String madeBy) {

        Cars modifyCar = findCarById(id);

        if (modifyCar == null) {
            return id + "번 자동차는 존재하지 않습니다.";
        } else {
            modifyCar.setName(name);
            modifyCar.setMadeBy(madeBy);
        }


        return id + "번째 자동차가 수정되었습니다.";
    }


    @GetMapping("/car/list")
    @ResponseBody
    public List<Cars> getCars() {
        System.out.println(cars);
        return cars;
    }

    private Cars findCarById (int id ){
        for ( Cars c : cars){
            if (c.getId()== id){
                return c;
            }
        } return null;
    }
}


@AllArgsConstructor
@Getter
@Setter
@ToString
class Cars {
    private int id;
    private String name;
    private String madeBy;
}

