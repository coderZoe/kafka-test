package com.coderzoe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * es实体类 类似于关系型数据库中的一张表，es中叫type(已被删除)，而document就是表上的一条记录
 * SpringBoot对管理es的document提供了一套注解，各个直接及其参数如下：
 * @Document 应用于Java类上，标识其为es的一张表
 *  indexName: 当前表所属的index名，index是es中的一个抽象概念，类似于关系型数据库中的数据库名 当前字段支持spring el表达式
 *  shards: 分片 当前索引的分片数量 分片是es中的一个抽象概念，es天生支持分布式，一个索引的数据可以分布在多个服务器上 分片即当前索引分成多个es服务器存储（也可以是一个）的分片数量 默认1个
 *  replicas：备份/复制 es提供高可用，为每个分片都提供了复制分片的功能，当前字段代表当前索引下分片的复制数量 默认1个
 *  refreshInterval：刷新频率 es为保证高效性，往往写入的数据是放到缓冲区而未落到磁盘的，对于这种数据是查询不到的，也即插入和查询有一定的间隔 refreshInterval就是指定当前间隔时间 默认1s
 *  indexStoreType：索引的保存方式
 *  createIndex：是否创建索引 默认true
 *  versionType：配置版本管理方式
 * @Id 标记于属性上，表示主键
 * @Transient 标记于属性上 有时document中并非所有字段都需要保存到es库中，通过@Transient注解可以保证该字段不存储到es中
 * @PersistenceConstructor 标记与构造函数，用于从数据库中一条记录实例化为一个Java类时会使用当前构造函数来实例化
 * @Field 应用于属性字段 一个field即是当前Java属性与数据库中一个字段的映射关系
 *  name: 保存在es中的字段名称，如果未设置则用java字段名
 *  type: 当前属性类型，即es库中以什么数据类型保存当前字段 更多详情见 https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-types.html
 *  format和pattern ：用于在type是Date时，定义日期的格式
 *  store：标识当前原始字段是否存于es中
 *
 *
 *
 * @author coderZoe
 * @date 2022/3/23 19:26
 */
@Document(indexName = "student")
public class Student {
    @Id
    private String name;
    private int age;
    private String email;
    private String address;

    public Student() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
