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
	      return Card.builder().id(cardEntity.getId())
              .personalDetails(populatePersonalDetails(cardEntity.getPersonalDetails()))
              .companyDetails(populateCompanyDetails(cardEntity.getCompanyDetails()))
              .status(cardEntity.getStatus().name())
              .type(cardEntity.getType().name())
              .build();
	}

    private PersonalDetails populatePersonalDetails(PersonalDetailsEntity detailsEntity) {
        return PersonalDetails.builder()
        		.firstname(detailsEntity.getFirstname())
                .lastname(detailsEntity.getLastname())
                .middlename(detailsEntity.getMiddlename())
                .designation(detailsEntity.getDesignation())
                .contactDetails(populateContactDetails(detailsEntity.getContactDetails()))
                .build();

    }

    private Address populateAddress(AddressEntity addressEntity) {
        Address address = null;
        if (Objects.nonNull(addressEntity)) {
            Address.builder().addressLine1(addressEntity.getAddressLine1())
                    .country(addressEntity.getCountry())
                    .district(addressEntity.getDistrict())
                    .landmark(addressEntity.getLandmark())
                    .pin(addressEntity.getPin())
                    .city(addressEntity.getCity())
                    .state(addressEntity.getState())
                    .build();
        }
        return address;
    }

    private ContactDetails populateContactDetails(ContactDetailsEntity contactDetailsEntity) {
        ContactDetails contactDetails = null;
        if (Objects.nonNull(contactDetailsEntity)) {
            contactDetails = ContactDetails.builder().email(contactDetailsEntity.getEmail())
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
                .whatsAppNumber(mobile.isWhatsAppNumber())
                .build();
    }

    private CompanyDetails populateCompanyDetails(CompanyDetailsEntity companyDetails) {
        return CompanyDetails.builder().name(companyDetails.getName())
                .tagLine(companyDetails.getTagLine())
                .website(companyDetails.getWebsite())
                .logoUrl(companyDetails.getLogoUrl())
                .address(populateAddress(companyDetails.getAddress()))
                .build();
    }
}
