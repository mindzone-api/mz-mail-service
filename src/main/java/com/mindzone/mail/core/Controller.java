package com.mindzone.mail.core;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class Controller {

    Service service;

    @PostMapping()
    public Status sendingEmail(@RequestBody @Valid DTO dto) {
        return service.sendEmail(dto);
    }

}
