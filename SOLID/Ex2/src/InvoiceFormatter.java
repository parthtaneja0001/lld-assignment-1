
public class InvoiceFormatter {

    public static String format(InvoiceData data) {

        StringBuilder out = new StringBuilder();

        out.append("Invoice# ").append(data.invoiceId).append("\n");

        for (OrderLine l : data.lines) {
            MenuItem item = data.menu.get(l.itemId);
            double lineTotal = item.price * l.qty;

            out.append(String.format(
                    "- %s x%d = %.2f\n",
                    item.name,
                    l.qty,
                    lineTotal
            ));
        }

        out.append(String.format("Subtotal: %.2f\n", data.summary.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n",data.summary.taxPct,data.summary.tax));
        out.append(String.format("Discount: -%.2f\n", data.summary.discount));
        out.append(String.format("TOTAL: %.2f\n", data.summary.total));

        return out.toString();
    }
}