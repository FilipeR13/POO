import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Vintage implements Serializable {
    LocalDate currentDate;
    private Map<String,Utilizador> utilizadores;
    private Map<String,Artigos> artigos;
    private Map<String,Artigos> artigosDisponiveis;
    private Map<String,Transportadora> transportadoras;

    public Vintage () {
        utilizadores = new HashMap<>();
        artigos = new HashMap<>();
        artigosDisponiveis = new HashMap<>();
        transportadoras = new HashMap<>();
        currentDate = LocalDate.now();
    }

    public Vintage (LocalDate date) {
        utilizadores = new HashMap<>();
        artigos = new HashMap<>();
        artigosDisponiveis = new HashMap<>();
        transportadoras = new HashMap<>();
        currentDate = date;
    }

    public Map<String, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public Map<String, Artigos> getArtigos() {
        return artigos;
    }

    public Map<String, Artigos> getartigosDisponiveis() {
        return artigosDisponiveis;
    }

    public Map<String, Transportadora> getTransportadoras() {
        return transportadoras;
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

    public void setartigosDisponiveis(Map<String, Artigos> artigos) {
        this.artigosDisponiveis = artigos.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public void setTransportadoras (Map<String, Transportadora> transportadoras) {
        this.transportadoras = transportadoras.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(), (e)->e.getValue().clone()));
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void addUtilizador (Utilizador u) throws VintageException {
        if (!utilizadores.containsKey(u.getEmail()))
            utilizadores.put(u.getEmail(), u.clone());
        else {
            throw new VintageException("O email "+ u.getEmail() + " já está a ser utilizado");
        }
    }

    public void addArtigoDisponivel (Artigos a) {
        artigosDisponiveis.put(a.getCodigo(), a.clone());
    }
    public void addArtigo (Artigos a) {
        String codigo;
        do {
            codigo = Codigos.gerarCodigo();
        } while (this.artigos.containsKey(codigo));
        a.setCodigo(codigo);
        artigos.put(codigo, a.clone());
    }

    public void addTransportadora (Transportadora t) {
        transportadoras.put(t.getTransportadora(),t);
    }

    public void removeUtilizador (String email) {
        utilizadores.remove(email);
    }

    public void removeArtigo (String codigo) {
        artigos.remove(codigo);
    }

    public void removeArtigoDisponiveis (String codigo) {
        artigosDisponiveis.remove(codigo);
    }

    public void removeTransportadora (String id) {
        transportadoras.remove(id);
    }

    public void addDays(LocalDate localDate) {
        this.currentDate = localDate;
        this.utilizadores.forEach((key,value) -> {
            value.atualizaEncomendas (localDate);
        });
    }

    public String utilizadorMaisRendeu(LocalDate date) {
        String email = null;
        double rendeu = 0, max = 0;
        for(Map.Entry<String, Utilizador> u : utilizadores.entrySet()) {
            for(Map.Entry<String, Artigos> a : u.getValue().getVendeu().entrySet()) {
                if(a.getValue().getData_venda() != null && date.isBefore(a.getValue().getData_venda())) rendeu += a.getValue().getPrecoDesconto();
            }
            if(rendeu > max){
                max = rendeu;
                email = u.getValue().getEmail();
            }
            rendeu = 0;
        }
        return email;
    }
}