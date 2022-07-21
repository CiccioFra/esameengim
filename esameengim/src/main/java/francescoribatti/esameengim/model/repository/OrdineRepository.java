package francescoribatti.esameengim.model.repository;

import francescoribatti.esameengim.model.Articolo;
import francescoribatti.esameengim.model.Ordine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static francescoribatti.esameengim.credenzialiDB.DBConfig.*;

/**
 * Classe che gestisce gli Ordini
 * @author Francesco Ribatti
 */
public class OrdineRepository {
    /**
     * Recupera dal DB tutti gli Ordini presenti nella Tabella "ordine"
     * @return Lista di tutti gli Ordini
     */
    public static List<Ordine> getOrdini(){
        List<Ordine> ordini = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id, numero, data FROM ordine");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ordine ordine = new Ordine(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getString("data")
                );
                ordini.add(ordine);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco l'elenco degli ordini
        return ordini;
    }

    /**
     * Crea l'oggetto Ordine con tutti i suoi metadati
     * @param id ID dell'ordine
     * @return Ordine
     */
    public static Ordine getOrdineByID(int id){
        Ordine ordine = null;

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id, numero, data FROM ordine WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ordine = new Ordine(
                        rs.getInt("id"),
                        rs.getInt("numero"),
                        rs.getString("data")
                );
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordine;
    }

    /**
     * Calcola il peso di ogni ordine
     * @param id_ordine ID dell'ordine
     * @return peso dell'ordine
     */
    public static double getPesoOrdine(int id_ordine){
        double peso = 0;

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id_articolo, quantita_articolo FROM voce WHERE id_ordine = ?");
            stmt.setInt(1, id_ordine);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_articolo = rs.getInt("id_articolo");
                Articolo articolo = ArticoloRepository.getArticoloByID(id_articolo);

                int nrArticoli = rs.getInt("quantita_articolo");

                peso += articolo.getPeso() * nrArticoli;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peso;
    }
}
