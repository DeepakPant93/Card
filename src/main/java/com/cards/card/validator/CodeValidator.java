
package com.cards.card.validator;

import com.cards.card.validator.annotation.Code;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author suraj.singh
 */
public class CodeValidator implements ConstraintValidator<Code, String>{
    String parttern="+[1-9][0-9]{0,2}";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
        
           return Objects.nonNull(value) && Pattern.compile(parttern).matcher(value).matches();
    }
    
}
