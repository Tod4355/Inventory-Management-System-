import java.util.*;

class Vendor {
    private String name;
    private String contactNumber;

    public Vendor(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}

class Good {
    private String name;
    private String category;
    private double price;
    private Vendor vendor;

    public Good(String name, String category, double price, Vendor vendor) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public Vendor getVendor() {
        return vendor;
    }
}

class Bill {
    private int billNumber;
    private List<Good> goods;
    private double totalAmount;

    public Bill(int billNumber, List<Good> goods) {
        this.billNumber = billNumber;
        this.goods = goods;
        calculateTotalAmount();
    }

    public int getBillNumber() {
        return billNumber;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (Good good : goods) {
            totalAmount += good.getPrice();
        }
    }
}

class InventoryManagementSystem {
    private List<Vendor> vendors;
    private List<Good> goods;
    private List<Bill> bills;

    public InventoryManagementSystem() {
        vendors = new ArrayList<>();
        goods = new ArrayList<>();
        bills = new ArrayList<>();
    }

    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
    }

    public void addGood(Good good) {
        goods.add(good);
    }

    public void issueGoods(int billNumber, List<Good> issuedGoods) {
        Bill bill = new Bill(billNumber, issuedGoods);
        bills.add(bill);
    }

    public void viewVendors() {
        System.out.println("Vendors:");
        for (Vendor vendor : vendors) {
            System.out.println("Name: " + vendor.getName() + ", Contact Number: " + vendor.getContactNumber());
        }
    }

    public void viewGoods() {
        System.out.println("Goods:");
        for (Good good : goods) {
            System.out.println("Name: " + good.getName() + ", Category: " + good.getCategory() + ", Price: " + good.getPrice() + ", Vendor: " + good.getVendor().getName());
        }
    }

    public void viewBills() {
        System.out.println("Bills:");
        for (Bill bill : bills) {
            System.out.println("Bill Number: " + bill.getBillNumber() + ", Total Amount: " + bill.getTotalAmount());
            System.out.println("Goods:");
            for (Good good : bill.getGoods()) {
                System.out.println("Name: " + good.getName() + ", Category: " + good.getCategory() + ", Price: " + good.getPrice() + ", Vendor: " + good.getVendor().getName());
            }
            System.out.println();
        }
    }

    public void viewIssuedGoods() {
        System.out.println("Issued Goods:");
        for (Bill bill : bills) {
            System.out.println("Bill Number: " + bill.getBillNumber());
            System.out.println("Goods:");
            for (Good good : bill.getGoods()) {
                System.out.println("Name: " + good.getName() + ", Category: " + good.getCategory() + ", Price: " + good.getPrice() + ", Vendor: " + good.getVendor().getName());
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();

        Vendor vendor1 = new Vendor("Vendor 1", "1234567890");
        Vendor vendor2 = new Vendor("Vendor 2", "9876543210");

        inventoryManagementSystem.addVendor(vendor1);
        inventoryManagementSystem.addVendor(vendor2);

        Good good1 = new Good("Good 1", "Beverages", 2.99, vendor1);
        Good good2 = new Good("Good 2", "Bread/Bakery", 1.99, vendor1);
        Good good3 = new Good("Good 3", "Canned/Jarred Goods", 3.49, vendor2);

        inventoryManagementSystem.addGood(good1);
        inventoryManagementSystem.addGood(good2);
        inventoryManagementSystem.addGood(good3);

        List<Good> issuedGoods = new ArrayList<>();
        issuedGoods.add(good1);
        issuedGoods.add(good3);
        inventoryManagementSystem.issueGoods(1, issuedGoods);

        inventoryManagementSystem.viewVendors();
        System.out.println();
        inventoryManagementSystem.viewGoods();
        System.out.println();
        inventoryManagementSystem.viewBills();
        System.out.println();
        inventoryManagementSystem.viewIssuedGoods();
    }
}

