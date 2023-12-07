package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepoImp implements ReviewRepository{

    private final JdbcTemplate jdbctemplate;

    private RowMapper<ReviewItem> ReviewItemMapper;

    public ReviewRepoImp(JdbcTemplate ajdbctemplate){

        this.jdbctemplate = ajdbctemplate;

        setReviewItemMapper();
    }

    private void setReviewItemMapper() {

        ReviewItemMapper = (rs, i) -> new ReviewItem(
                rs.getLong("id"),
                rs.getLong("requestId"),
                rs.getString("status"),
                rs.getDate("dateRequested")
        );
    }

    static List<ReviewItem> findByRequestIdAndStatus(String requestId, String inProgress) {
        return null;
    }

    public void add(Long Id){

    }
}
