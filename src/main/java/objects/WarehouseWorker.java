package objects;

import interfaces.ShippingService;

public class WarehouseWorker implements ShippingService {

    @Override
    public int calculateDeliveryTime() {
        return 3; // Some complex business logic goes here ...
    }
    @Override
    public String generateShippingLabel() {
        return "Warehouse standard stamp";
    }

    void main(){
        WarehouseWorker someWarehouse = new WarehouseWorker(); // less flexible
        ShippingService warehouse = new WarehouseWorker(); // more flexible

        System.out.println(warehouse.calculateDeliveryTime()); // 3
        System.out.println(warehouse.generateShippingLabel()); // Warehouse standard stamp
        // Interface static method. No need of concrete instances.
        System.out.println(ShippingService.generateShipmentLog()); // [29-01-2024] Product has been shipped.
    }
}
