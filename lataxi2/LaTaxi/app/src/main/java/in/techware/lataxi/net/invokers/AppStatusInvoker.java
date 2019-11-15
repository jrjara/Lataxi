package in.techware.lataxi.net.invokers;


import org.json.JSONObject;

import java.util.HashMap;

import in.techware.lataxi.model.DriverBean;
import in.techware.lataxi.net.ServiceNames;
import in.techware.lataxi.net.WebConnector;
import in.techware.lataxi.net.parsers.DriverDetailsParser;
import in.techware.lataxi.net.utils.WSConstants;

public class AppStatusInvoker extends BaseInvoker {

    public AppStatusInvoker() {
        super();
    }

    public AppStatusInvoker(HashMap<String, String> urlParams,
                        JSONObject postData) {
        super(urlParams, postData);
    }

    public DriverBean invokeAppStatusWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.APP_STATUS), WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service(true);
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        DriverBean driverBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return driverBean = null;
        } else {
            driverBean = new DriverBean();
            DriverDetailsParser driverDetailsParser = new DriverDetailsParser();
            driverBean = driverDetailsParser.parseDriverDetailsResponse(wsResponseString);
            return driverBean;
        }
    }
}
