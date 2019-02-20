/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.cos.basys.common.wmrestclient.SparqlClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tospie
 */
public class SparqlCommunicator {

    ObjectMapper jsonMapper = new ObjectMapper();
    String remoteRepository;
    protected Client client = ClientBuilder.newClient();
    protected WebTarget endpoint = null;

    public SparqlCommunicator(String remoteRepository) {
        this.remoteRepository = remoteRepository;
        this.endpoint = client.target(remoteRepository);
    }

    /*
    Performs a sparqlQuery and returns the received response as JSON variable
    bindings map (usually list of objects)
     */
    public String performQuery(String queryString) throws URISyntaxException {
        String requestUri = remoteRepository + "?query=" + URLEncoder.encode(queryString);
        WebTarget queryTarget = client.target(requestUri);
        String responseString = queryTarget.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        return responseString;
    }
}
