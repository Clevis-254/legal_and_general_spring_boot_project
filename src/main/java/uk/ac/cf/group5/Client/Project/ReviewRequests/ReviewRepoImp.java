package uk.ac.cf.group5.Client.Project.ReviewRequests;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.ac.cf.group5.Client.Project.Reviews.RequestItem;

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

    public List<ReviewItem> getReviewItems(Long userId){
        String sql = "SELECT * FROM Reviews WHERE userId = ? and status = 'in_progress'";
        return jdbctemplate.query(sql, ViewReviewMapper, userId);
    }

    public void add(RequestItem Item) {
        String ReviewInsertSql =
                "insert into Reviews " +
                        "(userId,RequestId)" +
                        " values (?,?)";
        jdbctemplate.update(ReviewInsertSql,
                Item.getUserId(),
                Item.getId()
        );
    }
}