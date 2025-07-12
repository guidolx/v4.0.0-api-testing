package com.poodle.app;

import com.zitadel.Zitadel;

public class BaseTest {
    protected final String KEYFILEPATH = "/Users/guido/Projects/Zitadel/V4.0.0/zitadel_output/sa-key.json";
    protected final String HOST = "http://localhost:8099";

    protected Zitadel zitadel;

    public BaseTest() {
        zitadel = Zitadel.withPrivateKey(HOST,KEYFILEPATH);
    }
}
