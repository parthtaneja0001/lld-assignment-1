import java.util.List;
public class AttendanceRule implements EligibilityRule {

    @Override
    public void apply(StudentProfile s,List<String> reasons,EligibilityStatus status) {
        if (s.attendancePct < 75) {
            status.markNotEligible();
            reasons.add("attendance below 75");
        }
    }
}