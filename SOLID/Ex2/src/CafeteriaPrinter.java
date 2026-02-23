public class CafeteriaPrinter {

    public void printInvoice(String printable) {
        System.out.print(printable);
    }

    public void printSaved(String invoiceId, int lineCount) {
        System.out.println(
            "Saved invoice: " + invoiceId +
            " (lines=" + lineCount + ")"
        );
    }
}