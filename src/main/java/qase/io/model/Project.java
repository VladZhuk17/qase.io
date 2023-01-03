package qase.io.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String projectName;
    private String projectCode;
    private String description;
}
