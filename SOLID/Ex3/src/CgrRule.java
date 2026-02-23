import java.util.List;
public class CgrRule implements EligibilityRule {

    @Override
    public void apply(StudentProfile s,List<String> reasons,EligibilityStatus status) {
        if (s.cgr < 8.0) {
            status.markNotEligible();
            reasons.add("CGR below 8.0");
        }
    }
}