package com.poodle.app.api;

import com.poodle.app.BaseTest;
import com.zitadel.Zitadel;
import com.zitadel.model.OrganizationServiceListOrganizationsResponse;
import com.zitadel.model.OrganizationServiceOrganization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        OrganizationServiceListOrganizationsResponse response = api.listOrganisations();
        assertNotNull(response);
        List<OrganizationServiceOrganization> result = response.getResult();
        assertNotNull(result);
        assertEquals(result.size(),1);
    }
}