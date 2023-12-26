package com.controller;

import com.tools.WechatMsgTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author:YiXia
 * @create: 2022-11-17 09:02:24
 * @Description: 控制层
 */


@RestController
public class MsgController {

    @Autowired
    private WechatMsgTool wechatMsg;//注入WechatMsg


    //方法中添加下面这行代码
    //公众号发送消息给用户
    @RequestMapping("/love")
    public String fun() throws ParseException, InterruptedException {

        参数，想发送的用户的id，关注公众号后台查询
        //参数，想发送的用户的id，关注公众号后台查询
        String[] userIDS=new String[]{"",""};
        for(String id:userIDS){
            wechatMsg.SendWeChatMsg(wechatMsg.getToken(),id);//用户id
        }
        //开始定时
        wechatMsg.timer();
        return "程序已执行";
    }



}
