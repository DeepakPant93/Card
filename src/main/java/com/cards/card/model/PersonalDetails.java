package com.cards.card.model;

import static com.cards.card.constants.CardConstants.DeveloperMessage.*;
import com.cards.card.validator.annotation.NotBlank;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
public class PersonalDetails {

    @NotBlank
    @Size(min = 2, max=20, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String firstname;
    
    @Size(max=20, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String middlename;
    
    @Size(max=20, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String lastname;
    
    @Size(max=20, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    
    @Size(max = 30, message = SIZE_MISMATCHED)
    @Pattern(regexp = "[a-zA-Z]*", message = PATTREN_MISMATCHED)
    private String designation;
    
    @Valid
    @NotNull(message = FIELD_REQUIRED)
    private Address address;
    
    @Valid
    @NotNull(message = FIELD_REQUIRED)
    private ContactDetails contactDetails;
}
