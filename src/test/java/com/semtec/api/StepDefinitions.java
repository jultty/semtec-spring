package com.semtec.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class StepDefinitions {

    private String termoControllerPath = "/api/v1/termo/";

    private static final String APPLICATION_JSON = "application/json";

    private final InputStream termoInputStream = this
            .getClass().getClassLoader()
            .getResourceAsStream("saida.json");
    private final String termoJSONString =
            new Scanner(termoInputStream, "UTF-8")
                    .useDelimiter("\\Z").next();

    private final InputStream termo1InputStream = this
            .getClass().getClassLoader()
            .getResourceAsStream("saida_0001.json");
    private final String termo1JSONString =
            new Scanner(termo1InputStream, "UTF-8")
                    .useDelimiter("\\Z").next();

    private final WireMockServer wireMockServer =
            new WireMockServer(options().dynamicPort());
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @Given("the endpoint is live")
    public void theEndpointIsLive() throws IOException {

        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());
        stubFor(get(urlEqualTo(termoControllerPath))
                .withHeader("accept", equalTo(APPLICATION_JSON))
                .willReturn(aResponse() .withBody(termoJSONString)));

        HttpGet request = new HttpGet("http://localhost:" +
                wireMockServer.port() + termoControllerPath);
        request.addHeader("accept", APPLICATION_JSON);
        HttpResponse httpResponse = httpClient.execute(request);
        String responseString = convertResponseToString(httpResponse);

        assertThat(responseString, containsString("\"termo\""));
        assertThat(responseString, containsString("\"significado\""));
        assertThat(responseString, containsString("\"teste\""));
        assertThat(responseString, containsString("sucesso\""));
        assertThat(responseString, containsString("\"interface\""));
        assertThat(responseString, containsString("componentes"));

        verify(getRequestedFor(urlEqualTo(termoControllerPath))
                .withHeader("accept", equalTo(APPLICATION_JSON)));

        request.abort();
        request.releaseConnection();
        wireMockServer.stop();

    }

    @When("a GET request is made for ID {int}")
    public void aGETRequestIsMadeForID(int arg0) throws IOException {

        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());
        givenThat(get(urlEqualTo(termoControllerPath + "1"))
                .withHeader("accept", equalTo(APPLICATION_JSON))
                .willReturn(aResponse() .withBody(termo1JSONString)));

        HttpGet request = new HttpGet("http://localhost:" +
                wireMockServer.port() + termoControllerPath + "1");
        request.addHeader("accept", APPLICATION_JSON);
        HttpResponse httpResponse = httpClient.execute(request);
        String responseString = convertResponseToString(httpResponse);

        assertThat(responseString, containsString("\"teste\""));
        assertThat(responseString, containsString("previsível"));
        assertThat(responseString, containsString("observação"));
        assertThat(responseString, containsString("sucesso"));
        assertThat(responseString, not(containsString("interface")));
        assertThat(responseString, not(containsString("componentes")));

        verify(getRequestedFor(urlEqualTo(termoControllerPath))
                .withHeader("accept", equalTo(APPLICATION_JSON)));

        request.abort();
        request.releaseConnection();
        wireMockServer.stop();

    }

    @Then("the service should return code {int}")
    public void theServiceShouldReturnCode(int arg0) throws IOException {

        wireMockServer.start();

        configureFor("localhost", wireMockServer.port());
        givenThat(get(urlEqualTo(termoControllerPath + "1"))
                .withHeader("accept", equalTo(APPLICATION_JSON))
                .willReturn(aResponse() .withBody(termo1JSONString)
                .withStatus(200)));

        HttpGet request = new HttpGet("http://localhost:" +
                wireMockServer.port() + termoControllerPath + "1");
        request.addHeader("accept", APPLICATION_JSON);
        HttpResponse httpResponse = httpClient.execute(request);
        String responseString = convertResponseToString(httpResponse);
        String responseStatus = String.valueOf(httpResponse.getStatusLine());

        assertThat(responseString, containsString("teste"));
        assertThat(responseString, containsString("sucesso"));
        assertThat(responseStatus, containsString("200 OK"));

        request.abort();
        request.releaseConnection();
        wireMockServer.stop();

    }

    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, StandardCharsets.UTF_8);
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        responseStream.close();
        return responseString;
    }

}
