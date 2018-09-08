import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class incrementalBackupsTest {
    @Test
    public void test1Equals() {
        int lastBackupTime = 461620205;
        int[][] changes = {{461620203, 1}, {461620204, 2}, {461620205, 6}, {461620206, 5}, {461620207, 3}, {461620207, 5}, {461620208, 1}};
        int[] Expected_Output = {1, 3, 5};
        int[] array = incrementalBackups.incrementalBackups(lastBackupTime, changes).stream().mapToInt(i -> i).toArray();
        Assert.assertTrue(Arrays.equals(array, Expected_Output));
    }
    @Test
    public void test2Equals() {
        int lastBackupTime = 461620214;
        int[][] changes = {};
        int[] Expected_Output = {};
        int[] array = incrementalBackups.incrementalBackups(lastBackupTime, changes).stream().mapToInt(i -> i).toArray();
        Assert.assertTrue(Arrays.equals(array, Expected_Output));
    }
    @Test
    public void test3Equals() {
        int lastBackupTime = 461620200;
        int[][] changes = {{461620475,17}, {461620543,29},{461625137,24},{461626523,60},{461627714,78}};
        int[] Expected_Output = {17, 24, 29, 60, 78};
        int[] array = incrementalBackups.incrementalBackups(lastBackupTime, changes).stream().mapToInt(i -> i).toArray();
        Assert.assertTrue(Arrays.equals(array, Expected_Output));
    }

}

