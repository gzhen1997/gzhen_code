package com.demo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @auther gz
 * @date 2022-04-20  15:37
 * @description
 */
@Data
public class UserLoginDto implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Integer userId;
}
