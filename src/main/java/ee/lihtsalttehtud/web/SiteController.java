package ee.lihtsalttehtud.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    private static final String PROD_BASE = "https://lihtsalttehtud.ee";

    @GetMapping("/")
    public String index(Model model, HttpServletRequest req) {
        meta(model, req,
                "Kui asi on segane, teeme selle selgeks — Lihtsalt Tehtud",
                "Selge kord MTÜdele, KOVidele ja väikeettevõtetele. Vähem segadust, rohkem selgust.",
                "/");
        return "index";
    }

    @GetMapping("/mtu")
    public String mtu(Model model, HttpServletRequest req) {
        meta(model, req,
                "MTÜ: kui töö on laiali, teeme selle selgeks — Lihtsalt Tehtud",
                "Vabatahtlikud, projektid ja aruanded. Teeme asja selgeks, et keegi ei peaks kõike peas hoidma.",
                "/mtu");
        return "mtu";
    }

    @GetMapping("/kov")
    public String kov(Model model, HttpServletRequest req) {
        meta(model, req,
                "KOV: kui partnerite info on laiali, teeme selle selgeks — Lihtsalt Tehtud",
                "Partnerid, teenused ja ülevaade. Selge kord, et info oleks leitav ja pilt olemas.",
                "/kov");
        return "kov";
    }

    @GetMapping("/ettevote")
    public String ettevote(Model model, HttpServletRequest req) {
        meta(model, req,
                "Ettevõte: kui tööpäev on segane, teeme selle selgeks — Lihtsalt Tehtud",
                "Kliendid, tellimused ja tööjärg. Teeme asja selgeks, et töö ei jookseks laiali.",
                "/ettevote");
        return "ettevote";
    }

    @GetMapping("/contact")
    public String contact(Model model, HttpServletRequest req) {
        meta(model, req,
                "Kontakt — Lihtsalt Tehtud",
                "Kirjuta lühidalt: mis on segane, kes seda vajab ja mis oleks selge. Kolm asja. Piisab.",
                "/contact");
        return "contact";
    }

    // Optional: keep these routes alive (templates exist), but they are not in nav/sitemap right now.
    @GetMapping("/services")
    public String services(Model model, HttpServletRequest req) {
        meta(model, req, "Teenused — Lihtsalt Tehtud", "Hetkel navist väljas.", "/services");
        return "services";
    }

    @GetMapping("/pricing")
    public String pricing(Model model, HttpServletRequest req) {
        meta(model, req, "Paketid — Lihtsalt Tehtud", "Hetkel navist väljas.", "/pricing");
        return "pricing";
    }

    @GetMapping("/cases")
    public String cases(Model model, HttpServletRequest req) {
        meta(model, req, "Tõendid — Lihtsalt Tehtud", "Hetkel navist väljas.", "/cases");
        return "cases";
    }

    @GetMapping("/tugi-tegijale")
    public String tugiTegijale(Model model, HttpServletRequest req) {
        meta(model, req, "Tugi tegijale — Lihtsalt Tehtud", "Hetkel navist väljas.", "/tugi-tegijale");
        return "tugi-tegijale";
    }

    @GetMapping("/logo-preview")
    public String logoPreview(Model model, HttpServletRequest req) {
        meta(model, req, "Logo preview (dev) — Lihtsalt Tehtud", "Hetkel navist väljas.", "/logo-preview");
        return "logo-preview";
    }

    private void meta(Model model, HttpServletRequest req, String title, String description, String canonicalPath) {
        String base = resolveBase(req);
        String canonicalUrl = base + canonicalPath;

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("canonicalUrl", canonicalUrl);

        model.addAttribute("ogTitle", title);
        model.addAttribute("ogDescription", description);
    }

    private String resolveBase(HttpServletRequest req) {
        String host = req.getHeader("Host");
        if (host != null && (host.contains("localhost") || host.contains("127.0.0.1"))) {
            return req.getScheme() + "://" + host;
        }
        return PROD_BASE;
    }
}
