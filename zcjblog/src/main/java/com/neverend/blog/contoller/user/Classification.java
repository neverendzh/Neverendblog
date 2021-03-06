package com.neverend.blog.contoller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 分类文章显示
 * @author zcg
 */
@Controller
@RequestMapping("/Article")
@ApiIgnore
public class Classification {


    @GetMapping("/category/view")
    public String fenLeiArticle(@RequestParam(name = "type",defaultValue = "",required = false)String type){
        System.out.println(type);
        return "user/details";
    }

    @GetMapping("/category/about")
    public String about(@RequestParam(name = "type",defaultValue = "",required = false)String type){

        return "user/about";
    }

}
