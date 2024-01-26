package org.example.test.RestControllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Composant Management")
@RestController
@RequestMapping("/composant/")
@AllArgsConstructor
public class ComposantRestController {
}
