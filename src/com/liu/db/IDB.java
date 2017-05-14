package com.liu.db;

import java.util.List;

import com.liu.xutils.pojo.Announcement;
import com.liu.xutils.pojo.ChatGroup;
import com.liu.xutils.pojo.Company;
import com.liu.xutils.pojo.Group;
import com.liu.xutils.pojo.User;

public interface IDB {
	int insert(User user);
	/**
	 * 
	 * @param userid
	 * @return 如果为true 说明用户已经存在，直接登陆，否则先注册再登陆
	 */
	boolean selectUserByUserId(String userid);
	int updateUser(String token,String imgUrl,String userId);
	List<User> getUserByUserId(String userId,int i);
	/**
	 * 
	 * @param userId 用户id
	 * @return json 格式的字符串
	 */
	String getJson(String userId,int i);
	
	/**
	 * 添加好友
	 * @param userId 自己id
	 * @param friendId 好友id
	 * @return
	 */
	List<User> addFriend(String userId,String friendId);
	/**
	 * 
	 * @param friendId
	 * @return
	 */
	User searchFriend(String friendId);
	/**
	 * 根据用户 查找他所在的公司
	 * @return
	 */
	Company getCompanyByUser(String number);
	/**
	 * 根据公司id和父id 查找直接子部门
	 * @param companyId 公司id
	 * @param parentId 父组id
	 * @return 上级id直接子部门
	 */
	List<Group> getGroupsByCidPgid(Long companyId,Long parentId,int kind);
	/**
	 * 根据当前组id查找成员
	 * @param currentGId 当前组id
	 * @return
	 */
	List<User> getUsersByCidPgid(Long currentGId);
	/**
	 * 根据tel 和公司id 查找出当前用户所有的组
	 * @param tel 用户手机号
	 * @param companyId
	 * @return 所有的团队id
	 */
	List<Group> getGroupsByTelCid(String tel,Long companyId);
	/**
	 * 	根据id查找该公司下所有部门
	 * @param companyId 公司id
	 * @return
	 */
	List<Group> getAllGroupByCid(Long companyId);
	/**
	 * 插入讨论组
	 * @param chatGroup 谈论组一些信息
	 * @return 是否执行成功
	 */
	int createChatGroup(ChatGroup chatGroup);
	/**
	 * 根据用户id查找当前所在的讨论组
	 * @param userId 用户id
	 * @return
	 */
	List<ChatGroup> getChatGroupByUserId(String userId);
	/**
	 * 根据讨论组id查找所有成员
	 * @param chatId 讨论组id
	 * @return 讨论组内所有成员
	 */
	public List<String> getChatUserIds(String chatId);
	/**
	 * 根据讨论组id查找讨论组信息
	 * @param chatId
	 * @return
	 */
	public ChatGroup getChatGroup(String chatId);
	/**
	 * 添加成员到讨论组
	 * @param chatGroup
	 * @return
	 */
	public int[] insertMemberToChatGroup(ChatGroup chatGroup);
	/**
	 * 退出讨论组
	 * @param chatGroup
	 * @return
	 */
	public int[] quitChatGroup(ChatGroup chatGroup);
	/**
	 * 更改讨论组名字
	 * @param chatGroup
	 * @return
	 */
	public int updateChatGroupName(ChatGroup chatGroup);
	/**'
	 * 修改密码
	 */
	public int updatePwd(String telnum,String password);
	
	/**
	 * 添加部门
	 * @param chatGroup 部门信息
	 * @return
	 */
	public Long addGroup(Group group);
	/**
	 * 添加成员到该部门下
	 * @param user 用户信息
	 * @return
	 */
	public int addMemberToGroup(User user);
	/**
	 * 
	 * @param user 手机联系人
	 * @return 注册过联系人信息
	 */
	public List<User> getUserByTelConatacts(List<User> user);
	/**
	 * 根据groupid 查找当前组的信息
	 * @param groupId
	 * @return
	 */
	public Group getGroupById(long groupId);
	/**
	 * 根据用户id  查找用户
	 * @param userId
	 * @return
	 */
	public User getUserById(long userId);
	/**
	   更新组的信息
	 * @param group
	 * @return
	 */
	public int updateGroup(Group group);
	/**
	 * 删除组，并将组下的其他部门删除，成员不再任何一个组内
	 * @param parentId 要删除的部门的id 
	 * @param targetId 要将其下员工更改为哪个部门
	 * @return
	 */
	public int deleteGroup(Long parentId,Long targetId);
	/**
	 * 查询该部门下的所有子部门
	 * @param group
	 * @return
	 */
	public List<Long> getAllChildOfGruop(Group group);
	/**
	 * 更改用户所在的部门
	 * @return
	 */
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * 改变用户所在的团队
	 * @param userId
	 * @param groupId
	 */
	public int changeUserGroup(long userId,long groupId);
	public int deleteUserFromGroup(long userId);
	/**
	 * 通过用户id查找当前所在的组
	 * @param userId 用户id
	 * @param companyId 公司id
	 * @return
	 */
	Group getGroupsByUidCid(Long userId,Long companyId);
	
	/**
	 * 创建公司
	 * 柴
	 *
	 */
	public Long createCompany(Company company);
	/**
	 * 创建公司添加多个成员
	 * 柴
	 */
	public int addMembersToCreateGruop(List<User> list,Long groupId);
	/**
	 * 获取所有公告信息
	 * 柴
	 */
	public List<Announcement> getAllAnnouncements();
	/**
	 * 添加公告
	 * 柴
	 */
	public int addAnnouncement(Announcement announcement);
	/**
	 * 根据公司ID查找公司信息
	 * 柴
	 */
	public Company searchCompanyByCompanyId(Long id);
	
	public boolean setUserBoss(long id);
}
