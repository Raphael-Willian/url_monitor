package com.example.urlmonitor.record;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;


public record UrlMonitorRequest(

        @NotBlank (message = "A url não pode ser nula.")
        @NotNull (message = "A url não pode ser nula.")
        String url

){}
