import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import static java.lang.System.out;
import java.util.concurrent.Future;

/**
 * Author: junjie
 * Date: 8/6/15.
 * Target: <>
 */
public class AsyncHttpClients {
    public static void main(String[] args) {
        AsyncHttpClient ahc = new AsyncHttpClient();
        Response r0 = null, r1 = null;

        try {
            Future<Response> f0 = ahc.prepareGet("http://www.ning.com").execute(
                    new AsyncCompletionHandler<Response>() {
                        @Override
                        public Response onCompleted(Response response) throws Exception {
                            return response;
                        }
                    });
            r0 = f0.get();
            out.println(r0.getResponseBody());

            Future<Response> f1 = ahc.preparePost("http://www.ning.com").execute(
                    new AsyncCompletionHandler<Response>() {
                        @Override
                        public Response onCompleted(Response response) throws Exception {
                            return response;
                        }
                    }
            );
            r1 = f1.get();
            out.println(r1.getResponseBody());
        } catch (Exception ie) {
            out.println(ie);
        }
    }
}
