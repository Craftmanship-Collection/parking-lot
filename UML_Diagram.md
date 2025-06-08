@startuml

class Vehicle {
  licenseNo: String
  vehicleType: VehicleType
  inTime: DateTime
  outTime: DateTime
}

enum VehicleType {
  type: String
  hourlyRate: Double
}

class Gate {
  name: String
  type: GateType
}

enum GateType {
  ENTRY, EXIT
}

class ParkingLot {
  freeSlotsForFourWheeler: Integer
  freeSlotsForTwoWheeler: Integer
  
  entryGates: Set<Gate>
  exitGates: Set<Gate>
  
  vehiclesInside: List<Vehicle>
  payments: List<Payment>
  
  main(): void
}

class Payment {
  strategy: PaymentStrategy
  vehicle: Vehicle

  chooseStrategy(): void
  computePayment(): void
}

class PaymentStrategy {
  computePayment(Vehicle vehicle, Double cost): Token
  printToken(): void
}

class CashPaymentStrategy {
  computePayment(Vehicle vehicle, Double cost): Token
  printToken(): void
}

ParkingLot ... Gate
ParkingLot ... Payment
Payment ... Vehicle
Vehicle ... VehicleType
Gate ... GateType
Payment ...o PaymentStrategy
PaymentStrategy ...> CashPaymentStrategy

@enduml
