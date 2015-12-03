package com.stu.ctrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.model.Account;
import com.stu.model.Comment;
import com.stu.model.Post;

public class CommentCtrl {
	
	public static List getCommentList(Post post) {
		Connection con = SqlCtrl.getCon();
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			ps = con.prepareStatement("select * from comment where post_id=?");
			ps.setInt(1, post.getPost_id());
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Comment c = new Comment();
				c.setPost_id(resultSet.getInt("post_id"));
				c.setComment_date(resultSet.getString("comment_date"));
				c.setContent(resultSet.getString("content"));
				c.setUser_id(resultSet.getInt("user_id"));
				c.setComment_id(resultSet.getInt("comment_id"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlCtrl.closeStatement(ps);
		SqlCtrl.closeCon(con);
		return list;
	}
}
