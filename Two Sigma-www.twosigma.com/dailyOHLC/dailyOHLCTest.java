import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class dailyOHLCTest {
    @Test
    public void test1Equals() {
        int[] timestamp = {1450625399};
        String[] instrument = {"AAPL"};
        String[] side = {"sell"};
        double[] price = {1};
        int[] size = {1};
        String[][] Expected_Output = {{"2015-12-20", "AAPL", "1,00", "1,00", "1,00", "1,00"}};
        Assert.assertTrue(Arrays.deepEquals(dailyOHLCver2.dailyOHLC(timestamp, instrument, side, price, size), Expected_Output));
    }
    @Test
    public void test2Equals() {
        int[] timestamp = {1450625399, 1450625400, 1450625500, 1450625550, 1451644200, 1451690100, 1451691000};
        String[] instrument = {"HPQ","HPQ","HPQ", "HPQ", "AAPL", "HPQ", "GOOG"};
        String[] side = {"sell", "buy", "buy", "sell", "buy", "buy", "buy"};
        double[] price = {10, 20.3, 35.5, 8.65, 20, 10, 100.35};
        int[] size = {10, 1, 2, 3, 5, 1, 10};
        String[][] Expected_Output = {{"2015-12-20","HPQ","10,00","35,50","8,65","8,65"},
                                     {"2016-01-01","AAPL","20,00","20,00","20,00","20,00"},
                                     {"2016-01-01","GOOG","100,35","100,35","100,35","100,35"},
                                          {"2016-01-01","HPQ","10,00","10,00","10,00","10,00"}};
        Assert.assertTrue(Arrays.deepEquals(dailyOHLCver2.dailyOHLC(timestamp, instrument, side, price, size), Expected_Output));
    }
    @Test
    public void test3Equals() {
        int[] timestamp = {801840015, 1346505615, 1346505615, 1346505615, 1346505615, 1346516000, 1592632799, 1592632799, 1592669600, 1592669600};
        String[] instrument = {"LAG", "HPQ", "HPQ", "HPQ", "AAOL", "LAG", "LAG", "GOOG", "AAOL", "HPQ"};
        String[] side = {"sell", "sell", "buy", "sell", "sell", "buy", "sell", "sell", "buy", "sell"};
        double[] price = {50.4, 75.64, 42.62, 92.69, 48.53, 20.85, 61.33, 32.61, 36.53, 28.74};
        int[] size = {543, 448, 140, 889, 857, 270, 305, 115, 243, 450};
        String[][] Expected_Output = {{"1995-05-30","LAG","50,40","50,40","50,40","50,40"},
                                      {"2012-09-01","AAOL","48,53","48,53","48,53","48,53"},
                                      {"2012-09-01","HPQ","75,64","92,69","42,62","92,69"},
                                      {"2012-09-01","LAG","20,85","20,85","20,85","20,85"},
                                      {"2020-06-20","AAOL","36,53","36,53","36,53","36,53"},
                                      {"2020-06-20","GOOG","32,61","32,61","32,61","32,61"},
                                        {"2020-06-20","HPQ","28,74","28,74","28,74","28,74"},
                                       {"2020-06-20","LAG","61,33","61,33","61,33","61,33"}};
        Assert.assertTrue(Arrays.deepEquals(dailyOHLCver2.dailyOHLC(timestamp, instrument, side, price, size), Expected_Output));
    }

}
