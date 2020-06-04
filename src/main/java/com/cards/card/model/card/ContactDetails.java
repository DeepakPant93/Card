package com.cards.card.model.card;

import java.util.List;

import com.cards.card.validator.annotation.NotEmptyCollection;

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

    
    private String email;
    private boolean emailVerified;
    @NotEmptyCollection
    private List<MobileDetails> mobileDetails;

}
