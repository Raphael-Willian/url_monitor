package com.example.urlmonitor.exception;

public class UrlMonitorNotSendConectionException extends RuntimeException {

    public UrlMonitorNotSendConectionException(int statusCodeHttp, long timeOfResponse, boolean online, String messageSend) {
        super(
                "Status: " + statusCodeHttp +
                        ", ResponseTime: " + timeOfResponse +
                        "ms, Online: " + online +
                        ", Message: " + messageSend
        );
    }
}
