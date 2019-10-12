package com.xiaoyagao.firstblog.web;

import com.xiaoyagao.firstblog.Exception.ClassNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        String blog=null;
        if(blog==null){
            throw  new ClassNotFoundException("博客未找到");
        }
        return "index";
    }
}
