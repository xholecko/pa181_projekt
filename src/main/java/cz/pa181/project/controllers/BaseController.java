package cz.pa181.project.controllers;

import cz.pa181.project.EvaluateResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BaseController {

    @GetMapping({"/", "/home"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "/hello.html";
    }

    @PostMapping(value = "/evaluate")
    @ResponseBody
    public EvaluateResponse evaluate(@RequestBody EvaluateResponse vals){
        return vals;
    }

}
