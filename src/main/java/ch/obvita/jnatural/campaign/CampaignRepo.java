package ch.obvita.jnatural.campaign;

import ch.obvita.jnatural.abstracts.AbstractRepo;
import ch.obvita.jnatural.character.CharacterModel;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CampaignRepo extends AbstractRepo {


    public List<CampaignModel> getAll() {


        List<CampaignModel> campaigns = entityManager.createQuery("SELECT campaign from CampaignModel campaign").getResultList();


        return campaigns;
    }


//    public List<CampaignModel> getAllManual() throws Exception {
//
//        List<CampaignModel> campaignList = new ArrayList<>();
//
//        Class.forName("org.postgresql.Driver");
//
//        String connectionUrl = "jdbc:postgresql://localhost:5432/jnatural";
//        Connection connection = DriverManager.getConnection(connectionUrl, "postgres", "root");
//
//        Statement stmt = connection.createStatement();
//        ResultSet entries = stmt.executeQuery("SELECT * FROM jnatural_campaign");
//
//        while (entries.next()) {
//            CampaignModel temp = createCampaignObject(entries);
//            campaignList.add(temp);
//        }
//
//        entries.close();
//        stmt.close();
//        connection.close();
//
//        return campaignList;
//    }
//
//
//    private static CampaignModel createCampaignObject(ResultSet entry) throws SQLException {
//        CampaignModel tmpCampaign = new CampaignModel();
//        mapCampaignData(tmpCampaign, entry);
//        return tmpCampaign;
//    }
//
//
//    private static void mapCampaignData(CampaignModel campagne, ResultSet entry) throws SQLException {
//        campagne.setId(entry.getLong("id"));
//        campagne.setName(entry.getString("name"));
//
//    }


}
