package com.UHT.Insight.controller;

import com.UHT.Insight.daoImpl.UserDaoImpl;
import com.UHT.Insight.dto.ResultDTO;
import com.UHT.Insight.dto.UserLoginDTO;
import com.UHT.Insight.exception.CustomErrorCode;
import com.UHT.Insight.exception.CustomException;
import com.UHT.Insight.pojo.Uuser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private UserDaoImpl userDao = new UserDaoImpl();

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object loginPost(@RequestBody UserLoginDTO userLoginDTO) {
        Uuser uuser = userDao.findUserByPhone(userLoginDTO.getPhone());
        if (uuser==null){
            throw new CustomException(CustomErrorCode.USER_NOT_FOUND);
        }else if (!userLoginDTO.getPassword().equals(uuser.getPassword())){
            throw new CustomException(CustomErrorCode.PASSWORD_WRONG);
        }else {
            return ResultDTO.okOf();
        }
    }
}
