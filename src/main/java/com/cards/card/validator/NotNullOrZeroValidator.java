
package com.cards.card.validator;

import com.cards.card.validator.annotation.NotNullOrZero;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author suraj.singh
 */
public class NotNullOrZeroValidator  implements ConstraintValidator<NotNullOrZero, Integer>{

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext cvc) {
     return value!=null && value > 0;
    }
    
   
    
    
    
    
}
