package cz.pa181.project;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EvaluateResponse {
    public String[] all;
    public String[] must;
    public String[] nice;
    public String[] not;
}
