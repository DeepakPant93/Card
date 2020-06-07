package com.cards.card.model.card;

import com.cards.card.validator.annotation.NotBlank;
import java.util.List;

import com.cards.card.validator.annotation.NotEmptyCollection;
import javax.validation.constraints.Email;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ContactDetails {

    @NotBlank
    @Email
    private String email;
    private boolean emailVerified;
    @NotEmptyCollection
    private List<MobileDetails> mobileDetails;

}
