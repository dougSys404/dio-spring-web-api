package spring_web_api.handler;

import java.util.Date;

public class ResponseError {
    private Date timastamp = new Date();
    private String status = "Error";
    private int statusCode = 400;
    private String error;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTimastamp() {
        return timastamp;
    }

    public void setTimastamp(Date timastamp) {
        this.timastamp = timastamp;
    }
}
