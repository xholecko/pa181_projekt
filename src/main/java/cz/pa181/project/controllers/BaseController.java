package cz.pa181.project.controllers;

import cz.pa181.project.EvaluateResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BaseController {

    @GetMapping({"/", "/home"})
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "/hello.html";
    }

    @PostMapping(value = "/evaluate")
    @ResponseBody
    public List<String> evaluate(@RequestBody EvaluateResponse vals) throws IOException, SQLException {
//        return new ArrayList<String>() {{
//            this.add("1");
//            this.add("2");
//        }};
        if(vals.must.length == 0 && vals.nice.length == 0 && vals.not.length == 0){
            return Collections.emptyList();
        }
        return vals.resolve();
    }

}
