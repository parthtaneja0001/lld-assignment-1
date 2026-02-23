import java.util.*;

public class OnboardingService {
    private final StudentRepository repository;
    private final StudentInputParser parser = new StudentInputParser();
    private final StudentValidator validator = new StudentValidator();
    private final StudentIdGenerator idGenerator;
    private final OnboardingPrinter printer;
    public OnboardingService(StudentRepository repository, StudentIdGenerator idGenerator,OnboardingPrinter printer) {
        this.repository = repository;
        this.idGenerator = idGenerator;
        this.printer = printer;
    }


    // SRP was being violated fixed that by creating different class for handling validation,parsing,creating id and saving and printing 
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);
        ParsedStudentInput input = parser.parse(raw);

        // validation done in seperate class
        List<String> errors = validator.validate(input);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = idGenerator.generate();
        StudentRecord rec = new StudentRecord(id, input.name, input.email, input.phone, input.program);

        repository.save(rec);

        printer.printSuccess(id, repository.count());
        printer.printConfirmation(rec);
    }
}
