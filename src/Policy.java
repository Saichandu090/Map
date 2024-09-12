import java.time.LocalDate;
import java.util.Comparator;

public class Policy implements Comparable<Policy>
{
    private int policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy(int policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
            this.expiryDate=expiryDate;
    }

    @Override
    public String toString() {
        return "Policy :[" +
                "PolicyNumber=" + policyNumber +
                ", PolicyHolderName='" + policyHolderName + '\'' +
                ", ExpiryDate='" + expiryDate + '\'' +
                ']';
    }

    @Override
    public int compareTo(Policy p)
    {
        return this.expiryDate.compareTo(p.expiryDate);
    }
}
