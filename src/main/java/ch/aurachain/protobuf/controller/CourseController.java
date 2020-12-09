package ch.aurachain.protobuf.controller;

import ch.aurachain.protobuf.proto.GeneratedProto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CourseController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/courses/{id}")
    void getCourse(@PathVariable Integer id) {
        Course course = restTemplate.getForObject("http://localhost:8080/courses/" + id, Course.class);
        System.out.println(course);
    }
}
