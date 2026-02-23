import java.util.*;

public class InvoiceData {

    public final String invoiceId;
    public final List<OrderLine> lines;
    public final Map<String, MenuItem> menu;
    public final BillSummary summary;

    public InvoiceData(String invoiceId,
                       List<OrderLine> lines,
                       Map<String, MenuItem> menu,
                       BillSummary summary) {
        this.invoiceId = invoiceId;
        this.lines = lines;
        this.menu = menu;
        this.summary = summary;
    }
}