package com.github.matschieu.jakartaee.cdi.bean;

public class ProducedBean {

	private boolean produced;

	private boolean disposed;

	public boolean isProduced() {
		return produced;
	}

	void setProduced(boolean produced) {
		this.produced = produced;
	}

	public boolean isDisposed() {
		return disposed;
	}

	void setDisposed(boolean disposed) {
		this.disposed = disposed;
	}

}
