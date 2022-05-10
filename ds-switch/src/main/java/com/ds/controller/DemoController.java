package com.ds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther gz
 * @date 2022-05-10  16:41
 * @description
 */
@Controller
public class DemoController {

//    @GetMapping("/common")
//    public void com(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        try {
//            request.getRequestDispatcher("/common.txt").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//    }


    @GetMapping("/common")
    public String com() {
        return "";
    }
}
