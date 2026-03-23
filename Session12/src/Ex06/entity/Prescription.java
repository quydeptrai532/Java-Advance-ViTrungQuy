package Ex06.entity;

import java.sql.Date;

public class Prescription {
    private int id;
    private int medicineId;
    private int quantitySold;
    private Date saleDate;

    public Prescription() {
    }

    public Prescription(int id, int medicineId, int quantitySold, Date saleDate) {
        this.id = id;
        this.medicineId = medicineId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", medicineId=" + medicineId +
                ", quantitySold=" + quantitySold +
                ", saleDate=" + saleDate +
                '}';
    }
}