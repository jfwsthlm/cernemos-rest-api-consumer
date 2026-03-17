package se.sthlm.jfwsthlm.CernemosConsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se.sthlm.jfwsthlm.CernemosConsumer.data.PostForm;
import se.sthlm.jfwsthlm.CernemosConsumer.data.Rot13CipherResponse;
import se.sthlm.jfwsthlm.CernemosConsumer.service.ApiService;

@Controller
public class PostController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/encrypt")
    public String showForm(Model model) {
        return "rot13-form";
    }

    @PostMapping("/encrypt")
    public String submitForm(@RequestParam String message, Model model) throws InterruptedException {
        Rot13CipherResponse rot13CipherResponse = apiService.sendFormData(message);
        Thread.sleep(2000);
        model.addAttribute("result", rot13CipherResponse.getText());
        return "rot13-form";
    }
}