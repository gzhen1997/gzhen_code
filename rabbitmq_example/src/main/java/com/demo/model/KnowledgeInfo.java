package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther gz
 * @date 2022-04-19  16:25
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeInfo implements Serializable {

    private Integer id;

    private String mode;

    private String code;

}
