package francescoribatti.esameengim.model.repository;

import francescoribatti.esameengim.model.Articolo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static francescoribatti.esameengim.credenzialiDB.DBConfig.*;

/**
 * Classe che gestisce gli Articoli
 * @author Francesco Ribatti
 */
public class ArticoloRepository {
    /**
     * Recupera dal DB tutti gli Articoli presenti nella Tabella "articolo"
     * @return Lista di tutti gli articoli
     */
    public static List<Articolo> getArticoli(){
        List<Articolo> articoli = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id, codice, descrizione, peso FROM articolo");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Articolo articolo = new Articolo(
                        rs.getInt("id"),
                        rs.getString("codice"),
                        rs.getString("descrizione"),
                        rs.getDouble("peso")
                );
                articoli.add(articolo);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articoli;
    }

    /**
     * Recupera dal DB un Articolo specifico in base all'ID
     * @return Singolo articolo ricercato per ID
     */
    public static Articolo getArticoloByID(int id){
        Articolo articolo = null;

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id, codice, descrizione, peso FROM articolo WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                articolo = new Articolo(
                        rs.getInt("id"),
                        rs.getString("codice"),
                        rs.getString("descrizione"),
                        rs.getDouble("peso")
                );
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco l'elenco degli articoli
        return articolo;
    }
}