package withplanner.withplanner_api.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class LoginReq {
    private String email;
    private String password;
}
