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
}
