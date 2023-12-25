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
    public class Main {
        public static void main(String[] args) {
            RepairManager repairManager = new RepairManager();
            init(repairManager);
            processRequests(repairManager);
        }

        private static void init(RepairManager repairManager) {
            // i. Crear el perfil de dos mecánicos.
            repairManager.addMechanic("Rafael", "Suárez");
            repairManager.addMechanic("Victor", "Blanco");

            // ii. Crear el perfil de dos vehículos con sus respectivos clientes.
            Plate plate1 = new Plate("2031BET");
            Plate plate2 = new Plate("1766MXR");

            Customer customer1 = new Customer("Cliente 1", new Phone("612034589"));
            Customer customer2 = new Customer("Cliente 2", new Phone("XXXX")); // Número de teléfono no válido

            repairManager.addVehicle("Ford", "Fiesta", plate1, customer1);
            repairManager.addVehicle("Mercedes", "Benz", plate2, customer2);

            // iii. Crear dos piezas en el stock del taller.
            repairManager.addSparePart("Filtro de aire", 20);
            repairManager.addSparePart("Pastillas de freno", 30);
        }

        private static void processRequests(RepairManager repairManager) {
            // iv. Imprimir por pantalla todos los datos del primer mecánico.
            List<Mechanic> mechanics = repairManager.getMechanics();
            if (!mechanics.isEmpty()) {
                Mechanic firstMechanic = mechanics.get(0);
                System.out.println("Datos del primer mecánico:");
                System.out.println("Nombre: " + firstMechanic.getName());
                System.out.println("Apellido: " + firstMechanic.getSurname());
            }

            // v. Imprimir por pantalla todos los datos del segundo vehículo.
            List<Vehicle> vehicles = repairManager.getVehicles();
            if (!vehicles.isEmpty()) {
                Vehicle secondVehicle = vehicles.get(1);
                System.out.println("Datos del segundo vehículo:");
                System.out.println("Marca: " + secondVehicle.getMake());
                System.out.println("Modelo: " + secondVehicle.getModel());
            }

            // vi. Registrar una reparación que realiza el primer mecánico sobre el segundo vehículo. En esta reparación se han modificado dos piezas del vehículo, con el tipo de reparación "Mechanical".
            if (!mechanics.isEmpty() && !vehicles.isEmpty()) {
                Mechanic mechanic = mechanics.get(0);
                Vehicle vehicle = vehicles.get(1);

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
                repair.setBreakdownType(BreakDownTypes.MECHANICAL);

                // Registrar la reparación
                repairManager.addRepair(repair);

                // vii. Formalizar el pago de la reparación anterior.
                List<Repair> repairs = repairManager.getRepairs();
                if (!repairs.isEmpty()) {
                    Repair lastRepair = repairs.get(repairs.size() - 1);
                    int paymentAmount = repairManager.calculateRepairCost(lastRepair);
                    repairManager.formalizePayment(lastRepair, paymentAmount);
                }

                // viii. Borrar el primer vehículo.
                if (!vehicles.isEmpty()) {
                    Vehicle firstVehicle = vehicles.get(0);
                    repairManager.deleteVehicle(firstVehicle);
                }

                // ix. Imprimir por pantalla el número de vehículos del taller.
                int numberOfVehicles = repairManager.countVehicles();
                System.out.println("Número de vehículos en el taller: " + numberOfVehicles);

                // x. Imprimir por pantalla toda la información de la reparación: datos generales, piezas sustituidas y el pago.
                System.out.println("Información de la última reparación:");
                Repair lastRepair = repairs.get(repairs.size() - 1);
                System.out.println("Datos generales:");
                System.out.println("ID de reparación: " + lastRepair.getId());
                System.out.println("Fecha de reparación: " + lastRepair.getRepairDate());
                System.out.println("Descripción de la avería: " + lastRepair.getDescription());
                System.out.println("Tipo de reparación: " + lastRepair.getBreakdownType());
                System.out.println("Piezas modificadas:");
                for (Item item : lastRepair.getItems()) {
                    System.out.println("Pieza: " + item.getSparePart().getName());
                    System.out.println("Precio: " + item.getSparePart().getPrice() + "€");
                }
                System.out.println("Precio total: " + repairManager.calculateRepairCost(lastRepair) + "€");
            }
        }
    }}