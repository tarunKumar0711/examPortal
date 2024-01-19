package customExceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class DuplicateUserName extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
}
