
package com.cards.card.validator;

import com.cards.card.validator.annotation.NotEmptyFields;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author suraj.singh
 */
public class NotEmptyFieldsValidator implements ConstraintValidator<NotEmptyFields, List<String>> {

    @Override
    public void initialize(NotEmptyFields notEmptyFields) {
    }

    @Override
    public boolean isValid(List<String> objects, ConstraintValidatorContext context) {
        return objects.stream().allMatch(nef -> nef != null && !nef.trim().isEmpty());
    }

    
}