package com.liu.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.liu.xutils.pojo.Announcement;
import com.liu.xutils.pojo.ChatGroup;
import com.liu.xutils.pojo.Company;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;

public class DBImp implements IDB {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private static DBImp instance;

	public static DBImp getInstance() {
		if (instance != null) {
			return instance;
		}
		return new DBImp();
	}

	public int insert(User user) {
		int legth = 0;
		String userId = user.getUserId();
		String userPwd = user.getUserPwd();
		String userToken = user.getUserToken();
		String userName = user.getUserName();
		String userImg = user.getImgUrl();

		conn = DbPool.getConnection();
		String sql = "INSERT into tuser(password,tel,token,name,img_url) VALUE(?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userPwd);
			stmt.setString(2, userId);
			stmt.setString(3, userToken);
			stmt.setString(4, userName);
			stmt.setString(5, userImg);
			legth = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return legth;

	}

	public boolean selectUserByUserId(String userid) {
		List<User> user = getUserByUserId(userid, 0);
		if (user != null) {
			return true;
		}
		return false;
	}

	public int updateUser(String token, String imgUrl, String tel) {
		int legth = 0;
		conn = DbPool.getConnection();
		String sql = "UPDATE tuser set token=?,img_url=? WHERE tel=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, token);
			stmt.setString(2, imgUrl);
			stmt.setString(3, tel);
			legth = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return legth;
	}

	public String getJson(String userId, int i) {
		List<User> user = getUserByUserId(userId, i);
		if (user != null) {
			JSONObject users = new JSONObject().fromObject(user.get(0));
			return users.toString();
		}
		return null;
	}

	public List<User> getUserByUserId(String tel, int i) {
		List<User> users = new ArrayList<User>();
		User user = null;
		conn = DbPool.getConnection();
		Statement stmt = null;
		String sql = null;
		if (i == 0) { // 登录
			sql = "SELECT * FROM tuser WHERE tel=" + tel;
		} else { // 查询所有用户
			sql = "SELECT * FROM tuser WHERE tel like '%" + tel + "%'";
		}
		if (!tel.trim().equals("") && tel != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					user = new User();
					long id = rs.getLong("tu_id");
					String userName = rs.getString("name");
					String userPwd = rs.getString("password");
					String userId = rs.getString("tel");
					String token = rs.getString("token");
					String imgUrl = rs.getString("img_url");
					String position = rs.getString("position");
					Timestamp birthday = rs.getTimestamp("birthday");
					String address = rs.getString("address");
					int sex = rs.getInt("sex");
					user = new User(id, userName, userId, userPwd, token,
							imgUrl, birthday, address, sex, position);
					users.add(user);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				DbPool.DBClose(conn, stmt, rs);
			}
		}

