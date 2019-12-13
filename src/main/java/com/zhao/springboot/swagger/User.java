package com.zhao.springboot.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: spring-boot
 * @description
 * @author: zhaohuan
 * @create: 2019-12-10 22:51
 **/
@ApiModel(value = "用户信息")
@Data
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;


}
