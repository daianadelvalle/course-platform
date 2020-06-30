package ar.com.ada.courseplatform.model.dto.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class JwtRequestBody {

    @Size(message = "username must be between 3 and 20 characters", min = 3, max = 20)
    @NotBlank(message = "username is required")
    private String username;

    @Size(message = "password must be at least 4 characters long", min = 4)
    @NotBlank(message = "password is required")
    private String password;

    public JwtRequestBody setUsername(String username) {
        this.username = username;
        return this;
    }

    public JwtRequestBody setPassword(String password) {
        this.password = password;
        return this;
    }
}
