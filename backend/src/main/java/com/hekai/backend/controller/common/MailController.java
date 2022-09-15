package com.hekai.backend.controller.common;

import com.hekai.backend.common.ServerResponse;
import com.hekai.backend.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * 邮件控制器
 *
 * @author 17316
 * @author: hekai
 * @date 2022/09/12
 */
@RestController
@RequestMapping(value = "/mail")
public class MailController {
    @Autowired
    private SendMail emailUtil;

    /**
     * 邮件
     *
     * @param email 电子邮件
     * @return {@link ServerResponse}<{@link String}>
     */
    @RequestMapping(value = "/getCode",method = RequestMethod.POST)
    public ServerResponse<String> mail(HttpSession httpSession,@RequestParam String email) {
        //生成随机数
        String captcha = String.valueOf(new Random().nextInt(899999) + 100000);
        //发生邮件
        emailUtil.sendMail(email, "您的验证码为" + captcha + "(5分钟内有效)");
        //响应信息
        httpSession.setAttribute("code",captcha);
        httpSession.setMaxInactiveInterval(5*60);
        return ServerResponse.createRespBySuccess(email,captcha);
    }
    @RequestMapping(value = "/verifyCode",method = RequestMethod.POST)
    public ServerResponse<String> verifyCode(HttpSession httpSession,@RequestParam String code) {
        if(httpSession.getAttribute("code").equals(code)){
            return ServerResponse.createRespBySuccess("验证成功");
        }else {
            return ServerResponse.createByErrorMessage("验证失败");
        }
    }
}
