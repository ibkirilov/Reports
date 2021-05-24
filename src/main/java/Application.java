import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private FileInput fileInput;
    private FileOutput fileOutput;
    private List<Salesman> salesmen;
    private ReportDefinition reportDefinition;

    public Application() throws IOException, ParseException {
        this.fileInput = new FileInput();
        this.fileOutput = new FileOutput();
        this.salesmen = new ArrayList<>();
        reportDefinition = new ReportDefinition();
    }

    public void start() throws IOException {
        this.salesmen = this.fileInput.getSalesmanListFromFile();
        this.reportDefinition = this.fileInput.getReportDefinitionFromFile();

        for (Salesman salesman : salesmen) {
            salesman.calculateScore(this.reportDefinition.isUseExperienceMultiplier());
        }

        List<Salesman> sortedSalesmen = new ArrayList<>(salesmen);
        sortedSalesmen.sort(Collections.reverseOrder());

        for (int i = 0; i < sortedSalesmen.size(); i++) {
            Salesman salesman = sortedSalesmen.get(i);
            if (salesman.getSalesPeriod() > this.reportDefinition.getPeriodLimit()) {
                sortedSalesmen.remove(salesman);
                i -= 1;
            }
        }

        this.fileOutput.appendSalesmen(sortedSalesmen, this.reportDefinition.getTopPerformersThreshold());
        System.out.println();
    }
}
