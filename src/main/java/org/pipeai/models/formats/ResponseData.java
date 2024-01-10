package org.pipeai.models.formats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseData {
    boolean status;
    String response;
}
