package com.cards.card.model;

import static com.cards.card.constants.CardConstants.DeveloperMessage.PATTREN_MISMATCHED;
import static com.cards.card.constants.CardConstants.DeveloperMessage.SIZE_MISMATCHED;
import com.cards.card.validator.annotation.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Address {

    @NotBlank
    @Size(min = 2, max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String state;

    @NotBlank
    @Size(min = 2, max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String district;

    @NotBlank
    @Size(min = 2, max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String country;

//    @NotNullOrZero
    // TODO Create a @PIN validation
    private String pin;

    @Size(max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String landmark;

    @NotBlank
    @Size(min = 2, max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z&./-_]*", message = PATTREN_MISMATCHED)
    private String addressLine1;

    @Size(max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z&./-_]*", message = PATTREN_MISMATCHED)
    private String addressLine2;

}
