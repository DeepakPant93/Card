
package com.cards.card.validator;

import com.cards.card.validator.annotation.NotEmptyFields;
import java.util.Collection;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.cards.card.validator.annotation.NotEmptyCollection;

/**
 *
 * @author suraj.singh
 */
public class NotEmptyObjectValidator implements ConstraintValidator<NotEmptyCollection, Collection<?>>{
    
    public void initialize(NotEmptyFields notEmptyFields) {
    }

    @Override
    public boolean isValid(Collection<?> collection, ConstraintValidatorContext context) {
        return collection!=null && !collection.isEmpty();
    }
    
}
