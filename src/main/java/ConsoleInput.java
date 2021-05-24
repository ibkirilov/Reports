import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private final BufferedReader bufferedReader;


    public ConsoleInput(InputStreamReader inputStreamReader) {
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    public String getPath() throws IOException {
        return this.bufferedReader.readLine();
    }
}
