import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class FileOutput {
    private FileWriter writer;

    public FileOutput() throws IOException {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        this.writer = new FileWriter(String.format("src/main/resources/Report %s-%s.csv", year, month));
        writer.append("Name, Score" + "\n");
    }

    public void appendSalesmen(List<Salesman> sortedSalesmen, Integer topPerformersThreshold) throws IOException {
        if (sortedSalesmen.size() > 0) {
            for (int i = 0; i < topPerformersThreshold; i++) {
                this.writer.append(sortedSalesmen.get(i).toString());
                this.writer.append("\n");
                if (sortedSalesmen.size() == i + 1) break;
            }
        }
        writer.flush();
        writer.close();
    }
}
