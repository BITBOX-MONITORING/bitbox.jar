package Suporte;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class SlackAlert {
   private static HttpClient client = HttpClient.newHttpClient();
    private static final String webhook = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {;
        HttpRequest request = HttpRequest.newBuilder(URI.create(webhook))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    }
    public String enviarAlertaCpu(Double cpu) {
        String mensagem = "";
        JSONObject json = new JSONObject();

        if(cpu > 80) {
            mensagem = "[CRÍTICO!] O limite de 80% de uso da cpu foi atingido!";
        }else if (cpu > 50) {
            mensagem = "[ATENÇÃO!] O limite de 50% de uso da cpu foi atingido!";
        }

        return mensagem;
    }

    public String enviarAlertaRam(Double ram) {
        String mensagem = "";
        JSONObject json = new JSONObject();

        if(ram > 80) {
            mensagem = "[CRÍTICO!] O limite de 80% de uso da ram foi atingido!";
        }else if (ram > 50) {
            mensagem = "[ATENÇÃO!] O limite de 50% de uso da ram foi atingido!";
        }

        json.put("text", mensagem);

        return mensagem;
    }

    public String enviarAlertaDisco(Double disco) {
        String mensagem = "";
        JSONObject json = new JSONObject();

        if(disco > 80) {
            mensagem = "[CRÍTICO!] O limite de 80% de uso da disco foi atingido!";
        }else if (disco > 50) {
            mensagem = "[ATENÇÃO!] O limite de 50% de uso da disco foi atingido!";
        }

        json.put("text", mensagem);

        return mensagem;
    }


}
