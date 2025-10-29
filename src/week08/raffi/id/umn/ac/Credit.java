package week08.raffi.id.umn.ac;

public class Credit extends Payment {
    private int installment;
    private int maxInstallmentAmount;

    public Credit(Item item, int maxInstallmentAmount) {
        super(item);
        this.maxInstallmentAmount = maxInstallmentAmount;
        this.installment = 0;
    }

    @Override
    public int pay() {
        if (isPaidOff) {
            return 0;
        }

        int perInstallment = item.getPrice() / maxInstallmentAmount;
        installment++;

        if (installment >= maxInstallmentAmount) {
            isPaidOff = true;
        }

        return perInstallment;
    }

    @Override
    public int getRemainingAmount() {
        if (isPaidOff) {
            return 0;
        }

        int perInstallment = item.getPrice() / maxInstallmentAmount;
        int remaining = item.getPrice() - (installment * perInstallment);

        return remaining;
    }

    public int getInstallment() {
        return installment;
    }

    public int getMaxInstallmentAmount() {
        return maxInstallmentAmount;
    }

    public String getClassName() {
        return "CREDIT";
    }
}

