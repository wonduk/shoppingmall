package org.shppoingmall.shopping.controller;

import java.time.LocalDateTime;

import org.shppoingmall.shopping.dto.ItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
    
    @GetMapping(value = "/ex2")
    public String thymeleafExample02(Model model){
        ItemDTO itemDto = new ItemDTO();

        itemDto.setItemDetail("상품 상세설명");
        itemDto.setItemNm("제품 이름");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());
        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";

    }

    @GetMapping(value = "/ex07")
    public String thymeleafExample07(){
        return "thymeleafEx/thymeleafEx07";
    }

}
