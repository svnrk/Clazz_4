package com.service;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.List;

public class PublicHolidayServiceTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(80 );
    PublicHolidayService service = new PublicHolidayService("http://localhost/");

    @Test
    public void throwsExceptionForInvalidJSON() {
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("INVALID RESPONSE")));

        List<ZonedDateTime> result = service.getPublicHolidays("2020");

        verify(getRequestedFor(urlEqualTo("/2020/EE")));
    }

    @Test
    public void processes_api_response() {
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{\"date\":\"2020-01-01\",\"localName\":\"uusaasta\",\"name\":\"New Year's Day\",\"countryCode\":\"EE\",\"fixed\":true,\"global\":true,\"counties\":null,\"launchYear\":null,\"type\":\"Public\"}]")));


        //when
        List<ZonedDateTime> result = service.getPublicHolidays("2020");

        //then
        assertEquals(1, result.size());
        assertEquals(ZonedDateTime.parse("2020-01-01T00:00+02:00[Europe/Tallinn]"), result.get(0));

        verify(getRequestedFor(urlEqualTo("/2020/EE")));
    }

    @Test
    public void getsEmptyJSON() {
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{}]")));


        //when
        List<ZonedDateTime> result = service.getPublicHolidays("2020");

        //then
        assertEquals(0, result.size());

        verify(getRequestedFor(urlEqualTo("/2020/EE")));
    }

    @Test
    public void getsJSONWithoutDate() {
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{\"localName\":\"uusaasta\",\"name\":\"New Year's Day\",\"countryCode\":\"EE\",\"fixed\":true,\"global\":true,\"counties\":null,\"launchYear\":null,\"type\":\"Public\"}]")));



        //when
        List<ZonedDateTime> result = service.getPublicHolidays("2020");

        //then
        assertEquals(0, result.size());

        verify(getRequestedFor(urlEqualTo("/2020/EE")));
    }
}