package com.cards.card.model.card;

import com.cards.card.validator.annotation.Code;
import com.cards.card.validator.annotation.Mobile;
import com.cards.card.validator.annotation.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileDetails {

    @NotBlank
    @Code
    private String code;
    @NotBlank
    @Mobile
    private String number;
    private boolean enableWhatsAppNumber;
    private boolean verified;
}
