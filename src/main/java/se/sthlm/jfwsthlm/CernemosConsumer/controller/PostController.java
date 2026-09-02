package se.sthlm.jfwsthlm.CernemosConsumer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se.sthlm.jfwsthlm.CernemosConsumer.data.PostForm;
import se.sthlm.jfwsthlm.CernemosConsumer.data.Rot13CipherResponse;
import se.sthlm.jfwsthlm.CernemosConsumer.data.SubstitutionCipherForm;
import se.sthlm.jfwsthlm.CernemosConsumer.data.SubstitutionCipherResponse;
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

    @GetMapping("/substitution")
    public String showSubstitutionForm(Model model) {

        SubstitutionCipherForm substitutionCipherForm = new SubstitutionCipherForm();

        // Pre-create keys A-Z so Thymeleaf doesn't struggle creating keys on the fly
        for (char c = 'A'; c <= 'Z'; c++) {
            substitutionCipherForm.getSubstitutionMap().put(String.valueOf(c), null);
        }

        model.addAttribute("substitutionCipherForm", substitutionCipherForm);
        return "substitution-form";
    }

    @PostMapping("/substitution")
    public String submitFormForSubstitution(@ModelAttribute("substitutionCipherForm") SubstitutionCipherForm substitutionCipherForm, Model model) throws InterruptedException {

        Map<Character, Character> substitutionMap = new HashMap<>();
        for (Map.Entry<String, Character> entry : substitutionCipherForm.getSubstitutionMap().entrySet()) {
            if (entry.getValue() != null) {
                substitutionMap.put(entry.getKey().charAt(0), entry.getValue());
            }
        }

        SubstitutionCipherResponse substitutionCipherResponse =
            apiService.sendSubstitutionFormData(
                substitutionCipherForm.getOriginalText(),
                substitutionMap
            );

        Thread.sleep(2000);
        model.addAttribute("substitutedText", substitutionCipherResponse.getSubstitutedText());
        model.addAttribute("originalText", substitutionCipherForm.getOriginalText());
        /*model.addAttribute("substitutionMap", substitutionCipherForm.getSubstitutionMap());*/
        //substitutionCipherForm.setSubstitutedText(substitutionCipherResponse.getSubstitutedText());
        //model.addAttribute("substitutionCipherForm", substitutionCipherForm);
        return "substitution-form";
    }
    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // This looks for about.html in your templates folder
    }
}