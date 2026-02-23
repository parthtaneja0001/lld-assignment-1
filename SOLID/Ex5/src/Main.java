public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());

        safe("PDF", new PdfExporter(), req);
        safe("CSV", new CsvExporter(), req);
        safe("JSON", new JsonExporter(), req);
    }

    private static void safe(String type, Exporter e, ExportRequest r) {
        ExportResult result = e.export(r);
        if(!result.isSuccess) {
            System.out.println(type + ": ERROR: " + result.errorMessage);
        }
        else {
            System.out.println(type + ": OK bytes=" + result.bytes.length);

        }
    }
}