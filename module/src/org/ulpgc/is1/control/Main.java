package org.ulpgc.is1.control;

import org.ulpgc.is1.model.Mechanic;
import org.ulpgc.is1.model.Plate;
import org.ulpgc.is1.model.RepairManager;
import org.ulpgc.is1.model.Vehicle;
import org.ulpgc.is1.model.SparePart;
import org.ulpgc.is1.model.Repair;
import org.ulpgc.is1.model.Payment;
import org.ulpgc.is1.model.Customer;
import org.ulpgc.is1.model.Item;
import org.ulpgc.is1.model.Phone;
import org.ulpgc.is1.model.BreakdownTypes;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RepairManager repairManager = new RepairManager();
        init(repairManager);
    }

    public static void init(RepairManager repairManager) {
        // i. Crear el perfil de dos mecánicos.
        repairManager.addMechanic("Rafael", "Suárez");
        repairManager.addMechanic("Victor", "Blanco");

        // ii. Crear el perfil de dos vehículos con sus respectivos clientes.
        Plate plate1 = new Plate("2031 BET");
        Plate plate2 = new Plate("1766 MXR");

        Customer customer1 = new Customer("Cliente 1", new Phone("612034589"));
        Customer customer2 = new Customer("Cliente 2", new Phone("Número no válido"));

        repairManager.addVehicle("Ford", "Fiesta", plate1, customer1);
        repairManager.addVehicle("Mercedes", "Benz", plate2, customer2);

        // iii. Crear dos piezas en el stock del taller.
        repairManager.addSparePart("Filtro de aire", 20);
        repairManager.addSparePart("Pastillas de freno", 30);

        // iv. Imprimir por pantalla todos los datos del primer mecánico.
        Mechanic mechanic1 = repairManager.getMechanics().get(0);
        System.out.println("Primer mecánico:");
        System.out.println("Nombre: " + mechanic1.getName());
        System.out.println("Apellido: " + mechanic1.getSurname());

        // v. Imprimir por pantalla todos los datos del segundo vehículo.
        Vehicle vehicle2 = repairManager.getVehicles().get(1);
        System.out.println("Segundo vehículo:");
        System.out.println("Marca: " + vehicle2.getMake());
        System.out.println("Modelo: " + vehicle2.getModel());

        // vi. Registrar una reparación que realiza el primer mecánico sobre el segundo vehículo. En esta reparación se han modificado dos piezas del vehículo, con el tipo de reparación “Mechanical”.
        Mechanic mechanic = repairManager.getMechanics().get(0);
        Vehicle vehicle = repairManager.getVehicles().get(1);

        // Crear una reparación
        Repair repair = new Repair(1, 3, new Date(), "Avería del vehículo", 3);
        repair.setNEXT_ID(repairManager.getRepairs().size() + 1);

        // Piezas modificadas
        Item item1 = new Item(2);
        Item item2 = new Item(1);
        item1.setSparePart(repairManager.getSpareParts().get(0));
        item2.setSparePart(repairManager.getSpareParts().get(1));
        repair.getItems().add(item1);
        repair.getItems().add(item2);

        // Tipo de reparación
        repair.setBreakdownType(BreakdownTypes.mechanical);

        // Registrar la reparación
        repairManager.getRepairs().add(repair);


        //vii Formalizar el pago de la reparación anterior.
        List<Repair> repairs = repairManager.getRepairs();
        if (!repairs.isEmpty()) {
            Repair lastRepair = repairs.get(repairs.size() - 1);
            int paymentAmount = repair.price();

            repairManager.formalizePayment(lastRepair, paymentAmount);
        }

        //viii Borrar el primer vehículo
        List<Vehicle> vehicles = repairManager.getVehicles();
        if (!vehicles.isEmpty()) {
            Vehicle firstVehicle = vehicles.get(0);
            repairManager.deleteVehicle(firstVehicle);
        }

        //iv Imprimir por pantalla el número de vehículos del taller
        int numberOfVehicles = repairManager.countVehicles();
        System.out.println("Número de vehículos en el taller: " + numberOfVehicles);

        //x Imprimir por pantalla toda la información de la reparación: datos generales piezas sustituidas y el pago.
        System.out.println("Información de la reparación");
        System.out.println("Mecánico: " + mechanic.getName() + " " + mechanic.getSurname());
        System.out.println("Vehículo: " + vehicle.getMake() + " " + vehicle.getModel());
        System.out.println("Tipo de reparación: " + repair.getBreakdownType());
        System.out.println("Piezas modificadas:");

        for (Item item : repair.getItems()) {
            System.out.println("Pieza: " + item.getSparePart().getName());
            System.out.println("Precio: " + item.getSparePart().getPrice() +"€");
        }
        System.out.println("Precio total: " + repair.price() + "€");
    }
}