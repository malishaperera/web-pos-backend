package lk.ijse.web.web_pos_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {
    @GetMapping
    public String healthTest() {
        return "Web pos  run successfully";
    }
}
