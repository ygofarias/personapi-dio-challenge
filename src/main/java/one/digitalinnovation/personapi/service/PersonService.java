package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.mapper.PersonMapper;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/*
 * vai indicar para o spring que para ele
 *  gerenciar uma classe, que vai ser responsável
 * por colocar todas as regras de negócios
 * da aplicação
 *
 */


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    public MessageResponseDTO create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(person);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());
        return messageResponse;
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(id);

                return personMapper.toDTO(person);
    }

    public List<PersonDTO> listAll(){
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper :: toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException{
        personRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse  = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }

    public void delete(Long id) throws  PersonNotFoundException{
        personRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(id);

                personRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2){
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build()
    }
}
