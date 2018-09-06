import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class domainType {
    static String[] domainType(String[] domains) {
        String[] domains1=new String[domains.length];
        Pattern p = Pattern.compile("\\.org$"), p1 = Pattern.compile("\\.com$"),p2 = Pattern.compile("\\.net$"), p3 = Pattern.compile("\\.info$");
        for (int i=0;i<domains.length;++i){
            Matcher m = p.matcher(domains[i]), m1 = p1.matcher(domains[i]), m2 = p2.matcher(domains[i]), m3 = p3.matcher(domains[i]);
            if (m.find()){domains1[i]="organization";}
            else if (m1.find()){domains1[i]="commercial";}
            else if (m2.find()){domains1[i]="network";}
            else if (m3.find()){domains1[i]="information";}
        }
        return domains1;
    }
}
