package uk.ac.cf.group5.Client.Project.AnswerDTO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AnswerRepoImpl implements AnswerRepositoryDTO {
    private  JdbcTemplate jdbcTemplate;

    public AnswerRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<AnswerDTO> getAnswersGroupedByCategory() {
        String sql = "SELECT cq.category, cq.id as question_id, cq.question, a.id as answer_id, a.answer " +
                "FROM contact_questions cq " +
                "LEFT JOIN answers a ON cq.id = a.questionID " +
                "ORDER BY cq.category, cq.id, a.id";

        List<AnswerDTO> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println("category: " + rs.getString("category"));
            System.out.println("answer_id: " + rs.getObject("answer_id")); // Use getObject to handle potential NULL
            System.out.println("answer: " + rs.getObject("answer")); // Use getObject to handle potential NULL
            System.out.println("question_id: " + rs.getLong("question_id"));

            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setCategory(rs.getString("category"));
            answerDTO.setAnswerId(rs.getLong("answer_id")); // Handle potential NULL by checking the data type
            answerDTO.setAnswer(rs.getString("answer"));
            answerDTO.setQuestionId(rs.getLong("question_id"));

            return answerDTO;
        });

        result.forEach(dto -> {
            System.out.println("Result: " + dto);
        });

        return result;
    }

    public List<AnswerDTO> getAnswersGroupedByContact() {
        String sql = "SELECT c.category, cq.id as question_id, a.id as answer_id, a.answer " +
                "FROM contacts c " +
                "LEFT JOIN submissions s ON c.id = s.contactID " +
                "LEFT JOIN answers a ON s.id = a.subID " +
                "LEFT JOIN contact_questions cq ON a.questionID = cq.id " +
                "ORDER BY c.category, cq.id, a.id";

        List<AnswerDTO> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println("category: " + rs.getString("category"));
            System.out.println("answer_id: " + rs.getObject("answer_id")); // Use getObject to handle potential NULL
            System.out.println("answer: " + rs.getObject("answer")); // Use getObject to handle potential NULL
            System.out.println("question_id: " + rs.getLong("question_id"));

            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setCategory(rs.getString("category"));
            answerDTO.setAnswerId(rs.getLong("answer_id")); // Handle potential NULL by checking the data type
            answerDTO.setAnswer(rs.getString("answer"));
            answerDTO.setQuestionId(rs.getLong("question_id"));

            return answerDTO;
        });

        result.forEach(dto -> {
            System.out.println("Result: " + dto);
        });

        return result;
    }



}
