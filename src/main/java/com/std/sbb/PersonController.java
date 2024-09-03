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
public class PersonController {
    int lastId;
    List<Person> people;

    PersonController() {
        lastId = 0;
        people = new ArrayList<>();
    }

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("age") int age) {
        lastId++;
        Person p = new Person(lastId, age, name);

        people.add(p);

        return String.format("%d 번째 사람이 추가 되었습니다.", p.getId());
    }


    @GetMapping("/person/remove")
    @ResponseBody
    public String removePerson(@RequestParam("id") int id) {
        // 삭제 방법_ver.1
        Person removePerson = null;
        for (Person person : people) {
            if (person.getId() == id) {
                removePerson = person;
                break;
            }
        }
        if (removePerson == null) {
            return String.format("%d번 사람이 존재하지 않습니다.", id);
        } else {
            people.remove(removePerson);
        }

        return id + "번째 사람이 삭제되었습니다.";
        // return String.format ("%d번째 사람이 삭제되었습니다.",id);

/*      // 삭제 방법_ver.2 == ver.1 의 축약
        boolean removed = people.removeIf(person -> person.getId() == id);
        if (!removed) {
            return id + "번 사람이 존재하지 않습니다.";
        }
        return String.format("%d 번 사람이 삭제되었습니다.", id); */
    }


    @GetMapping("/person/modify")
    @ResponseBody
    public String modify(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("age") int age) {
        // 수정 방법_ver.1
        Person findPerson = null;

        for (Person person : people) {
            if (person.getId() == id) {
                findPerson = person;
            }
        }

        if (findPerson == null) {
            return String.format("%d번 사람이 존재하지 않습니다.", id);
        } else {
            findPerson.setName(name);
            findPerson.setAge(age);
        }

        return String.format("%d번 사람이 수정되었습니다.", id);


/*        // 수정 방법_ver.2
        Person findPerson = people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        if (findPerson == null) {
            return String.format("%d 번 사람이 존재하지 않습니다.", id);
        }

        return String.format("%d 번 사람이 수정되었습니다.", id);*/
    }


    @GetMapping("person/people")
    @ResponseBody
    public List<Person> getPeople() {
        System.out.println(people);
        return people;
    }
}


@AllArgsConstructor
@Getter
@Setter
@ToString
class Person {
    private int id;
    private int age;
    private String name;
}