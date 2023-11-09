package Welfare.web.springmvc;

import Welfare.WelfareCheck.domain.Facilitie.BusanWelfareFacilitie;
import Welfare.WelfareCheck.domain.Facilitie.JDBCFacilitieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 *
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/springmvc/facilities")
public class SpringFacilitieController {
    JDBCFacilitieRepository jdbcFacilitieRepository = JDBCFacilitieRepository.getInstance();

    @GetMapping("/search-form")
    public String searchForm() {
        return "search-form";
    }

    @GetMapping("/search")
    public String searchResult(@RequestParam("searchword")String searchword, Model model) {
        List<BusanWelfareFacilitie> facilities = jdbcFacilitieRepository.facilityNameSearch(searchword);
        model.addAttribute("facilities", facilities);
        return "search-result";
    }
    @GetMapping
    public String facilities (Model model) {
        List<BusanWelfareFacilitie> facilities  = jdbcFacilitieRepository.findAll();
        model.addAttribute("facilities", facilities);
        return "facilities";
    }
}
