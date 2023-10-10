package demo.proto.springbootapi;

import demo.proto.springbootapi.config.auth.LoginUser;
import demo.proto.springbootapi.config.auth.dto.SessionUser;
import demo.proto.springbootapi.model.TodoResDto;
import demo.proto.springbootapi.service.TodoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final TodoService todoService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("todos", todoService.findAllDesc());

        if (user != null){
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/todos/save")
    public String todosSave() {
        return "todos-save";
    }

    @GetMapping("/todos/update/{id}")
    public String todoUpdate(@PathVariable Long id, Model model) {
        TodoResDto dto = todoService.findById(id);
        model.addAttribute("todos", dto);

        return "todos-update";
    }
}

