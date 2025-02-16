package io.qdrant.client;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

import static io.qdrant.client.VectorFactory.vector;
import static io.qdrant.client.grpc.Points.NamedVectors;
import io.qdrant.client.grpc.Points.Vector;
import static io.qdrant.client.grpc.Points.Vectors;

/**
 * Convenience methods for constructing {@link Vectors}
 */
public final class VectorsFactory {
	private VectorsFactory() {
	}

	/**
	 * Creates named vectors
	 * @param values A map of vector names to {@link Vector}
	 * @return a new instance of {@link Vectors}
	 */
	public static Vectors namedVectors(Map<String, Vector> values) {
		return Vectors.newBuilder()
			.setVectors(NamedVectors.newBuilder()
				.putAllVectors(values)
			)
			.build();
	}

	/**
	 * Creates a vector
	 * @param values A list of values
	 * @return a new instance of {@link Vectors}
	 */
	public static Vectors vectors(List<Float> values) {
		return Vectors.newBuilder()
			.setVector(vector(values))
			.build();
	}

	/**
	 * Creates a vector
	 * @param values A list of values
	 * @return a new instance of {@link Vectors}
	 */
	public static Vectors vectors(float... values) {
		return Vectors.newBuilder()
			.setVector(vector(values))
			.build();
	}
}
