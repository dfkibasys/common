package de.dfki.cos.basys.common.component;

public interface FunctionalClient {
	boolean connect(String connectionString);
	boolean disconnect();
}
