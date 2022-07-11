package ch.bbw.modul133.catmanagement.controller;

import ch.bbw.modul133.catmanagement.model.CatManagement;
import ch.bbw.modul133.catmanagement.service.CatService;
import ch.bbw.modul133.catmanagement.model.Cat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CatController {

    private final CatService service;

    public CatController(final CatService service) {
        this.service = service;
    }

    @GetMapping("/cats")
    public String showAllCats(Model model, @ModelAttribute Cat cat) {
        model.addAttribute("cats", service.getAllCats());
        model.addAttribute("kitty", cat);
        return "show-all-cats";
    }

    @ModelAttribute("allCats")
    public List<Cat> populateCats() {
        return service.getAllCats();
    }

    @GetMapping("/updateCat/{id}")
    public String updateCatView(Model model, @PathVariable String id) {
        Cat cat = new Cat();
        cat.setOutdoor(false);
        cat.setName("jskd");
        cat.setBirthday("29384");
        cat.setColor("black");
        model.addAttribute("editCat", new Cat());
        return "update-view";
    }

    @PutMapping("/updateCat/{id}")
    public String updateCat(Model model, @Valid Cat catToEdit, BindingResult bindingResult, @PathVariable String id) {
        model.addAttribute("newValues", catToEdit);

        if (bindingResult.hasErrors()) {
            return "update-view";
        }

        return "show-all-cats";
    }

    @GetMapping("/addCat")
    public String addCatForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "create";
    }

    @PostMapping("/addCat")
    public String addCat(@Valid Cat catToAdd, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }

        this.service.createCat(catToAdd);

        return "show-all-cats";
    }
}
