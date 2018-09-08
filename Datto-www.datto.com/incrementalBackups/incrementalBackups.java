import java.util.*;

public class incrementalBackups {
    static List<Integer> incrementalBackups(int lastBackupTime, int[][] changes) {
        Set<Integer> Set = new HashSet<>();
        for (int[] change : changes) {
            if (change[0] > lastBackupTime) {
                Set.add(change[1]);
            }
        }
        List<Integer> sortedStrings = new ArrayList<Integer>(Set);
        Collections.sort(sortedStrings);
        return sortedStrings;
    }
}