		return users;
	}

	public List<User> addFriend(String userId, String friendId) {

		return null;
	}

	public User searchFriend(String friendId) {

		return null;
	}

	public Company getCompanyByUser(String number) {
		String sql = "SELECT tcompany.tc_id,tcompany.tc_name ,tcompany.tc_createTime FROM tuser tu,tusergrouprelation tug ,tgroup tg,tcompany WHERE tu.tu_id=tug.tu_id AND tug.tg_id=tg.tg_id AND tg.tc_id=tcompany.tc_id AND tu.tel=?";
		conn = DbPool.getConnection();
		Company company = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, number);
			rs = stmt.executeQuery();
			while (rs.next()) {
				company = new Company();
				long tcId = rs.getLong("tc_id");
				String tcName = rs.getString("tc_name");
				Timestamp createTime = rs.getTimestamp("tc_createTime");
				company.setTcId(tcId);
				company.setTcName(tcName);
				company.setCreateTime(createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return company;
	}

	public List<Group> getGroupsByCidPgid(Long companyId, Long parentId,
			int kind) {
		List<Group> groups = new ArrayList<Group>();
		String sql = null;
		if (kind == 0) {
			sql = "SELECT * FROM tgroup WHERE tc_id=? AND parent_tg_id=?";
		} else {
			// sql="SELECT * FROM tgroup WHERE parent_tg_id in(SELECT tg_id FROM tgroup WHERE tc_id=? AND parent_tg_id=?);";
			sql = "SELECT * FROM tgroup WHERE tc_id=? AND parent_tg_id=?";
		}
		conn = DbPool.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, companyId);
			stmt.setLong(2, parentId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Group group = new Group();
				group.setTgId(rs.getLong("tg_id"));
				group.setTgName(rs.getString("group_name"));
				group.setParentTgId(rs.getLong("parent_tg_id"));
				group.setTcId(rs.getLong("tc_id"));
				group.setDescription(rs.getString("description"));
				group.setTgLeaderId(rs.getLong("tg_leader"));
				groups.add(group);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return groups;
	}

	public List<User> getUsersByCidPgid(Long currentCId) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM tuser WHERE tu_id in (SELECT tu_id FROM tusergrouprelation WHERE tg_id=?)";
		conn = DbPool.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, currentCId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("tu_id"));
				user.setUserName(rs.getString("name"));
				user.setUserId(rs.getString("tel"));
				user.setUserToken(rs.getString("token"));
				user.setImgUrl(rs.getString("img_url"));
				user.setBirthday(rs.getTimestamp("birthday"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getInt("sex"));
				user.setUserPosition(rs.getString("position"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}

		return users;
	}

	public List<Group> getGroupsByTelCid(String tel, Long companyId) {
		List<Group> groups = null;
		String sql = "SELECT * FROM tgroup WHERE tg_id in(SELECT tg_id from tusergrouprelation WHERE  tu_id=(SELECT tu_id FROM tuser WHERE tel=?)) AND tc_id=?";
		conn = DbPool.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tel);
			stmt.setLong(2, companyId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				groups = new ArrayList<Group>();
				Group group = new Group();
				group.setTgId(rs.getLong("tg_id"));
				group.setTgName(rs.getString("group_name"));
				groups.add(group);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return groups;
	}

	public List<Group> getAllGroupByCid(Long companyId) {
		List<Group> groups = new ArrayList<Group>();
		conn = DbPool.getConnection();
		String sql = "SELECT * FROM tgroup WHERE tc_id=" + companyId;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Group group = getGroup(rs);
				groups.add(group);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return groups;
	}

	public Group getGroup(ResultSet rs) {
		Group group = null;
		try {
			group = new Group();
			group.setTgId(rs.getLong("tg_id"));
			group.setTgName(rs.getString("group_name"));
			group.setParentTgId(rs.getLong("parent_tg_id"));
			group.setTcId(rs.getLong("tc_id"));
			group.setDescription(rs.getString("description"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return group;
		}
	}

	public int createChatGroup(ChatGroup chatGroup) {
		List<User> chatUsers = chatGroup.getUsers();
		String sql = "INSERT into tchatgroup(chatgroup_name,chatgroup_id,createTime)  VALUES (?,?,?)";
		conn = DbPool.getConnection();
		int length = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, chatGroup.getName());
			stmt.setString(2, chatGroup.getGroupId());
			stmt.setTimestamp(3, chatGroup.getCreateTime());
			length = stmt.executeUpdate();
			if (length > 0) {
				String sqlRelation = "INSERT into tchatgrouprelation(user_id,tcg_id) VALUES (?,?)";
				conn.setAutoCommit(false);
				stmt = conn.prepareStatement(sqlRelation,
						ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				for (int i = 0; i < chatUsers.size(); i++) {
					stmt.setString(1, chatGroup.getUsers().get(i).getUserId());
					stmt.setString(2, chatGroup.getGroupId());
					stmt.addBatch();
				}
				stmt.executeBatch();
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return length;
	}

	public List<ChatGroup> getChatGroupByUserId(String userId) {
		List<ChatGroup> chatGroups = new ArrayList<ChatGroup>();
		ChatGroup chatGroup = null;
		String sql = "SELECT * FROM tchatgroup WHERE chatgroup_id in (SELECT tcg_id FROM tchatgrouprelation WHERE user_id=?)";
		conn = DbPool.getConnection();
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String chatName = rs.getString("chatgroup_name");
				String chatId = rs.getString("chatgroup_id");
				Timestamp time = rs.getTimestamp("createTime");
				chatGroup = new ChatGroup(chatName, chatId, time);
				chatGroups.add(chatGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return chatGroups;
	}

	public List<String> getChatUserIds(String chatId) {
		List<String> userIds = new ArrayList<String>();
		conn = DbPool.getConnection();
		String sqlChatuser = "SELECT user_id FROM tchatgrouprelation WHERE tcg_id=?";
		try {
			stmt = conn.prepareStatement(sqlChatuser);
			stmt.setString(1, chatId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("user_id");
				userIds.add(userId);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return userIds;
	}

	public ChatGroup getChatGroup(String chatId) {
		ChatGroup chatGroup = null;
		conn = DbPool.getConnection();
		String sql = "SELECT * FROM tchatgroup WHERE chatgroup_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, chatId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				String chatName = rs.getString("chatgroup_name");
				String chatgroupId = rs.getString("chatgroup_id");
				Timestamp time = rs.getTimestamp("createTime");
				chatGroup = new ChatGroup(chatName, chatgroupId, time);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		return chatGroup;
	}

	public int[] insertMemberToChatGroup(ChatGroup chatGroup) {
		List<User> users = chatGroup.getUsers();
		conn = DbPool.getConnection();
		int[] lenth = null;
		String sqlRelation = "INSERT into tchatgrouprelation(user_id,tcg_id) VALUES (?,?)";
		try {
			conn.setAutoCommit(false);
			stmt = conn
					.prepareStatement(sqlRelation,
							ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			for (int i = 0; i < users.size(); i++) {
				stmt.setString(1, chatGroup.getUsers().get(i).getUserId());
				stmt.setString(2, chatGroup.getGroupId());
				stmt.addBatch();
			}
			lenth = stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return lenth;
	}

	public int[] quitChatGroup(ChatGroup chatGroup) {
		// TODO Auto-generated method stub
		List<User> users = chatGroup.getUsers();
		String sql = "DELETE FROM tchatgrouprelation WHERE user_id=? AND tcg_id=?";
		conn = DbPool.getConnection();
		int length[] = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			for (int i = 0; i < users.size(); i++) {
				stmt.setString(1, chatGroup.getUsers().get(i).getUserId());
				stmt.setString(2, chatGroup.getGroupId());
				stmt.addBatch();
			}
			length = stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return length;
	}

	public int updateChatGroupName(ChatGroup chatGroup) {
		String groupId = chatGroup.getGroupId();
		String groupName = chatGroup.getName();
		String sql = "UPDATE tchatgroup set chatgroup_name =? WHERE chatgroup_id=?";
		int length = 0;
		conn = DbPool.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, groupName);
			stmt.setString(2, groupId);
			length = stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return length;
	}

	public int updatePwd(String telnum, String password) {
		String sql = "update tuser SET password=? WHERE tel=?";
		conn = DbPool.getConnection();
		int length = -1;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, telnum);
			System.out.println(sql);
			length = stmt.executeUpdate();
			System.out.println("sql" + length);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return length;
	}

	public Long addGroup(Group group) {
		String sql = "INSERT  INTO tgroup(group_name,parent_tg_id,description,tc_id,tg_leader) VALUES(?,?,?,?,?)";
		Connection conn = DbPool.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long id = 0L;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group.getTgName());
			pstmt.setLong(2, group.getParentTgId());
			pstmt.setString(3, group.getDescription());
			pstmt.setLong(4, group.getTcId());
			pstmt.setLong(5, group.getTgLeaderId());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();// 返回自增字段
			if (rs.next()) {
				id = rs.getLong(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public List<User> getUserByTelConatacts(List<User> users) {
		List<User> resultUsers = new ArrayList<User>();
		String sql = "SELECT * FROM tuser WHERE tel in (";
		for (User user2 : users) {
			if(user2.getUserId()!=null&&!user2.getUserId().trim().equals("")){				
				sql+=user2.getUserId()+",";
			}
		}
		sql = sql.substring(0, sql.lastIndexOf(","));
		sql += ")";
		System.out.println(sql);
		Connection conn = DbPool.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("tu_id"));
				user.setUserName(rs.getString("name"));
				user.setUserId(rs.getString("tel"));
				user.setImgUrl(rs.getString("img_url"));
				resultUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return resultUsers;
	}

	public int addMemberToGroup(User user) {
		String sql = "insert into tusergrouprelation (tu_id,tg_id) VALUES(?,?)";
		Connection conn = DbPool.getConnection();
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, user.getId());
			pstmt.setLong(2, user.getGroup().getTgId());
			index = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return index;
	}

	public Group getParentGroup(Group childGroup) {
		Connection conn = DbPool.getConnection();
		String sql = "SELECT * from tgroup WHERE parent_tg_id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, childGroup.getParentTgId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Group getGroupById(long groupId) {
		Connection conn = DbPool.getConnection();
		String sql = "SELECT * from tgroup WHERE tg_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Group group = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, groupId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				group = new Group();
				group.setTgId(rs.getLong("tg_id"));
				group.setTgName(rs.getString("group_name"));
				group.setParentTgId(rs.getLong("parent_tg_id"));
				group.setDescription(rs.getString("description"));
				group.setTcId(rs.getLong("tc_id"));
				group.setTgLeaderId(rs.getLong("tg_leader"));
				System.out.println("rs.getLong()" + rs.getLong("tg_leader"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return group;
	}

	public User getUserById(long userId) {
		Connection conn = DbPool.getConnection();
		String sql = "SELECT * from tuser WHERE tu_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong("tu_id"));
				user.setUserName(rs.getString("name"));
				user.setUserId(rs.getString("tel"));
				user.setUserToken(rs.getString("token"));
				user.setImgUrl(rs.getString("img_url"));
				user.setBirthday(rs.getTimestamp("birthday"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getInt("sex"));
				user.setUserPosition(rs.getString("position"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public int updateGroup(Group group) {
		String sql = "update tgroup set group_name='" + group.getTgName()
				+ "',parent_tg_id=" + group.getParentTgId();
		if (!(group.getTgLeaderId() == 0)) {
			sql += ",tg_leader=" + group.getTgLeaderId();
		}
		sql += " where tg_id=" + group.getTgId();
		System.out.println(sql);
		Connection conn = DbPool.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int index = 0;
		try {
			stmt = conn.createStatement();
			index = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return index;
	}

	/**
	 * 要删除该部门，首先将员工从该部门移除，移植该公司默认部门下，再将该部门以及子部门删除
	 */
	public int deleteGroup(Group group, Group rootGroup) {
		String updateSql = "update tusergrouprelation set tg_id="
				+ rootGroup.getTgId() + " WHERE tg_id=" + group.getTgId();
		String delete = "delete from ";
		Connection conn = DbPool.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			stmt.addBatch(updateSql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	/**
	 * 先查找该部门下的所有子部门，然后更新用户的当前组的id为最高，
	 */
	public int deleteGroup(Long parentId,Long targetId) {
		Connection conn=DbPool.getConnection();
		CallableStatement cstmt=null;
		String sql="call deleteChildGroup(?,?)";
		int index=0;
		try {
			cstmt=conn.prepareCall(sql);
			cstmt.setLong(1, parentId);
			cstmt.setLong(2, targetId);
			index=cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return index;
	}
	/**
	 * 查询该部门下的所有子部门
	 */
	public List<Long> getAllChildOfGruop(Group group) {
		Connection conn = DbPool.getConnection();
		List<Long> ids=new ArrayList<Long>();
		String sql="call showChild(?)";//事务查询
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setLong(1, group.getTgId());
			rs=cstmt.executeQuery();
			while(rs.next()){//查询成功
				ids.add(rs.getLong("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return ids;
	}

	public int updateUser(User user) {
//		String sql="update tuser set name='h',img_url='kk',birthday='2016-10-18 10:45:04',address='江苏', sex=1 WHERE tu_id=1  ";
		String sql="update tuser set sex="+user.getSex();
		if(user.getUserName()!=null){
			sql+=",name='"+user.getUserName()+"'";
		}
		if(user.getAddress()!=null&&!user.getAddress().trim().equals("")){
			sql+=",address='"+user.getAddress()+"'";
		}
		if(user.getBirthday()!=null){
			sql+=",birthday='"+user.getBirthday()+"'";
		}
		if(user.getImgUrl()!=null){
			sql+=",img_url='"+user.getImgUrl()+"'";
		}
		sql+=" where tu_id="+user.getId();
		System.out.println(sql);
		Connection conn=DbPool.getConnection();
		Statement stmt=null;
		int index=0;
		try {
			stmt=conn.createStatement();
			index=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		return index;
	}

	@Override
	public int changeUserGroup(long userId, long groupId) {
		Connection conn=DbPool.getConnection();
		String sql="UPDATE tusergrouprelation set tg_id=? WHERE tu_id=?";
		PreparedStatement pstmt=null;
		
		int index=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, groupId);
			pstmt.setLong(2, userId);
			index=pstmt.executeUpdate();
			System.out.println(index+"groudId="+groupId+" userId"+userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, pstmt, rs);
		}
		return index;
	}

	@Override
	public int deleteUserFromGroup(long userId) {
		String sql="delete FROM tusergrouprelation WHERE tu_id ="+userId;
		Connection conn=DbPool.getConnection();
		Statement stmt=null;
		int index=0;
		try {
			stmt=conn.createStatement();
			index=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return index;
	}

	@Override
	public Group getGroupsByUidCid(Long userId, Long companyId) {
		Group group = new Group();
		String sql = "SELECT * FROM tgroup WHERE tg_id in(SELECT tg_id from tusergrouprelation WHERE  tu_id=?) AND tc_id=?";
		conn = DbPool.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, userId);
			stmt.setLong(2, companyId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				group.setTgId(rs.getLong("tg_id"));
				group.setTgName(rs.getString("group_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbPool.DBClose(conn, stmt, rs);
		}
		return group;
	}
	public Long createCompany(Company company) {
		String sql="insert into tcompany (tc_name,tc_createTime,tc_type,tc_area)VALUES(?,?,?,?)";
		Connection conn=DbPool.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int index=-1;
		Long ret=-1L;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, company.getTcName());
			pstmt.setTimestamp(2, company.getCreateTime());
			pstmt.setString(3, company.getTctype());
			pstmt.setString(4, company.getTcarea());
			index=pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			if(rs.next()){
				ret=rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, pstmt, rs);
		}
		
		return ret;
	}
	public int addMembersToCreateGruop(List<User> list,Long groupId) {
		// TODO Auto-generated method stub
		String sql="insert into tusergrouprelation (tu_id,tg_id) VALUES";
		for(int i=0;i<list.size();i++){
			if (i==(list.size()-1)) {
				sql+="("+list.get(i).getId()+","+groupId+")";
			}else{
				sql+="("+list.get(i).getId()+","+groupId+"),";
			}
			
		}
		System.out.println(sql);
		Connection conn=DbPool.getConnection();
		PreparedStatement pstmt=null;
		int num=-1;
		try {
			pstmt=conn.prepareStatement(sql);
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		return num;
	}
	public List<Announcement> getAllAnnouncements() {
		List<Announcement> list=new ArrayList<Announcement>();
		Announcement announcement=null;
		conn=DbPool.getConnection();
		String sql="SELECT * FROM tannouncement";
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while (rs.next()) {
				announcement=new Announcement();
				announcement.setAid(rs.getLong("aid"));
				announcement.setAtime(rs.getString("atime"));
				announcement.setAtitle(rs.getString("atitle"));
				announcement.setAuthor(rs.getString("author"));
				announcement.setAuthorId(rs.getString("authorId"));
				announcement.setAcontent(rs.getString("acontent"));
				announcement.setImg_1(rs.getString("img_1"));
				announcement.setImg_2(rs.getString("img_2"));
				announcement.setImg_3(rs.getString("img_3"));
				announcement.setImg_4(rs.getString("img_4"));
				announcement.setImg_5(rs.getString("img_5"));
				announcement.setImg_6(rs.getString("img_6"));
				announcement.setImg_7(rs.getString("img_7"));
				announcement.setImg_8(rs.getString("img_8"));
				announcement.setImg_9(rs.getString("img_9"));
				list.add(announcement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		
		return list;
	}
	public int addAnnouncement(Announcement announcement) {
		String sql="insert into tannouncement (atitle,author,authorId,acontent,atime,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8,img_9)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=DbPool.getConnection();
		PreparedStatement pstmt=null;
		int index=-1;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, announcement.getAtitle());
			pstmt.setString(2, announcement.getAuthor());
			pstmt.setString(3, announcement.getAuthorId());
			pstmt.setString(4, announcement.getAcontent());
			pstmt.setString(5, announcement.getAtime());
			pstmt.setString(6, announcement.getImg_1());
			pstmt.setString(7, announcement.getImg_2());
			pstmt.setString(8, announcement.getImg_3());
			pstmt.setString(9, announcement.getImg_4());
			pstmt.setString(10, announcement.getImg_5());
			pstmt.setString(11, announcement.getImg_6());
			pstmt.setString(12, announcement.getImg_7());
			pstmt.setString(13, announcement.getImg_8());
			pstmt.setString(14, announcement.getImg_9());
			index=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, pstmt, rs);
		}
		return index;
	}
	public boolean setUserBoss(long id){
		
		String sql="INSERT into tuserrolerelation (tu_id,tr_id) VALUES(?,1);";
		conn=DbPool.getConnection();
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setLong(1, id);
			int i=stmt.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
	}
	public Company searchCompanyByCompanyId(Long id) {
		String  sql="SELECT * FROM tcompany where tc_id="+id;
		conn=DbPool.getConnection();
		Company company=null;
		try {
			stmt=conn.prepareStatement(sql);
			System.out.println(sql);
			rs=stmt.executeQuery();
			while (rs.next()) {
				company=new Company();
				long tcId=rs.getLong("tc_id");
				String tcName=rs.getString("tc_name");
				Timestamp createTime=rs.getTimestamp("tc_createTime");
				String tcarea=rs.getString("tc_area");
				String tctype=rs.getString("tc_type");
				company.setTcId(tcId);
				company.setTcName(tcName);
				company.setCreateTime(createTime);
				company.setTcarea(tcarea);
				company.setTctype(tctype);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbPool.DBClose(conn, stmt, rs);
		}
		return company;
	}
}
