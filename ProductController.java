package controller;

import dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String home(Model model, @PathVariable(value = "id") Long id) {
        Product product = productService.get(id);
        model.addAttribute("product", product);
        return "product";
    }
}