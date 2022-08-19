package com.witsky.website.data.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author YSJ
 * @date 2022/07/19 11:05
 */
@RestController
public class Controller {

    @GetMapping("/t1")
    public String t1(){
        return "success++++++++++++++++++++++++++++++";
    }

}
