package com.example.urlmonitor.controller;


import com.example.urlmonitor.record.UrlMonitorRequest;
import com.example.urlmonitor.record.UrlMonitorResponse;
import com.example.urlmonitor.service.UrlMonitorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/monitor")
public class UrlMonitorController {

    private final UrlMonitorService urlMonitorService;

    public UrlMonitorController(UrlMonitorService urlMonitorService) {
        this.urlMonitorService = urlMonitorService;
    }

    @PostMapping("/url")
    public ResponseEntity<UrlMonitorResponse> sendUrl(@RequestBody @Valid UrlMonitorRequest urlMonitorRequest)  {
        UrlMonitorResponse url = urlMonitorService.send(urlMonitorRequest);
        return ResponseEntity.status(HttpStatus.OK).body(url);
    }


}
