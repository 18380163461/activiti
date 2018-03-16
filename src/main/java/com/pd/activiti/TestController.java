package com.pd.activiti;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @author: youpd@asiainfo.com
 * @create: 2018-03-16 15:20
 */
@Controller
@RequestMapping("TestController")
public class TestController {

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        return "AAAAAAA";
    }
}
