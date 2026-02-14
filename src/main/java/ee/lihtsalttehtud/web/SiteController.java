package ee.lihtsalttehtud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Lihtsalt Tehtud");
        return "index";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("title", "Services · Lihtsalt Tehtud");
        return "services";
    }

    @GetMapping("/cases")
    public String cases(Model model) {
        model.addAttribute("title", "Proof · Lihtsalt Tehtud");
        return "cases";
    }

    @GetMapping("/pricing")
    public String pricing(Model model) {
        model.addAttribute("title", "Packages · Lihtsalt Tehtud");
        return "pricing";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact · Lihtsalt Tehtud");
        return "contact";
    }

    @GetMapping("/eesti-tegijad")
    public String eestiTegijad(Model model) {
        model.addAttribute("title", "Eesti Tegijad · Lihtsalt Tehtud");
        return "eesti-tegijad";
    }

    // A local browser preview page for the checkmark rendering:
    @GetMapping("/logo-preview")
    public String logoPreview(Model model) {
        model.addAttribute("title", "Logo preview · Lihtsalt Tehtud");
        return "logo-preview";
    }
}
