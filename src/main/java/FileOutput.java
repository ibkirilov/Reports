import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOutput {
    private FileWriter writer;

    public FileOutput() throws IOException {
        this.writer = new FileWriter("src/main/resources/Report.csv");
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
