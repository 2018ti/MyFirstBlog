package com.xiaoyagao.firstblog.web;

import com.xiaoyagao.firstblog.Exception.ClassNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/{id}/{message}")
    public String index(@PathVariable("id") Integer id,@PathVariable("message") String message){
//        String blog=null;
//        if(blog==null){
//            throw  new ClassNotFoundException("博客未找到");
//        }
//        int i=9/0;
        return "index";
    }
}
