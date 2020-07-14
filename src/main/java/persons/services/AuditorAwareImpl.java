//package persons.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.AuditorAware;
//import persons.models.Persons;
//
//import java.util.Optional;
//
//public class AuditorAwareImpl implements AuditorAware<Persons> {
//    @Autowired
//    private PersonsService personsService;
//
//    @Override
//    public Optional<Persons> getCurrentAuditor() {
//        return Optional.ofNullable((Persons) personsService.getAll());
//    }
//}
