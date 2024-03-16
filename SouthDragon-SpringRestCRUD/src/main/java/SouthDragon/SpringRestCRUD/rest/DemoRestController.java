package SouthDragon.SpringRestCRUD.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    @GetMapping("/test")
    public String sayHelloWorld(){
        return "Hello World!";
    }
}
