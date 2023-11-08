package Welfare.web;

import Welfare.WelfareCheck.domain.Facilitie.BusanWelfareFacilitie;
import Welfare.WelfareCheck.domain.Facilitie.JDBCFacilitieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * v3
 * Model 도입
 * ViewName 직접 반환
 *
 * @RequestParam 사용
 * @RequestMapping -> @GetMapping, @PostMapping
 */
@Controller
@RequestMapping("/welfare/facilitie")
public class SpringFacilitieController {
    JDBCFacilitieRepository jdbcFacilitieRepository = JDBCFacilitieRepository.getInstance();

    @GetMapping("/new-form")
    public String searchForm() {
        return "new-form";
    }

    @GetMapping("/search")
    public String searchResult(@RequestParam("searchword")String searchword, Model model) {
        List<BusanWelfareFacilitie> facilitieList = jdbcFacilitieRepository.facilityNameSearch(searchword);
        model.addAttribute("facilitieList", facilitieList);
        return "search-result";
    }
    @GetMapping("/facilities")
    public String facilities (Model model) {
        List<BusanWelfareFacilitie> facilitieList = jdbcFacilitieRepository.findAll();
        model.addAttribute("facilitieList", facilitieList);
        return "members";
    }
}
