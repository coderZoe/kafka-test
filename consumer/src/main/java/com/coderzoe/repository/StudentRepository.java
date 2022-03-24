package com.coderzoe.repository;

import com.coderzoe.entity.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author coderZoe
 * @date 2022/3/23 19:56
 */
@Repository
public interface StudentRepository extends ElasticsearchRepository<Student,String> {
    /**
     * 通过JPA语句查询ES数据
     * 类似于name like name%
     * @param name 名称
     * @return 返回匹配到的数据
     */
    List<Student> findByNameLike(String name);

    /**
     * 类似于name like %name%
     * @param name 名称
     * @return 返回匹配到的数据
     */
    List<Student> findByNameContains(String name);

}
