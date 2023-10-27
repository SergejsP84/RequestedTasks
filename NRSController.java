package TelRanStudies.SpringWebTasks;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashSet;
import java.util.Set;
@RestController
public class NRSController {
    @GetMapping("/findSubstring")
    public String findSubstring(@RequestParam("string") String string) {
        return "The longest unique character sequence in the sought string is " + findUniqueCharSequence(string);
    }
    // Substring finder starts here
    // REQUEST URL FOR TESTING:
    // http://localhost:8080/findSubstring?string=asdsdfujhgdhfjhfr
    public static int findUniqueCharSequence(String string) {
        Set<Character> uniqueChars = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < string.length(); i++) {
            uniqueChars.clear();
            int currentLongestSubstring = 0;
            for (int j = i; j < string.length(); j++) {
                if (uniqueChars.add(string.charAt(j))) {
                    currentLongestSubstring++;
                } else {
                    if (longest < currentLongestSubstring) longest = currentLongestSubstring;
                    break;
                }
            }
        }
        return longest;
    }
    // Substring finder ends here
}
