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
  interaction: InteractionStrategy
}

class Payment {
  strategy: PaymentStrategy
  vehicle: Vehicle

  chooseStrategy(): void
  computePayment(): void
}

enum PaymentType {
  CASH
}

interface PaymentStrategy {
  computePayment(Vehicle vehicle, Double cost): Token
  printToken(): void
}

class CashPaymentStrategy {
  computePayment(Vehicle vehicle, Double cost): Token
  printToken(): void
}

interface InteractionStrategy {
  read(): String
  readInt(): Integer
  write(): String
}

class ConsoleInteractionStrategy {
  read(): String
  readInt(): Integer
  write(): String
}

class Token {
  vehicle: Vehicle
  cost: Double
  type: PaymentType
}

ParkingLot .. Gate
ParkingLot .. Payment
ParkingLot .. InteractionStrategy
Vehicle .. VehicleType
Gate .. GateType
Token .. PaymentType
Token .. Vehicle
Payment ...o PaymentStrategy
Payment . Vehicle
PaymentStrategy ..> CashPaymentStrategy
PaymentStrategy .. Token
InteractionStrategy ..> ConsoleInteractionStrategy

@enduml
