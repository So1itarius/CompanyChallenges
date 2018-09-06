import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

public class domainTypeTest {
    @Test
    public void test1Equals() {
        String[] domains = {"en.wiki.org", "codesignal.com", "happy.net", "code.info"};
        String[] Expected_Output = {"organization", "commercial", "network", "information"};
        Assert.assertTrue(Arrays.equals(domainType.domainType(domains), Expected_Output));
    }

    @Test
    public void test2Equals() {
        String[] domains = {"com.net.info", "org.com.net", "net.com.org", "info.net.com", "net.net.com", "com.com.org", "info.info.net", "org.org.info"};
        String[] Expected_Output = {"information", "network", "organization", "commercial", "commercial", "organization", "network", "information"};
        Assert.assertTrue(Arrays.equals(domainType.domainType(domains), Expected_Output));
    }
    @Test
    public void test3Equals() {
        String[] domains = {"a.info", "a.com", "a.net", "a.org", "a.info", "a.com"};
        String[] Expected_Output = {"information", "commercial", "network", "organization", "information", "commercial"};
        Assert.assertTrue(Arrays.equals(domainType.domainType(domains), Expected_Output));
    }
}