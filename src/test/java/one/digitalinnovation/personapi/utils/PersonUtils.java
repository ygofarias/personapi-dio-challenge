package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class PersonUtils {
    private static final String FIRST_NAME = "Ygo";
    private static final String LAST_NAME = "Farias";
    private static final String CPF_NUMBER = "000.435.587-60";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1989, 10, 21);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firsName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PersonUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firsName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PersonUtils.createFakeEntity()))
                .build();
    }
}
