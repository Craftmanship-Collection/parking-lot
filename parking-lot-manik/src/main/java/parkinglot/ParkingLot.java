package parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parkinglot.enums.GateType;
import parkinglot.enums.VehicleType;
import parkinglot.models.Gate;
import parkinglot.service.Payment;
import parkinglot.models.Token;
import parkinglot.models.Vehicle;
import parkinglot.strategy.interactionstrategy.ConsoleInteractionStrategy;
import parkinglot.strategy.interactionstrategy.InteractionStrategy;

public class ParkingLot {
	public static List<Gate> entryGates = new ArrayList<>();
	public static List<Gate> exitGates = new ArrayList<>();

	public static Integer freeSlotsForTwoWheeler;
	public static Integer freeSlotsForFourWheeler;

	public static final Integer finalSlotsForTwoWheeler = 200;
	public static final Integer finalSlotsForFourWheeler = 50;

	public static Map<String, Vehicle> vehiclesInside = new HashMap<>();
	public static List<Token> previousToken = new ArrayList<>();

	public static InteractionStrategy interaction;

	public static void main(String[] args) {
		setup();

		takeRequest();

		interaction.close();
	}

	public static void takeRequest() {
		while (true) {
			printOptions();
			int choice = interaction.readInt();
			if (choice == 1) {
				String licenseNo = getLicenseNo().toUpperCase();
				VehicleType choosenVehicleType = chooseVehicleType();

				if (choosenVehicleType == null) {
					continue;
				}

				if (choosenVehicleType.equals("TWO_WHEELER")) {
					if (freeSlotsForTwoWheeler <= 0) {
						interaction.write("no free slots for two wheeler");
					} else {
						freeSlotsForTwoWheeler--;
					}
				} else if (choosenVehicleType.equals("FOUR_WHEELER")) {
					if (freeSlotsForFourWheeler <= 0) {
						interaction.write("no free slots for four wheeler");
					} else {
						freeSlotsForFourWheeler--;
					}
				}

				Vehicle vehicle = new Vehicle(licenseNo, choosenVehicleType);
				vehiclesInside.put(licenseNo, vehicle);
			} else if (choice == 2) {
				String licenseNo = getLicenseNo().toUpperCase();
				try {
					Vehicle vehicle = vehiclesInside.get(licenseNo);

					Payment payment = new Payment(vehicle);
					Token computePayment = payment.computePayment();

					if (vehicle.getVehicleType().equals("TWO_WHEELER")
							&& freeSlotsForTwoWheeler < finalSlotsForTwoWheeler) {
						freeSlotsForTwoWheeler++;
					} else if (vehicle.getVehicleType().equals("FOUR_WHEELER")
							&& freeSlotsForFourWheeler < finalSlotsForFourWheeler) {
						freeSlotsForFourWheeler++;
					}

					vehiclesInside.remove(licenseNo);
					previousToken.add(computePayment);
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
					continue;
				}
			}
		}
	}

	public static void printOptions() {
		interaction.write("Enter the options:");
		interaction.write("1. Enter vehicle");
		interaction.write("2. Exit vehicle");
	}

	public static String getLicenseNo() {
		interaction.write("Enter License number");
		String licenseNo = interaction.read();
		return licenseNo;
	}

	public static void printOptionsForVehicleTypeSelection() {
		interaction.write("Enter the Vehicle type");
		interaction.write("1. Two wheeler");
		interaction.write("2. Four wheeler");
	}

	public static VehicleType chooseVehicleType() {
		printOptionsForVehicleTypeSelection();

		Integer vehicleTypeChoice = interaction.readInt();

		switch (vehicleTypeChoice) {
			case 1: {
				return VehicleType.TWO_WHEELER;
			}
			case 2: {
				return VehicleType.FOUR_WHEELER;
			}
			default: {
				interaction.write("Not a valid option");
				return null;
			}
		}
	}

	public static void setup() {
		Gate entryGate = new Gate("entry-gate-1", GateType.ENTRY_GATE);
		Gate exitGate = new Gate("exit-gate-1", GateType.EXIT_GATE);

		entryGates.add(entryGate);
		exitGates.add(exitGate);

		interaction = new ConsoleInteractionStrategy();

		freeSlotsForTwoWheeler = finalSlotsForTwoWheeler;
		freeSlotsForFourWheeler = finalSlotsForFourWheeler;
	}
}
