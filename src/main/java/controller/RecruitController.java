package controller;

import com.cluplist.service.RecruitService;
import com.cluplist.vo.RecruitVO;
import com.cluplist.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/recruits")
public class RecruitController {

    private final RecruitService recruitService;

    public RecruitController(RecruitService recruitService) {
        this.recruitService = recruitService;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String category, Model model) {
        model.addAttribute("list", recruitService.getAll(category));
        model.addAttribute("category", category);
        return "recruit/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("recruit", recruitService.getById(id));
        return "recruit/detail";
    }

    @GetMapping("/add")
    public String addPage(HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/auth/login";
        return "recruit/add";
    }

    @PostMapping("/add")
    public String add(RecruitVO vo, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) return "redirect:/auth/login";
        recruitService.add(vo, user.getId());
        return "redirect:/recruits";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable int id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/auth/login";
        model.addAttribute("recruit", recruitService.getById(id));
        return "recruit/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable int id, RecruitVO vo, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) return "redirect:/auth/login";
        vo.setId(id);
        recruitService.update(vo, user.getId());
        return "redirect:/recruits/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) return "redirect:/auth/login";
        recruitService.delete(id, user.getId());
        return "redirect:/recruits";
    }
}
