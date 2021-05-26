import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private final FileInput fileInput;
    private final FileOutput fileOutput;
    private List<Salesman> salesmen;
    private ReportDefinition reportDefinition;

    public Application() throws IOException {
        this.fileInput = new FileInput();
        this.fileOutput = new FileOutput();
        this.salesmen = new ArrayList<>();
        reportDefinition = new ReportDefinition();
    }

    public void start() throws IOException {
        getInputData();
        calculateScore();
        List<Salesman> sortedSalesmen = sortSalesmenList(salesmen);
        removeBadEntries(sortedSalesmen);
        createFileAndAddReport(sortedSalesmen);
    }

    private void getInputData() throws IOException {
        this.salesmen = this.fileInput.getSalesmanListFromFile();
        this.reportDefinition = this.fileInput.getReportDefinitionFromFile();
    }

    private void calculateScore() {
        for (Salesman salesman : salesmen) {
            salesman.calculateScore(this.reportDefinition.isUseExperienceMultiplier());
        }
    }

    private List<Salesman> sortSalesmenList(List<Salesman> salesmen) {
        List<Salesman> sortedSalesmen = new ArrayList<>(salesmen);
        sortedSalesmen.sort(Collections.reverseOrder());
        return sortedSalesmen;
    }

    private void removeBadEntries(List<Salesman> sortedSalesmen) {
        for (int i = 0; i < sortedSalesmen.size(); i++) {
            Salesman salesman = sortedSalesmen.get(i);
            if (salesman.getSalesPeriod() > this.reportDefinition.getPeriodLimit()) {
                sortedSalesmen.remove(salesman);
                i -= 1;
            }
        }
    }

    private void createFileAndAddReport(List<Salesman> sortedSalesmen) throws IOException {
        this.fileOutput.appendSalesmen(sortedSalesmen, this.reportDefinition.getTopPerformersThreshold());
    }
}
