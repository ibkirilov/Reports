import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class FileInput {
    private final ObjectMapper objectMapper;
    private final ConsoleInput consoleInput;

    public FileInput() {
        this.objectMapper = new ObjectMapper();
        this.consoleInput = new ConsoleInput(new InputStreamReader(System.in));
    }

    public List<Salesman> getSalesmanListFromFile() throws IOException {
        System.out.print("Get path for salesmen from content root: ");
        return this.objectMapper.readValue(new File(this.consoleInput.getPath()), new TypeReference<>(){});

    }

    public ReportDefinition getReportDefinitionFromFile() throws IOException {
        System.out.print("Get path for report definition from content root: ");
        return this.objectMapper.readValue(new File(this.consoleInput.getPath()), ReportDefinition.class);
    }
}
