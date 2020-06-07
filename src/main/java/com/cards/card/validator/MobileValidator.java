
package com.cards.card.validator;

import com.cards.card.validator.annotation.Mobile;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author suraj.singh
 */
public class MobileValidator implements ConstraintValidator<Mobile, String>{
    
    String parttern="[1-9][0-9]{9}";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cvc) {
        
        
        return Objects.nonNull(value) && Pattern.compile(parttern).matcher(value).matches();
    }
    
    
    
}
