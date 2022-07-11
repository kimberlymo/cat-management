package ch.bbw.modul133.catmanagement.controller;

import ch.bbw.modul133.catmanagement.service.CatService;
import ch.bbw.modul133.catmanagement.model.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CatController {

    private final CatService repository;

    public CatController(final CatService repository) {
        this.repository = repository;
    }

    @GetMapping("/cats")
    public String showAllCats(Model model, @ModelAttribute Cat cat) {
        model.addAttribute("cats", repository.getAllCats());
        model.addAttribute("kitty", cat);
        return "show-all-cats";
    }

    @ModelAttribute("allCats")
    public List<Cat> populateCats() {
        return repository.getAllCats();
    }
}
