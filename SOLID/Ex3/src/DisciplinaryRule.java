import java.util.List;
public class DisciplinaryRule implements EligibilityRule {

    @Override
    public void apply(StudentProfile s,List<String> reasons,EligibilityStatus status) {

        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            status.markNotEligible();
            reasons.add("disciplinary flag present");
        }
    }
}