package uk.ac.cf.group5.Client.Project.Form;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class ResponseService {

    private final DataSource dataSource;

    public ResponseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveResponse(Response response) {
        String insertQuery = "INSERT INTO responses (userID, answer1, answer2, answer3, answer4) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

            pstmt.setLong(1, response.getUserID());
            pstmt.setInt(2, response.getAnswer1());
            pstmt.setInt(3, response.getAnswer2());
            pstmt.setInt(4, response.getAnswer3());
            pstmt.setInt(5, response.getAnswer4());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    // Other methods for different operations...
}

