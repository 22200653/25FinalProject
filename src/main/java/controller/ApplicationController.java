package controller;

import com.cluplist.service.ApplicationService;
import com.cluplist.vo.ApplicationVO;
import com.cluplist.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/recruits/{recruitId}/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public String list(@PathVariable int recruitId, Model model, HttpSession session) {
        // 여기 권한은 나중에 "작성자만"으로 강화 가능
        model.addAttribute("list", applicationService.listByRecruitId(recruitId));
        model.addAttribute("recruitId", recruitId);
        model.addAttribute("user", session.getAttribute("user"));
        return "application/list";
    }

    @PostMapping
    public String apply(@PathVariable int recruitId,
                        @RequestParam String message,
                        HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("user");
        if (user == null) return "redirect:/auth/login";

        ApplicationVO vo = new ApplicationVO();
        vo.setRecruitId(recruitId);
        vo.setMessage(message);

        applicationService.apply(vo, user.getId());
        return "redirect:/recruits/" + recruitId;
    }
}
