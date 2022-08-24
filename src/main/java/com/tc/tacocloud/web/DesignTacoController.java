package com.tc.tacocloud.web;

import com.tc.tacocloud.model.Ingredient;
import com.tc.tacocloud.model.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.tc.tacocloud.model.Ingredient.Type.*;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "pszenna", WRAP),
                new Ingredient("COTO", "kukurydziana", WRAP),
                new Ingredient("GRBF", "mielona wołowina", PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojone w kostkę", VEGGIES),
                new Ingredient("LETC", "sałata", VEGGIES),
                new Ingredient("CHED", "cheddar", CHEESE),
                new Ingredient("JACK", "Monterey Jack", CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", SAUCE),
                new Ingredient("SRCR", "śmietana", SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
        log.info("Processing taco project: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
