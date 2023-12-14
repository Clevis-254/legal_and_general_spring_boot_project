package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;
import uk.ac.cf.group5.Client.Project.user.UserItem;

import java.sql.Date;
import java.util.List;

@Repository
public class ReviewRepoImp implements ReviewRepository{

    private static JdbcTemplate jdbctemplate;

    private static RowMapper<ReviewItem> ViewReviewMapper;


    public ReviewRepoImp(JdbcTemplate ajdbctemplate){

        jdbctemplate = ajdbctemplate;

        setReviewMapper();
    }

    private void setReviewMapper() {

        ViewReviewMapper = (rs, i) -> new ReviewItem(
                rs.getLong("id"),
                rs.getLong("userid"),
                rs.getLong("requestId"),
                rs.getString("status"),
                rs.getDate("date_started")
        );
    }

//    public List<ReviewItem> getReviewItems(Long userId){
//        String sql = "select * from reviews where userid = ?";
//        return jdbctemplate.query(sql, ReviewItemMapper, userId);
//    }



//    public static List<ReviewItem> getInProgressReviewItems() {
//        String sql = "SELECT * FROM reviews WHERE status = 'in progress'";
//        return jdbctemplate.query(sql, ViewReviewMapper);
//    }

    public List<ReviewItem> getReviewItems(long userId){
        String sql = "SELECT * FROM reviews WHERE userId = ? and status = 'in_progress'";
        return jdbctemplate.query(sql, ViewReviewMapper, userId);
    }
    public Date getDateForQ(long id){
        String sql = "select date_started from Reviews where id = ? and status = 'in_progress'";
        return jdbctemplate.queryForObject(sql, Date.class, id);
    }
    public void add(Long userID, Long requestID) {
        String reviewInsertSql =
                "INSERT INTO reviews " +
                        "(userId, RequestId)" +
                        " VALUES (?, ?)";
        jdbctemplate.update(reviewInsertSql, userID, requestID);
    }

    public ReviewItem getReview(long userId) {
        String sql = "select * from reviews where userId = ?";
        return jdbctemplate.queryForObject(sql,ViewReviewMapper, userId);
    }
    public ReviewItem getItem(long reviewID) {
        String sql = "select * from reviews where id = ?";
        return jdbctemplate.queryForObject(sql,ViewReviewMapper, reviewID);
    }

    public Date getDateForQ(long id){
        String sql = "select date_started from Reviews where id = ? and status = 'in_progress'";
        return jdbctemplate.queryForObject(sql, Date.class, id);
    }

    public String getFirstName(long reviewID) {
        String sql = "select firstname from users where id = (select userid from reviews where id = ?)";
        return jdbctemplate.queryForObject(sql, String.class, reviewID);
    }

    public String getLastName(long reviewID) {
        String sql = "select secondname from users where id = (select userid from reviews where id = ?)";
        return jdbctemplate.queryForObject(sql, String.class, reviewID);
    }

}
