package uz.pdp.ssss.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class RegisterDto {

    @NotNull(message = "fullName not found")
    private String fullName;
    @NotNull(message = "userName not found")
    private String userName;
    @NotNull(message = "password not found")
    private String password;
    @NotNull(message = "prePassword not found")
    private String prePassword;

}
