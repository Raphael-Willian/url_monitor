package com.example.urlmonitor.record;

import java.net.http.HttpRequest;

public record UrlMonitorResponse(

        int statusCodeHttp, //temporariamente
        long timeOfResponse,
        boolean online,
        String messageSend
) {}
