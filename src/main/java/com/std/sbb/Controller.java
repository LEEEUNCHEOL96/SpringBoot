package com.std.sbb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


@org.springframework.stereotype.Controller
public class Controller {
    private int count;
    private int count2;


    // 생성자 함수를 통해 정의하는게 더욱 깔끔한 코딩이다.
    Controller(){
        count = -1;
        count2 = 1;
    }

    @GetMapping("/home/main")
    @ResponseBody
    public String main1() {
        return "안녕하세요.";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String main2() {
        return "반갑습니다.";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String main3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/count")
    @ResponseBody
    public int Count() {
        count++;
        return count;
    }

    @GetMapping("/home/discount")
    @ResponseBody
    public int discount(){
        count2 --;
        return count2;
    }


    @GetMapping("/home/plus")
    @ResponseBody
    public int plus(@RequestParam(value = "a", defaultValue ="0") int a ,
                    @RequestParam(value = "b",defaultValue = "0") int b){
        return a + b;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int minus(@RequestParam(value = "a",defaultValue = "0") int a,
                     @RequestParam(value = "b",defaultValue = "0") int b){
        return a - b;
    }


    @GetMapping("/home/mult")
    @ResponseBody
    public int multiply(@RequestParam(value = "a" ,defaultValue = "0") int a,
                        @RequestParam(value = "b" ,defaultValue = "0") int b){
        return a * b;
    }


    @GetMapping("/home/divide")
    @ResponseBody
    public int divide(@RequestParam(value = "a" ,defaultValue = "0") int a,
                      @RequestParam(value = "b" ,defaultValue = "0") int b){
        return a / b;
    }
    @GetMapping("/home/car")
    @ResponseBody
    public Car showReturnCar(){
        Car car = new Car (1, 100, "벤츠", new ArrayList<>());

        car.setId(2);
        car.setSpeed(200);
        car.setName("아우디");
        car.setIds(new ArrayList<>(){{
            add(2);
            add(3);
            add(4);
        }});

        System.out.println( car.getId());
        System.out.println( car.getSpeed());
        System.out.println( car.getName());
        System.out.println( car.getIds());



        return car;
    }
}