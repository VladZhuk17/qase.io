package qase.io.UI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Group {
    private String groupTitle;
    private String groupDescription;
}
