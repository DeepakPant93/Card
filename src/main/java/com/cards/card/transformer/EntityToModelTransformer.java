package com.cards.card.transformer;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cards.card.entity.AddressEntity;
import com.cards.card.entity.CardEntity;
import com.cards.card.entity.CompanyDetailsEntity;
import com.cards.card.entity.ContactDetailsEntity;
import com.cards.card.entity.MobileDetailsEntiy;
import com.cards.card.entity.PersonalDetailsEntity;
import com.cards.card.model.card.Address;
import com.cards.card.model.card.Card;
import com.cards.card.model.card.CompanyDetails;
import com.cards.card.model.card.ContactDetails;
import com.cards.card.model.card.MobileDetails;
import com.cards.card.model.card.PersonalDetails;

/**
 *
 * @author suraj.singh
 */

@Component
public class EntityToModelTransformer implements Function<CardEntity, Card> {

	@Override
	public Card apply(CardEntity cardEntity) {
	      return Card.builder().personalDetails(populatePersonalDetails(cardEntity.getPersonalDetails()))
	      .companyDetails(populateCompanyDetails(cardEntity.getCompanyDetails()))
	      .build();
	}

    private PersonalDetails populatePersonalDetails(PersonalDetailsEntity detailsEntity) {
        return PersonalDetails.builder().firstname(detailsEntity.getFirstname())
                .lastname(detailsEntity.getLastname())
                .middlename(detailsEntity.getMiddlename())
                .designation(detailsEntity.getDesignation())
                .address(populateAddress(detailsEntity.getAddress()))
                .contactDetails(populateContactDetails(detailsEntity.getContactDetails()))
                .build();

    }

    private Address populateAddress(AddressEntity addressEntity) {
        Address address = null;
        if (Objects.nonNull(addressEntity)) {
            Address.builder().addressLine1(addressEntity.getAddressLine1())
                    .addressLine2(addressEntity.getAddressLine2())
                    .country(addressEntity.getCountry())
                    .district(addressEntity.getDistrict())
                    .landmark(addressEntity.getLandmark())
                    .pin(addressEntity.getPin())
                    .state(addressEntity.getState())
                    .build();
        }
        return address;
    }

    private ContactDetails populateContactDetails(ContactDetailsEntity contactDetailsEntity) {
        ContactDetails contactDetails = null;
        if (Objects.nonNull(contactDetailsEntity)) {
            contactDetails = ContactDetails.builder().email(contactDetailsEntity.getEmail())
                    .emailVerified(contactDetailsEntity.isEmailVerified())
                    .mobileDetails(populateMobileDetailList(contactDetailsEntity.getMobileDetails()))
                    .build();
        }
        return contactDetails;
    }

    private List<MobileDetails> populateMobileDetailList(List<MobileDetailsEntiy> mobileDetailses) {
        return mobileDetailses.stream().map(mobile -> populateMobileDetail(mobile)).collect(Collectors.toList());
    }

    private MobileDetails populateMobileDetail(MobileDetailsEntiy mobile) {
        return MobileDetails.builder().number(mobile.getNumber())
                .code(mobile.getCode())
                .verified(mobile.isVerified())
                .enableWhatsAppNumber(mobile.isWhatsApp())
                .build();
    }

    private CompanyDetails populateCompanyDetails(CompanyDetailsEntity companyDetails) {
        return CompanyDetails.builder().name(companyDetails.getName())
                .tagLine(companyDetails.getTagLine())
                .logo(companyDetails.getLogo())
                .website(companyDetails.getWebsite())
                .logoImageUrl(companyDetails.getLogoImageUrl())
                .address(populateAddress(companyDetails.getAddress()))
                .contactDetails(populateContactDetails(companyDetails.getContactDetails()))
                .build();

    }
}
