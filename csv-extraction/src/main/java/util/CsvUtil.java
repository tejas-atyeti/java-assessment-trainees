package util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pojo.NamedColumnBean;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    public List<NamedColumnBean> beanBuilderExample(Path path, Class clazz) throws Exception {
        //CsvTransfer csvTransfer = new CsvTransfer();

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<NamedColumnBean> cb = new CsvToBeanBuilder<NamedColumnBean>(reader)
                    .withType(clazz)
                    .build();

            //csvTransfer.setCsvList(cb.parse());
        }
        //return csvTransfer.getCsvList();
        return new ArrayList<>();
    }

    public List<NamedColumnBean> namedColumnBeanExample() throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource("csv-extraction/src/main/resources/customers.csv").toURI());
        return beanBuilderExample(path, NamedColumnBean.class);
    }
}
