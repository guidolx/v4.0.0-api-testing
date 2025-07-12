package com.poodle.app.api;

import com.zitadel.Zitadel;
import com.zitadel.api.OrganizationServiceApi;
import com.zitadel.model.*;

public class OrganisationAPI {

    private final Zitadel zitadel;

    public OrganisationAPI(Zitadel zitadel){
        this.zitadel = zitadel;
    }

    public OrganizationServiceListOrganizationsResponse listOrganisations(){
        OrganizationServiceApi orgs = zitadel.getOrganizations();
        OrganizationServiceListOrganizationsRequest request = new OrganizationServiceListOrganizationsRequest();
        OrganizationServiceSearchQuery searchQuery = new OrganizationServiceSearchQuery();
        OrganizationServiceOrganizationNameQuery nameQuery = new OrganizationServiceOrganizationNameQuery();
        nameQuery.setName("ZITADEL");
        searchQuery.setNameQuery(nameQuery);
        request.addQueriesItem(searchQuery);
        OrganizationServiceListQuery query = new OrganizationServiceListQuery();
        OrganizationServiceListOrganizationsResponse response = orgs.listOrganizations(request);
        return response;

    }


}
