import java.nio.charset.StandardCharsets;

public class CsvExporter implements Exporter {

    @Override
    public ExportResult export(ExportRequest req) {

        if (req == null) {
            return ExportResult.ofError("request must not be null");
        }

        String title = escape(req.title);
        String body  = escape(req.body);

        String csv = "title,body\n" +
                     title + "," + body + "\n";

        return new ExportResult(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String escape(String s) {
        if (s == null) return "\"\"";

        String escaped = s.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }
}