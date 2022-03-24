package com.coderzoe.handler;

import com.coderzoe.JsonUtil;
import com.coderzoe.entity.Student;
import com.coderzoe.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author coderZoe
 * @date 2022/3/21 21:35
 */
@Service
public class ConsumerHandler {
    private StudentService studentService;
    @KafkaListener(topics = "student",batch = "true")
    public void consumer(List<String> consumerList){
        List<Student> studentList = consumerList.stream().map(s -> {
            try {
                return JsonUtil.parseObject(s, Student.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        studentService.save(studentList);
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
