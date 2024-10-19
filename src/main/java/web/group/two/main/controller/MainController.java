package web.group.two.main.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.group.two.user.entity.LoginUser;
import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class MainController {



    @PostMapping("/main")
    public ModelAndView index(@AuthenticationPrincipal LoginUser loginUser, ModelAndView mv){
        log.info("Kill: {}", loginUser.getUser().getNickname());
        mv.addObject("data", String.format("%s", loginUser.getUser().getNickname()));
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/main/logout")
    public String logout(){
        return "logout";
    }
}