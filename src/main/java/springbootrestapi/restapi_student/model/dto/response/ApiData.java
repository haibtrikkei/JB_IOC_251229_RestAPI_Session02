package springbootrestapi.restapi_student.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiData<T>{
    private boolean success;
    private String message;
    private T data;
    private HttpStatusCode statusCode;
}
