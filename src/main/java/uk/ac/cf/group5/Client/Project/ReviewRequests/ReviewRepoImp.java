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
                rs.getLong("userid"),
                rs.getLong("requestId"),
                rs.getString("status"),
                rs.getDate("dateRequested")
        );
    }

//    public List<ReviewItem> getReviewItems(Long userId){
//        String sql = "select * from reviews where userid = ?";
//        return jdbctemplate.query(sql, ReviewItemMapper, userId);
//    }



    public List<ReviewItem> getInProgressReviews() {
        String sql = "SELECT * FROM reviews WHERE status = 'in progress'";
        return jdbctemplate.query(sql, ReviewItemMapper);
    }

    public void add(Long Id){

    }
}
