package qase.io.UI.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
private String suiteName;
private String suiteDescription;
private String suitePreconditions;
}
