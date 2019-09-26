/**
 */
package de.dfki.cos.basys.common.component;

public class ComponentOrderStatus {
	OrderStatus status;
	String message;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static class Builder {
		private OrderStatus status;
		private String message;

		public Builder status(OrderStatus status) {
			this.status = status;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public ComponentOrderStatus build() {
			return new ComponentOrderStatus(this);
		}
	}

	private ComponentOrderStatus(Builder builder) {
		this.status = builder.status;
		this.message = builder.message;
	}
}
