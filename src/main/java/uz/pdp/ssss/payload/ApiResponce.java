package uz.pdp.ssss.payload;

import lombok.Data;

@Data
public class ApiResponce {
    private String message;

    private boolean success;

    private Object object;


    public ApiResponce(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public ApiResponce(String message, boolean success, Object object) {
        this.message = message;
        this.success = success;
        this.object = object;
    }

    public ApiResponce(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
