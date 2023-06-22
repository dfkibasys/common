package de.dfki.cos.basys.common.mavenplugin.jsonpatch;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

@Mojo(name = "jsonpatch-maven-plugin", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class JsonPatchMavenPlugin extends AbstractMojo {

	@Parameter(required = true)
	private File patch;

	@Parameter(required = true)
	private File input;

	@Parameter(required = true)
	private File output;

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final YAMLMapper yamlMapper = new YAMLMapper();

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			final JsonPatch jsonPatch = getMapperFor(patch).readValue(patch, JsonPatch.class);
			final JsonNode inputNode = getMapperFor(input).readTree(input);
			JsonNode result = jsonPatch.apply(inputNode);
			getMapperFor(output).writerWithDefaultPrettyPrinter().writeValue(output, result);
		} catch (IOException | JsonPatchException ex) {
			throw new MojoExecutionException("Failed to run json patch plugin", ex);
		}
	}

	public ObjectMapper getMapperFor(File file) throws MojoExecutionException {
		String fileName = file.getName();
		if (fileName.endsWith(".json")) {
			return objectMapper;
		} else if (fileName.endsWith(".yml") || fileName.endsWith(".yaml")) {
			return yamlMapper;
		} else {
			throw new MojoExecutionException("Illegal file ending " + file.getName() + ". Only yml, yaml or json are valid file endings.");
		}
	}

}