package com.cards.card.model;

import static com.cards.card.constants.CardConstants.DeveloperMessage.FIELD_REQUIRED;
import com.cards.card.validator.annotation.NotBlank;
import java.math.BigInteger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Card {
    
    private BigInteger id;

    @NotNull(message = FIELD_REQUIRED)
    @Valid
    private PersonalDetails personalDetails;
    
    @NotNull(message = FIELD_REQUIRED)
    @Valid
    private CompanyDetails companyDetails;
    
    private String status;
    
    @NotBlank
    private String type;

}
