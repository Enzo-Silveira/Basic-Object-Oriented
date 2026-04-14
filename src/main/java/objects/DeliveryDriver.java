package objects;

import interfaces.ShippingService;

public class DeliveryDriver implements ShippingService {

    @Override
    public int calculateDeliveryTime() { return 1; } // Some complex business logic goes here ...

    @Override
    public String generateShippingLabel() { return "Delivery company stamp"; }

    // Subclass method
    public boolean confirmationCode(String code){
        return code.equals("43"); // Some complex business logic goes here ...
    }

    void main(){
        WarehouseWorker someWarehouse = new WarehouseWorker(); // NOT POLYMORPHIC
        ShippingService warehouse = new WarehouseWorker(); // POLYMORPHIC ASSIGNMENT
        ShippingService delivery = new DeliveryDriver(); // more flexible because future changes will not affect the code below
        ShippingService[] shippingChain = {someWarehouse, warehouse, delivery}; // POLYMORPHIC ASSIGNMENT
        int totalDeliveryTime = 0;
        for (ShippingService service : shippingChain) {
            final int deliveryTime = service.calculateDeliveryTime(); // POLYMORPHIC – the behavior 'varies' depending on the instance type.
            System.out.println("Delivery time of " + service.getClass().getSimpleName() + " = " + deliveryTime + " days.");
            totalDeliveryTime += deliveryTime;
        }
        System.out.println("Total delivery time = " + totalDeliveryTime);
        for (ShippingService service : shippingChain) {
            System.out.println("service.generateShippingLabel() = " + service.generateShippingLabel());
            // creates the temporary variable deliveryElement if service element is of type DeliveryDriver
            if(service instanceof DeliveryDriver deliveryElement) {
                final boolean isDelivered = deliveryElement.confirmationCode("43");
                System.out.println("isDelivered = " + isDelivered);
            }
        }
    }
}
