package controller;

import dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class WelcomeController {

    private final ProductService productService;

    @GetMapping("/")
    @ModelAttribute("product")
    public List<Product> showHtml() {
        return productService.findAll();
    }
}