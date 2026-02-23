import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final BillingCalculator calculator;
    private final InvoiceRepository repository;
    private final CafeteriaPrinter printer;
    private int invoiceSeq = 1000;
    public CafeteriaSystem(BillingCalculator calculator,InvoiceRepository repository,CafeteriaPrinter printer) {
        this.calculator = calculator;
        this.repository = repository;
        this.printer = printer;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Fixed SRP violation: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        BillSummary summary = calculator.calculate(customerType, lines, menu);

        InvoiceData invoiceData = new InvoiceData(invId, lines,menu, summary);

        String printable = InvoiceFormatter.format(invoiceData);
        printer.printInvoice(printable);
        repository.save(invId, printable);
        printer.printSaved(invId,repository.countLines(invId));
    }
}
