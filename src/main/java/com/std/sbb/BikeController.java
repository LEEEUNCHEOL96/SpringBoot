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
public class BikeController {
    int lastId ;
    List<Bike> bikes ;


    BikeController(){
        lastId = 0;
        bikes = new ArrayList<>();
    }

    @GetMapping("/bike/add")
    @ResponseBody
    public String addBike (@RequestParam("name") String name,
                           @RequestParam("CC") int CC){

        lastId ++;
        Bike b = new Bike(lastId, name, CC);

        bikes.add(b);

        return b.getId() + "번 바이크가 추가되었습니다.";
    }

    @GetMapping("/bike/remove")
    @ResponseBody
    public String removeBike (@RequestParam("id") int id){
        Bike removeBike = findBikeByID(id);

        if( removeBike == null){
            return id + "번 바이크는 존재하지 않습니다.";
        }else {
            bikes.remove(removeBike);
        }

        return id + "번 바이크가 삭제되었습니다.";
    }

    @GetMapping("/bike/modify")
    @ResponseBody
    public String modifyBike (@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("CC") int CC){

        Bike findBike = findBikeByID(id);

        if (findBike == null ){
            return id + "번 바이크는 존재하지 않습니다.";
        }else {
            findBike.setName(name);
            findBike.setCC(CC);
        }
        return id + "번 바이크가 수정되었습니다.";
    }

    @GetMapping("/bike/list")
    @ResponseBody
    public List<Bike> getBike(){
        System.out.println(bikes);
        return bikes;
    }

    private Bike findBikeByID (int id){
        for ( Bike b : bikes){
            if (b.getId()== id){
                return b;
            }
        } return null;
    }
}


@AllArgsConstructor
@Getter
@Setter
@ToString
class Bike {
    private int id;
    private String name ;
    private int CC;
}