package com.poodle.app.api;

import com.poodle.app.BaseTest;
import com.zitadel.model.OrganizationServiceListOrganizationsResponse;
import com.zitadel.model.OrganizationServiceOrganization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrganisationAPITest extends BaseTest {

private OrganisationAPI api;

    @BeforeEach
    void setUp() {
        api = new OrganisationAPI(zitadel);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listOrganisations() {
        OrganizationServiceListOrganizationsResponse response = api.listOrganisationsByName("ZITADEL");
        assertNotNull(response);
        List<OrganizationServiceOrganization> result = response.getResult();
        assertNotNull(result);
        assertEquals(result.size(),1);
    }

    @Test() // Testing Exceptions
    void nullOrganisationName(){
        com.zitadel.ApiException ex = Assertions.assertThrows(com.zitadel.ApiException.class, () -> api.listOrganisationsByName(null));
        assertEquals(400, ex.getCode());
        //{"code":"invalid_argument","message":"invalid ListOrganizationsRequest.Queries[0]: embedded message failed validation | caused by: invalid SearchQuery.NameQuery: embedded message failed validation | caused by: invalid OrganizationNameQuery.Name: value length must be between 1 and 200 runes, inclusive"}
        System.out.println(ex.getResponseBody());
        //{X-Robots-Tag=[none], Accept-Encoding=[gzip], Content-Length=[303], Date=[Mon, 14 Jul 2025 07:58:29 GMT], Content-Type=[application/json]}
        System.out.println(ex.getResponseHeaders());
        //Error 400
        System.out.println(ex.getMessage());
        System.out.println(ex.getCause());
    }

    @Test
    void hugeOrganisationName(){
        String orgName =Stream.generate(() -> "x").limit(1100).collect(Collectors.joining());
        com.zitadel.ApiException ex = assertThrows(com.zitadel.ApiException.class, ()->api.listOrganisationsByName(orgName));
        assertEquals(400, ex.getCode());
        //{"code":"invalid_argument","message":"invalid ListOrganizationsRequest.Queries[0]: embedded message failed validation | caused by: invalid SearchQuery.NameQuery: embedded message failed validation | caused by: invalid OrganizationNameQuery.Name: value length must be between 1 and 200 runes, inclusive"}
        System.out.println(ex.getResponseBody());
        //{X-Robots-Tag=[none], Accept-Encoding=[gzip], Content-Length=[303], Date=[Mon, 14 Jul 2025 07:58:29 GMT], Content-Type=[application/json]}
        System.out.println(ex.getResponseHeaders());
        //Error 400
        System.out.println(ex.getMessage());
    }



}