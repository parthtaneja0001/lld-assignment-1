public class StudentIdGenerator {

    private final StudentRepository repository;

    public StudentIdGenerator(StudentRepository repository) {
        this.repository = repository;
    }

    public String generate() {
        return IdUtil.nextStudentId(repository.count());
    }
}