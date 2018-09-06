import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class textOverlayOnHeroImageTest {
    @Test
    public void test1Equals() {
        int[][] image = {{10, 50, 90, 65},
                {10, 200, 255, 30},
                {10, 150, 30, 25}};
        int height = 2;
        int width = 3;
        int[] Expected_Output = {0, 1};
        Assert.assertTrue(Arrays.equals(textOverlayOnHerolmage.textOverlayOnHeroImage(image, height, width), Expected_Output));
    }
    @Test
    public void test2Equals() {
        int[][] image = {{1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int height = 1;
        int width = 2;
        int[] Expected_Output = {0, 0};
        Assert.assertTrue(Arrays.equals(textOverlayOnHerolmage.textOverlayOnHeroImage(image, height, width), Expected_Output));
    }
    @Test
    public void test3Equals() {
        int[][] image = {{255},
                {254},
                {255},
                {255}};
        int height = 2;
        int width = 1;
        int[] Expected_Output = {2, 0};
        Assert.assertTrue(Arrays.equals(textOverlayOnHerolmage.textOverlayOnHeroImage(image, height, width), Expected_Output));
    }

}