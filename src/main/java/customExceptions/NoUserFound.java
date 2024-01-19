package customExceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class NoUserFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
}
