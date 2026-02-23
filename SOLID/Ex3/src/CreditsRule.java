import java.util.*;
public class CreditsRule implements EligibilityRule {

    @Override
    public void apply(StudentProfile s,List<String> reasons,EligibilityStatus status) {
        if (s.earnedCredits < 20) {
            status.markNotEligible();
            reasons.add("credits below 20");
        }
    }
}