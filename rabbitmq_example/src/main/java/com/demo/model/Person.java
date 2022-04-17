package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-17  21:51
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private Integer id;

    private String name;

    private Integer age;


}
