package cz.pa181.project.controllers;

import cz.pa181.project.EvaluateResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BaseController {

    @GetMapping({"/", "/home"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "/hello.html";
    }

    @PostMapping(value = "/evaluate")
    @ResponseBody
    public List<String> evaluate(@RequestBody EvaluateResponse vals) throws IOException, SQLException {
        return vals.resolve();
    }

}
