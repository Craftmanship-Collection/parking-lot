package parkinglot.models;

import parkinglot.enums.PaymentType;

public class Token {
	private Vehicle vehicle;
	private Double cost;
	private PaymentType type;

	public Token() {
	}

	private Token(TokenBuilder builder) {
		this.vehicle = builder.vehicle;
		this.cost = builder.cost;
		this.type = builder.type;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public static class TokenBuilder {
		private Vehicle vehicle;
		private Double cost;
		private PaymentType type;

		public TokenBuilder vehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
			return this;
		}

		public TokenBuilder cost(Double cost) {
			this.cost = cost;
			return this;
		}

		public TokenBuilder paymentType(PaymentType type) {
			this.type = type;
			return this;
		}

		public Token build() {
			return new Token(this);
		}
	}

}
