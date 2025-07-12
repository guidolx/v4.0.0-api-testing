package com.poodle.app;

import com.poodle.app.api.OrganisationAPI;
import com.zitadel.Zitadel;
import com.zitadel.model.OrganizationServiceListDetails;
import com.zitadel.model.OrganizationServiceListOrganizationsRequest;
import com.zitadel.model.OrganizationServiceListOrganizationsResponse;
import com.zitadel.model.OrganizationServiceListQuery;

/**
 * Hello world!
 */
public class App {
    private static String keyFilePath = "/Users/guido/Projects/Zitadel/V4.0.0/zitadel_output/sa-key.json";
    public static void main(String[] args) {
        final Zitadel zitadel = Zitadel.withPrivateKey("http://localhost:8099", keyFilePath);
        final OrganisationAPI orgs = new OrganisationAPI(zitadel);
        OrganizationServiceListOrganizationsResponse response = orgs.listOrganisations();
        OrganizationServiceListDetails details = response.getDetails();
        if(details != null){
            System.out.println(details.getTotalResult());
        }else{
            System.out.println("No details");
        }
    }
}
