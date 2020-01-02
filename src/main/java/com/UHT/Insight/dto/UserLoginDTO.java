package com.UHT.Insight.dto;

import com.UHT.Insight.pojo.Uuser;
import lombok.Data;

import java.util.Date;

@Data
public class UserLoginDTO {
    private String phone;
    private String password;
    private String uu_name;
    private Date birthday;
    private int age;
    private Integer uu_id;
}
