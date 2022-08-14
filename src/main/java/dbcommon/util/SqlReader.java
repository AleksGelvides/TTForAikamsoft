package dbcommon.util;

import org.codehaus.plexus.util.IOUtil;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SqlReader {
    private final static String sqlFilePath = "src/main/resources/sqlrec/";

    public static String getBuyersByLastName(String lastName) throws IOException {
        String sql = readSQL("lastName-search.sql").replaceAll("=lastName=", lastName);
        return sql;
    }

    public static String getBuyersBuProductNameAndCountBuy(String productName, int count) throws IOException{
        String sql = readSQL("productName_productCount-search.sql").replaceAll("=productName=", productName)
                .replaceAll("=countBuy=", String.valueOf(count));
        return sql;
    }

    public static String getBadBuyers(int count) throws IOException{
        String sql = readSQL("bad_buyers-search.sql").replaceAll("=count=", String.valueOf(count))
                .replaceAll("=countBuy=", String.valueOf(count));
        return sql;
    }

    public static String getBuyersMyMinPriceMaxPrice(int min, int max) throws IOException{
        String sql = readSQL("min_max_price-search.sql").replaceAll("=min=", String.valueOf(min)
                        .replaceAll("=max=", String.valueOf(max)));
        return sql;
    }

    public static String getStat(LocalDate startTime, LocalDate endTime) throws IOException {
        String sql = readSQL("stat.sql").replaceAll("=startTime=", startTime.toString())
                .replaceAll("=endTime=", endTime.toString());
        return sql;
    }



    private static String readSQL(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader
                (new InputStreamReader(new FileInputStream(sqlFilePath + filename), UTF_8))) {
            String sql = IOUtil.toString(br);
            return sql;
        } catch (IOException e) {
            System.err.println("SQL файл не найден" + "\n" + "EXIT");
            System.exit(1);
            return null;
        }
    }
}
