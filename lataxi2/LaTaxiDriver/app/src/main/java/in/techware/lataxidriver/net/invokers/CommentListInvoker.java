package in.techware.lataxidriver.net.invokers;

import org.json.JSONObject;

import java.util.HashMap;

import in.techware.lataxidriver.model.CommentListBean;
import in.techware.lataxidriver.net.ServiceNames;
import in.techware.lataxidriver.net.WebConnector;
import in.techware.lataxidriver.net.parsers.CommentListParser;
import in.techware.lataxidriver.net.utils.WSConstants;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package in.techware.lataxidriver.net.invokers
 * Project LaTaxiDriver
 */

public class CommentListInvoker extends BaseInvoker {

    public CommentListInvoker() {
        super();
    }

    public CommentListInvoker(HashMap<String, String> urlParams,
                              JSONObject postData) {
        super(urlParams, postData);
    }

    public CommentListBean invokeCommentListWS() {

        WebConnector webConnector;

        webConnector = new WebConnector(new StringBuilder(ServiceNames.COMMENT_LIST),
                WSConstants.PROTOCOL_HTTP, urlParams, null);

        //webConnector= new WebConnector(new StringBuilder(ServiceNames.MODELS), WSConstants.PROTOCOL_HTTP, null);
//    String wsResponseString=webConnector.connectToPOST_service();
        String wsResponseString = webConnector.connectToGET_service();
        System.out.println(">>>>>>>>>>> response: " + wsResponseString);
        CommentListBean commentListBean = null;
        if (wsResponseString.equals("")) {
            /*registerBean=new RegisterBean();
            registerBean.setWebError(true);*/
            return commentListBean = null;
        } else {
            commentListBean = new CommentListBean();
            CommentListParser commentListParser = new CommentListParser();
            commentListBean = commentListParser.parseCommentListResponse(wsResponseString);
            return commentListBean;
        }
    }
}
