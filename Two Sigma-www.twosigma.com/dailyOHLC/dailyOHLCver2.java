import java.util.*;

public class dailyOHLCver2 {
    public static ArrayList<ArrayList<Double>> PriceAndIndex (Object massive, Object massive1){
          ArrayList<ArrayList<Double>> couple1 = new ArrayList<>();
          couple1.add((ArrayList<Double>) massive);
          couple1.add((ArrayList<Double>) massive1);
          return couple1;
    }
    public static String ConverterInFirstPrice (ArrayList<ArrayList<Double>> massive) {
        return String.valueOf(String.format("%.2f",massive.get(0).get(0)));
    }
    public static String ConverterInMaxPrice (ArrayList<ArrayList<Double>> massive) {
        double p = Collections.max(massive.get(0));
        return String.valueOf(String.format("%.2f", p));
    }
    public static String ConverterInMinPrice (ArrayList<ArrayList<Double>> massive) {
        double p = Collections.min(massive.get(0));
        return String.valueOf(String.format("%.2f", p));
    }
    public static String ConverterInLastPrice (ArrayList<ArrayList<Double>> massive) {
        return String.valueOf(String.format("%.2f",massive.get(0).get(massive.get(0).size()-1)));}

    public static String[][] dailyOHLC(int[] timestamp, String[] instrument, String[] side, double[] price, int[] size) {
        String[][] ts = new String[timestamp.length][4];
        for (int i=0;i<timestamp.length;++i){
            ts[i][0] = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date ((timestamp[i]-10800)*1000L));
            ts[i][1] = instrument[i];
            ts[i][2] = String.valueOf(price[i]);
            ts[i][3] = String.valueOf(i);
        }
        Arrays.sort(ts, new Comparator<String[]>() {
            public int compare(final String[] entry1, final String[] entry2) {
                String time1 = entry1[0];
                String time2 = entry2[0];
                int sComp = time1.compareTo(time2);

                if (sComp != 0) {
                    return sComp;
                }
                time1 = entry1[1];
                time2 = entry2[1];
                return time1.compareTo(time2);
            }
        });
        ArrayList<Double> spcprice = new ArrayList<>();
        ArrayList<Double> indx_price = new ArrayList<>();
        String[] couple = new String[2];
        LinkedHashMap <String[], ArrayList<ArrayList<Double>>> dictionary = new LinkedHashMap <>();
        spcprice.add(Double.valueOf(ts[0][2]));
        indx_price.add(Double.valueOf(ts[0][3]));
        if (ts.length==1){couple[0]=ts[0][0];couple[1]=ts[0][1];
                          dictionary.put(couple.clone(), PriceAndIndex(spcprice.clone(),indx_price.clone()
                          ));
                          spcprice.clear();indx_price.clear();}
        for (int i=0;i<ts.length-1;++i){
            if (ts[i][0].equals(ts[i+1][0]) & ts[i][1].equals(ts[i+1][1]) & i!=ts.length-2){spcprice.add(Double.valueOf(ts[i+1][2]));
                indx_price.add(Double.valueOf(ts[i+1][3]));}
            else if (ts[i][0].equals(ts[i+1][0]) & ts[i][1].equals(ts[i+1][1]) & i==ts.length-2){spcprice.add(Double.valueOf(ts[i+1][2]));
                indx_price.add(Double.valueOf(ts[i+1][3]));
                couple[0]=ts[i+1][0];couple[1]=ts[i+1][1];
                dictionary.put(couple.clone(), PriceAndIndex(spcprice.clone(),indx_price.clone()));
                spcprice.clear();indx_price.clear();}
            else if (!(ts[i][0].equals(ts[i+1][0]) & ts[i][1].equals(ts[i+1][1])) & i==ts.length-2){
                couple[0]=ts[i][0];couple[1]=ts[i][1];
                dictionary.put(couple.clone(), PriceAndIndex(spcprice.clone(),indx_price.clone()));
                spcprice.clear();indx_price.clear();
                spcprice.add(Double.valueOf(ts[i+1][2]));
                indx_price.add(Double.valueOf(ts[i+1][3]));
                spcprice.add(Double.valueOf(ts[i+1][2]));
                indx_price.add(Double.valueOf(ts[i+1][3]));
                couple[0]=ts[i+1][0];couple[1]=ts[i+1][1];
                dictionary.put(couple.clone(), PriceAndIndex(spcprice.clone(),indx_price.clone()));
                spcprice.clear();indx_price.clear();}
            else {couple[0]=ts[i][0];couple[1]=ts[i][1];
                dictionary.put(couple.clone(), PriceAndIndex(spcprice.clone(),indx_price.clone()));
                spcprice.clear();indx_price.clear();
                spcprice.add(Double.valueOf(ts[i+1][2]));
                indx_price.add(Double.valueOf(ts[i+1][3]));}
        }
        String[][] ts1 = new String[dictionary.size()][6];
        int i=0;
        for (String[] key : dictionary.keySet()) {
            ts1[i][0]=key[0];
            ts1[i][1]=key[1];
            ts1[i][2]=ConverterInFirstPrice(dictionary.get(key));
            ts1[i][3]=ConverterInMaxPrice(dictionary.get(key));
            ts1[i][4]=ConverterInMinPrice(dictionary.get(key));
            ts1[i][5]=ConverterInLastPrice(dictionary.get(key));
            i++;
        }
        return ts1;
    }
}
