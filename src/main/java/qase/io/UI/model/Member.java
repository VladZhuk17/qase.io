package qase.io.UI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private String email;
    private String name;
    private String roleTitle;
}
