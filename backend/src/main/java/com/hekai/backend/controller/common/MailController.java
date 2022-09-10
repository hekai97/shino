package com.hekai.backend.controller.common;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author: hekai
 * @Date: 2022/6/11
 */
@Controller
@RequestMapping(value = "/mail")
public class MailController {
    @Autowired
    private SendMail emailUtil;
    @RequestMapping(value = "/getCode",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> mail(String email) {
        //生成随机数
        String captcha = String.valueOf(new Random().nextInt(899999) + 100000);
        //发生邮件
        emailUtil.sendMail(email, "您的验证码为" + captcha + "(5分钟内有效)");
        //响应信息
        return ServerResponse.createRespBySuccess(email,captcha);
    }
}
