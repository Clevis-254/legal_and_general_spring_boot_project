package uk.ac.cf.group5.Client.Project.AnswerDTO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AnswerRepoImpl implements AnswerRepositoryDTO {
    private JdbcTemplate jdbcTemplate;

    public AnswerRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AnswerDTO> getAnswersGroupedByCategory() {
        String sql = "SELECT cq.category, cq.id as question_id, a.id as answer_id, a.answer, a.reviewID " +
                "FROM questions cq " +
                "LEFT JOIN answers a ON cq.id = a.questionID " +
                "ORDER BY cq.category, cq.id, a.id";

        List<AnswerDTO> result = jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println("category: " + rs.getString("category"));
            System.out.println("answer_id: " + rs.getObject("answer_id")); // Use getObject to handle potential NULL
            System.out.println("answer: " + rs.getObject("answer")); // Use getObject to handle potential NULL
            System.out.println("question_id: " + rs.getLong("question_id"));
            System.out.println("review_id: " + rs.getObject("reviewID")); // Use getObject to handle potential NULL

            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setQuestionCategory(rs.getString("category"));
            answerDTO.setAnswerId(rs.getLong("answer_id")); // Handle potential NULL by checking the data type
            answerDTO.setAnswer(rs.getString("answer"));
            answerDTO.setQuestionId(rs.getLong("question_id"));
            answerDTO.setReviewId(rs.getLong("reviewID")); // Handle potential NULL by checking the data type

            return answerDTO;
        });

        result.forEach(dto -> {
            System.out.println("Result: " + dto);
        });

        return result;
    }

    public List<AnswerDTO> getAnswersGroupedByContact() {
        String sql = "SELECT c.category as contact_category, cq.category as question_category, cq.id as question_id, a.id as answer_id, a.answer, a.reviewID " +
                "FROM contacts c " +
                "LEFT JOIN submissions s ON c.id = s.contactID " +
                "LEFT JOIN answers a ON s.id = a.subID " +
                "LEFT JOIN questions cq ON a.questionID = cq.id " +
                "ORDER BY c.category, cq.id, a.id";

        List<AnswerDTO> results = jdbcTemplate.query(sql, (rs, rowNum) -> {
            System.out.println("contact_category: " + rs.getString("contact_category"));
            System.out.println("question_category: " + rs.getString("question_category"));
            System.out.println("answer_id: " + rs.getObject("answer_id")); // Use getObject to handle potential NULL
            System.out.println("answer: " + rs.getObject("answer")); // Use getObject to handle potential NULL
            System.out.println("question_id: " + rs.getLong("question_id"));
            System.out.println("review_id: " + rs.getObject("reviewID"));

            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setContactCategory(rs.getString("contact_category"));
            answerDTO.setQuestionCategory(rs.getString("question_category"));
            answerDTO.setAnswerId(rs.getLong("answer_id")); // Handle potential NULL by checking the data type
            answerDTO.setAnswer(rs.getString("answer"));
            answerDTO.setQuestionId(rs.getLong("question_id"));
            answerDTO.setReviewId(rs.getLong("reviewID"));

            return answerDTO;
        });

        results.forEach(dto -> {
            System.out.println("Result: " + dto);
        });

        return results;
    }


    public List<AnswerDTO> getAnswersForSubmission(Long submissionId) {
        String sql = "SELECT c.fname as contact_fname, c.surname as contact_surname, cq.category as question_category, cq.id as question_id, cq.question, a.id as answer_id, a.answer, a.reviewID " +
                "FROM contacts c " +
                "JOIN submissions s ON c.id = s.contactID " +
                "LEFT JOIN answers a ON s.id = a.subID " +
                "LEFT JOIN questions cq ON a.questionID = cq.id " +
                "WHERE s.id = ? " +  // Add WHERE clause to filter by submission ID
                "ORDER BY c.fname, c.surname, cq.id, a.id";

        List<AnswerDTO> results = jdbcTemplate.query(sql, new Object[]{submissionId}, (rs, rowNum) -> {
            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setContactFirstName(rs.getString("contact_fname"));
            answerDTO.setContactSecondName(rs.getString("contact_surname"));
            answerDTO.setQuestionCategory(rs.getString("question_category"));
            answerDTO.setQuestionId(rs.getLong("question_id"));
            answerDTO.setQuestion_text(rs.getString("question"));
            answerDTO.setAnswerId(rs.getLong("answer_id"));
            answerDTO.setAnswer(rs.getString("answer"));
            answerDTO.setReviewId(rs.getLong("reviewID"));

            return answerDTO;
        });

        results.forEach(dto -> {
            System.out.println("Result: " + dto);
        });

        return results;
    }



}
