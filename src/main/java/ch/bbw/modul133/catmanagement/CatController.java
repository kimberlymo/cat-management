package ch.bbw.modul133.catmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CatController {

    private CatRepository repository = new CatRepository();

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
