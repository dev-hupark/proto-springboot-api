package demo.proto.springbootapi;

import demo.proto.springbootapi.model.ProtoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public ProtoVO helloDto(@RequestParam("id") String id, @RequestParam("todo") String todo) {
        return new ProtoVO(id, todo);
    }
}
