package org.apache.beam.examples;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JsonUrlReader2 {

    public JsonUrlReader2() {
    }

    public ArrayList<Recorrido> cargarURL() throws StreamReadException, DatabindException, MalformedURLException, IOException {
        Map<String, Object> serviceCodes = Map.of(
            "Buses Vule S.A.", new Object[]{111, 113, "113c", "113e", 119, 121, 125, 126},
            "Voy Santiago SPA", new Object[]{101, "101c", 103, 106, 107, "107c", "107cy", 108, 117, "117c"},
            "Buses Metropolitana S.A.", new Object[]{109, "109N", 110, "110c", 115, "115y", 118, 408, "408e"},
            "Redbus Urbano S. A.", new Object[]{105, 116, 120, 410, "410e", "410y"},
            "STP Santiago S.A.", new Object[]{102, 104, "112N", 114}
        );

        ArrayList<Recorrido> aRecorridos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (Map.Entry<String, Object> entry : serviceCodes.entrySet()) {
            String operador = entry.getKey();
            Object[] codes = (Object[]) entry.getValue();

            for (Object code : codes) {
                String url = "https://www.red.cl/restservice_v2/rest/conocerecorrido?codsint=" + code;
                JsonNode node = mapper.readTree(new URL(url));
                
                Iterator<JsonNode> it = node.iterator();
                while (it.hasNext()) {
                    JsonNode n = it.next();
                    Recorrido r = new Recorrido();

                    r.setCodigoRecorrido(n.get("codigorespuesta").asText());
                    r.setIdaVuelta(n.get("ida_vuelta").asText());
                    r.setInicioIda(n.get("inicio_ida").asText());
                    r.setInicioVuelta(n.get("inicio_vuelta").asText());
                    r.setTipoDia(n.get("tipo_dia").asText());
                    r.setHorarios(n.get("horarios").toString());

                    aRecorridos.add(r);
                }
            }
        }

        return aRecorridos;
    }

    public static void main(String[] args) {
        try {
            JsonUrlReader2 reader = new JsonUrlReader2();
            ArrayList<Recorrido> recorridos = reader.cargarURL();

            for (Recorrido r : recorridos) {
                System.out.println(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Recorrido {
    private String codigoRecorrido;
    private String idaVuelta;
    private String inicioIda;
    private String inicioVuelta;
    private String tipoDia;
    private String horarios;

    public Recorrido() {
    }

    public String getCodigoRecorrido() {
        return codigoRecorrido;
    }

    public void setCodigoRecorrido(String codigoRecorrido) {
        this.codigoRecorrido = codigoRecorrido;
    }

    public String getIdaVuelta() {
        return idaVuelta;
    }

    public void setIdaVuelta(String idaVuelta) {
        this.idaVuelta = idaVuelta;
    }

    public String getInicioIda() {
        return inicioIda;
    }

    public void setInicioIda(String inicioIda) {
        this.inicioIda = inicioIda;
    }

    public String getInicioVuelta() {
        return inicioVuelta;
    }

    public void setInicioVuelta(String inicioVuelta) {
        this.inicioVuelta = inicioVuelta;
    }

    public String getTipoDia() {
        return tipoDia;
    }

    public void setTipoDia(String tipoDia) {
        this.tipoDia = tipoDia;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Recorrido{" +
                "codigoRecorrido='" + codigoRecorrido + '\'' +
                ", idaVuelta='" + idaVuelta + '\'' +
                ", inicioIda='" + inicioIda + '\'' +
                ", inicioVuelta='" + inicioVuelta + '\'' +
                ", tipoDia='" + tipoDia + '\'' +
                ", horarios='" + horarios + '\'' +
                '}';
    }
}
