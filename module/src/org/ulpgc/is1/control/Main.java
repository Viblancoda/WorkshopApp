package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;

public class Main {
    private static void init(RepairManager repairManager) {
        repairManager.addMechanic("Rafael", "Suárez");
        repairManager.addMechanic("Víctor", "Blanco");

        Phone customerPhone1 = new Phone("625789920");
        Customer customer1 = new Customer("Iván", customerPhone1);
        Plate plate1 = new Plate("2043FDL");
        Vehicle vehicle1 = new Vehicle("Toyota", "Camry", plate1, customer1);

        Phone customerPhone2 = new Phone("678991123");
        Customer customer2 = new Customer("Laura", customerPhone2);
        Plate plate2 = new Plate("5512GBT");
        Vehicle vehicle2 = new Vehicle("Mercedes", "Benz", plate2, customer2);

        repairManager.addVehicle(vehicle1);
        repairManager.addVehicle(vehicle2);

        SparePart sparePart1 = new SparePart("Engine", 500);
        SparePart sparePart2 = new SparePart("Brakes", 200);

        repairManager.addSparePart(sparePart1);
        repairManager.addSparePart(sparePart2);
    }

    public static void main(String[] args) {
        RepairManager repairManager = new RepairManager();
        init(repairManager);

        System.out.println("------------Datos del primer mecánico------------");
        System.out.println(repairManager.getMechanic(0).getName() + " " + repairManager.getMechanic(0).getSurname());

        System.out.println("------------Datos del segundo vehículo------------");
        System.out.println(repairManager.getVehicle(1).getMake() + " " + repairManager.getVehicle(1).getModel());
        System.out.println(repairManager.getVehicle(1).getPlate().getPlate());
        System.out.println(repairManager.getVehicle(1).getCustomer().getName());

        System.out.println("------------Registro de reparación------------");
        Mechanic mechanic = repairManager.getMechanic(0);
        Vehicle vehicle = repairManager.getVehicle(1);
        SparePart[] spareParts = {repairManager.getSparePart(0), repairManager.getSparePart(1)};
        repairManager.registerRepair(mechanic, vehicle, spareParts, BreakdownTypes.mechanical);

        System.out.println("------------Formalizar el pago------------");
        Repair repair = vehicle.getRepair(0);
        Date paymentDate = new Date();
        Payment payment = new Payment(paymentDate, repair.price());
        repair.addPayment(payment);
        System.out.println("Fecha de pago: " + payment.getDate());
        System.out.println("Monto pagado: " + payment.getAmount());

        System.out.println("------------Borrar el primer vehículo------------");
        repairManager.removeVehicle(0);

        System.out.println("Nº de vehículos: " + repairManager.getVehicleList().size());

        System.out.println("------------Información de la reparación------------");
        System.out.println("Fecha de reparación: " + repair.getDate());
        System.out.println("Descripción: " + repair.getDescription());
        System.out.println("Piezas sustituidas:");
        for (Item item : repair.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getSparePart().getName());
        }
        System.out.println("Total a pagar: " + repair.price());
    }
}
