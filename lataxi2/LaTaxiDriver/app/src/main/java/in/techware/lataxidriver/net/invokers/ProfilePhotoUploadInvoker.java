package in.techware.lataxidriver.net.invokers;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.techware.lataxidriver.model.BasicBean;
import in.techware.lataxidriver.net.ServiceNames;
import in.techware.lataxidriver.net.WebConnector;
import in.techware.lataxidriver.net.parsers.BasicParser;
import in.techware.lataxidriver.net.utils.WSConstants;

public class ProfilePhotoUploadInvoker extends BaseInvoker {

    public ProfilePhotoUploadInvoker() {
        super();
    }

    public ProfilePhotoUploadInvoker(HashMap<String, String> urlParams,
                                     JSONObject postData) {
        super(urlParams, postData);

    }

    public BasicBean invokeProfilePhotoUploadWS(ArrayList<String> fileList) {

        System.out.println("POSTDATA>>>>>>>" + postData);

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.UPLOAD_PROFILE_PHOTO),
                WSConstants.PROTOCOL_HTTP, null, postData, fileList);

        String wsResponseString = webConnector.connectToMULTIPART_POST_service("profile_photo");

        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        BasicBean basicBean = null;
        if (wsResponseString.equals("")) {

            return basicBean = null;
        } else {
            basicBean = new BasicBean();
            BasicParser basicParser = new BasicParser();
            basicBean = basicParser.parseBasicResponse(wsResponseString);
            return basicBean;
        }
    }
}
