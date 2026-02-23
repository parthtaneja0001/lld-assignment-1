import java.util.*;
public interface EligibilityRule {
    void apply(StudentProfile student,List<String> reasons,EligibilityStatus statusHolder);
}