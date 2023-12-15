package uk.ac.cf.group5.Client.Project.Admin;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.ReviewRequests.ReviewItem;

import java.util.List;

@Repository
public class AdminReviewRepoimp {
    private final JdbcTemplate jdbctemplate;

    private RowMapper<ReviewItem> ReviewItemMapper;

    public AdminReviewRepoimp(JdbcTemplate ajdbctemplate) {

        this.jdbctemplate = ajdbctemplate;

        setReviewItemMapper();
    }

    private void setReviewItemMapper() {

        ReviewItemMapper = (rs, i) -> new ReviewItem(
                rs.getLong("id"),
                rs.getLong("userid"),
                rs.getLong("requestId"),
                rs.getString("status"),
                rs.getDate("date_started")
        );
    }


    public List<ReviewItem> getReview() {
        String sql = "SELECT * FROM reviews WHERE status = 'in_progress'";
        return jdbctemplate.query(sql, ReviewItemMapper);
    }
}