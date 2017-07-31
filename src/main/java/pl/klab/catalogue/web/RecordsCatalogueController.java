package pl.klab.catalogue.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordsCatalogueController {

    @RequestMapping("/home")
    String home() {
        return "HelloWorld";
    }
}
