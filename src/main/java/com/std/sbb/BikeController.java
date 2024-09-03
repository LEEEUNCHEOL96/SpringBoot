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
    List<Bike> bike ;


    BikeController(){
        int lastId = 0;
        bike = new ArrayList<>();
    }

    @GetMapping("/bike/add")
    @ResponseBody
    public String addBike (@RequestParam("name") String name,
                           @RequestParam("CC") int CC){

        lastId ++;
        Bike b = new Bike(lastId, name, CC);

        bike.add(b);

        return b.getId() + "번 바이크가 추가되었습니다.";
    }

    @GetMapping("/bike/remove")
    @ResponseBody
    public String removeBike (@RequestParam("id") int id){


        Bike removeBike = null;
        for ( Bike bike : bike){
            if ( bike.getId() == id){
                removeBike = bike;
            }
        }

        if( removeBike == null){
            return id + "번 바이크는 존재하지 않습니다.";
        }else {
            bike.remove(removeBike);
        }

        return id + "번 바이크가 삭제되었습니다.";
    }

    @GetMapping("/bike/modify")
    @ResponseBody
    public String modifyModify (@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("CC") int CC){

        Bike findBike = null;

        for(Bike bike : bike){
            if (bike.getId()== id){
                findBike = bike;
            }
        }
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
        System.out.println(bike);
        return bike;
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