package com.cards.card.transformer.model;

import com.cards.card.context.CardContext;
import com.cards.card.entity.AddressEntity;
import com.cards.card.entity.CardEntity;
import com.cards.card.entity.CompanyDetailsEntity;
import com.cards.card.entity.ContactDetailsEntity;
import com.cards.card.entity.MobileDetailsEntiy;
import com.cards.card.entity.PersonalDetailsEntity;
import com.cards.card.model.Address;
import com.cards.card.model.Card;
import com.cards.card.model.CompanyDetails;
import com.cards.card.model.ContactDetails;
import com.cards.card.model.MobileDetails;
import com.cards.card.model.PersonalDetails;
import com.cards.card.repository.sequence.CardSequenceRepository;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author suraj.singh
 */

@AllArgsConstructor
@Component
public class ModelToEntityTransformer implements Function<Card, CardEntity> {

    private final CardSequenceRepository sequence;
    
   
    @Override
    public CardEntity apply(Card card) {
        return CardEntity.builder()
                .id(sequence.getNextSequence())
                .personalDetails(populatePersonalDetails(card.getPersonalDetails()))
                .companyDetails(populateCompanyDetails(card.getCompanyDetails()))
                .userId(CardContext.getUserId())
                .build();

    }

    private PersonalDetailsEntity populatePersonalDetails(PersonalDetails personalDetails) {
        return PersonalDetailsEntity.builder().lastname(personalDetails.getLastname())
                .firstname(personalDetails.getFirstname())
                .middlename(personalDetails.getMiddlename())
                .designation(personalDetails.getDesignation())
                .address(populateAddress(personalDetails.getAddress()))
                .build();

    }

    private AddressEntity populateAddress(Address address) {
        return AddressEntity.builder().addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .country(address.getCountry())
                .district(address.getDistrict())
                .landmark(address.getLandmark())
                .pin(address.getPin())
                .state(address.getState())
                .build();

    }

    private CompanyDetailsEntity populateCompanyDetails(CompanyDetails companyDetails) {
        return CompanyDetailsEntity.builder().name(companyDetails.getName())
                .tagLine(companyDetails.getTagLine())
                .logo(companyDetails.getLogo())
                .website(companyDetails.getWebsite())
                .logoImageUrl(companyDetails.getLogoImageUrl())
                .address(populateAddress(companyDetails.getAddress()))
                .contactDetails(populateContactDetails(companyDetails.getContactDetails()))
                .build();

    }

    private ContactDetailsEntity populateContactDetails(ContactDetails contactDetails) {

        return ContactDetailsEntity.builder().email(contactDetails.getEmail())
                .mobileDetails(populateMobileDetailList(contactDetails.getMobileDetails())).
                build();

    }

    private List<MobileDetailsEntiy> populateMobileDetailList(List<MobileDetails> mobileDetailses) {
        return mobileDetailses.stream().map(mobile -> {
            return getMobileDetail(mobile );
        }).collect(Collectors.toList());

    }

    private MobileDetailsEntiy getMobileDetail(MobileDetails mobile) {
        return MobileDetailsEntiy.builder().number(mobile.getNumber())
                .code(mobile.getCode())
                .verified(mobile.isVerified())
                .whatsApp(mobile.isEnableWhatsAppNumber()).
                 build();
    }

}