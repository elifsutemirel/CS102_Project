import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Message {

	private int senderId;
	private int communityId;
	private String body;

	public Message(int senderId, int communityId, String body) {

		this.senderId = senderId;
		this.communityId = communityId;
		this.body = body;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public static Message createMessage(int senderId, int communityId, String body) throws SQLException {

		Connection connection = Main.connect();

		Message message = new Message(senderId, communityId, body);
		String query = "insert into messages values (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, senderId);
		statement.setInt(2, communityId);
		statement.setString(3, body);
		int count = statement.executeUpdate();

		statement.close();
		connection.close();

		return message;

	}

	public boolean isSentByCurrentUser() {
		if (User.getCurrentUser().getId() == senderId) {
			return true;
		}
		return false;
	}

	public static ArrayList<Message> getMessages(int communityId) throws SQLException {

		ArrayList<Message> messages = new ArrayList<>();

		Connection connection = Main.connect();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select count(*) from messages where communityid = '" + communityId + "'");
		long count;
		if (rs.next()) {
			count = rs.getLong(1);
			ResultSet rs2 = statement.executeQuery("select * from messages where communityid = '" + communityId + "'");
			rs2.next();
			for (long i = count - 1; i >= 0; i--) {
				int senderId = rs2.getInt("senderid");
				String body = rs2.getString("body");
				messages.add(new Message(senderId, communityId, body));
				rs2.next();
			}
			rs2.close();
		}
		rs.close();
		connection.close();
		return messages;
	}
}