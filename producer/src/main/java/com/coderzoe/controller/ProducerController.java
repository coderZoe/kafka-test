package com.coderzoe.controller;

import com.alibaba.fastjson.JSON;
import com.coderzoe.JsonUtil;
import com.coderzoe.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @author coderZoe
 * @date 2022/3/21 22:01
 */
@RestController
public class ProducerController {
    private KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/test")
    public void test(int times) throws JsonProcessingException {
        Random random = new Random();
        for(int i = 0; i< times; i++){
            Student student = new Student(UUID.randomUUID().toString(),
                    random.nextInt(80),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString());
            kafkaTemplate.send("student", JsonUtil.parseJson(student));
        }
    }

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
