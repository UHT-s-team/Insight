package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.UserDaoImpl;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.dto.UserLoginDTO;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.Uuser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    /*@ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object loginPost(@RequestBody UserLoginDTO userLoginDTO) {
        Uuser uuser = userDao.findUserByPhone(userLoginDTO.getPhone());
        return uuser;
    }*/
    private UserDaoImpl userDao = new UserDaoImpl();
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object loginPost(@RequestBody UserLoginDTO userLoginDTO) {
        Uuser uuser = userDao.findUserByPhone(userLoginDTO.getPhone());
        if (uuser==null){
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }else if (!userLoginDTO.getPassword().equals(uuser.getPASSWORD())){
            throw new CustomException(CustomErrorCode.PASSWORD_WRONG);
        }else {
            return ResultDTO.login();
        }
    }


    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public  Object Registration(@RequestBody UserLoginDTO userLoginDTO){
        String phone = userLoginDTO.getPhone();
        String password = userLoginDTO.getPassword();
        Uuser user = new Uuser();
        user.setUU_PHONE(phone);
        user.setPASSWORD(password);

        Uuser uuser = userDao.findUserByPhone(phone);
        if (uuser != null){
            return "该手机号已经注册过了";
        }else {
            userDao.saveUser(user);
            return ResultDTO.Registration();
        }
    }
}
