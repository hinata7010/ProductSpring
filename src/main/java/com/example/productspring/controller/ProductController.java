package com.example.productspring.controller;

import com.example.productspring.dto.ProductDTO;
import com.example.productspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public void list(Model model, String name){
        if(name == null){
            model.addAttribute("dtoList", productService.getList(""));
        }
        else {
            model.addAttribute("dtoList", productService.getList(name));
        }
    }
    @PostMapping("/register")
    public String registerPost(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("register");
        if(productService.findName(productDTO.getName())){
            log.info("상품 중복 이름 오류");
            return "redirect:/product/register";
        }
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute(bindingResult.getAllErrors());
            return "redirect:/product/register";
        }
        productService.register(productDTO);
        return "redirect:/product/list";
    }

    @GetMapping("/register")
    public void registerGet(){

    }

    @GetMapping({"/read", "/modify"})
    public void read(long id, Model model){
        ProductDTO productDTO = productService.getOne(id);
        model.addAttribute("dto",productDTO);
    }

    @PostMapping("/remove")
    public String remove(long id) {
        log.info(id);
        productService.remove(id);
        return "redirect:/product/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info(productDTO);
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            log.info("ERROR");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("id", productDTO.getId());
            return "redirect:/product/modify";
        }
        productService.modify(productDTO);
        return "redirect:/product/list";
    }
}
