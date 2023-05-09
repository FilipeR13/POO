import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Vintage implements Serializable {
    LocalDate currentDate;
    private Map<String,Utilizador> utilizadores;
    private Map<String,Artigos> artigos;
    private Map<String,Transportadora> transportadoras;

    public Vintage () {
        utilizadores = new HashMap<>();
        artigos = new HashMap<>();
        transportadoras = new HashMap<>();
        currentDate = LocalDate.now();
    }

    public Vintage (LocalDate date) {
        utilizadores = new HashMap<>();
        artigos = new HashMap<>();
        transportadoras = new HashMap<>();
        currentDate = date;
    }

    public Map<String, Utilizador> getUtilizadores() {
        return utilizadores.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }
    public Map<String, Artigos> getArtigos() {
        return artigos.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public Map<String, Transportadora> getTransportadoras() {
        return transportadoras.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.artigos = artigos.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public void setArtigos(Map<String, Artigos> artigos) {
        this.artigos = artigos.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public void setTransportadoras (Map<String, Transportadora> transportadoras) {
        this.transportadoras = transportadoras.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void addUtilizador (Utilizador u) {
        if (!utilizadores.containsKey(u.getEmail()))
            utilizadores.put(u.getEmail(), u.clone());
    }

    public void addArtigo (Artigos a) {
        if (!artigos.containsKey(a.getCodigo()))
            artigos.put(a.getCodigo(), a.clone());
    }

    public void addTransportadora (Transportadora t) {
        if (!transportadoras.containsKey(t.getId()))
            transportadoras.put(t.getId(), t.clone());
    }

    public void removeUtilizador (String email) {
        if (!utilizadores.containsKey(email))
            utilizadores.remove(email);
    }

    public void removeArtigo (String codigo) {
        if (!utilizadores.containsKey(codigo))
            utilizadores.remove(codigo);
    }

    public void removeTransportadora (String id) {
        if (!utilizadores.containsKey(id))
            utilizadores.remove(id);
    }
}
